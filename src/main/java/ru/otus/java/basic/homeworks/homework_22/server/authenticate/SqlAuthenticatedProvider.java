package ru.otus.java.basic.homeworks.homework_22.server.authenticate;
import ru.otus.java.basic.homeworks.homework_22.server.AuthenticatedProvider;
import ru.otus.java.basic.homeworks.homework_22.server.ClientHandler;
import ru.otus.java.basic.homeworks.homework_22.server.Server;

import java.sql.*;

public class SqlAuthenticatedProvider implements AuthenticatedProvider {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/db";
    private static final String DATABASE_USER = "user";
    private static final String DATABASE_PASSWORD = "pass";

    private static final String USER_ROLE_BY_EMAIL_PASSWORD_QUERY = """
            SELECT r.name AS role_name, r.isAdmin
            FROM users u
            JOIN usertorole ur ON u.id = ur.userid
            JOIN role r ON ur.roleid = r.id
            WHERE u.email = ? AND u.password = ?;
            """;

    private static final String USER_ROLE_BY_EMAIL_QUERY = """
            SELECT r.name AS role_name, r.isAdmin
            FROM users u
            JOIN usertorole ur ON u.id = ur.userid
            JOIN role r ON ur.roleid = r.id
            WHERE u.email = ?;
            """;

    private static final String USER_ADMIN_BY_EMAIL_QUERY = """
            SELECT r.name AS role_name, r.isAdmin
            FROM users u
            JOIN usertorole ur ON u.id = ur.userid
            JOIN role r ON ur.roleid = r.id
            WHERE u.email = ? and r.isAdmin = true;
            """;

    private final Connection connection;
    private Server server;


    public SqlAuthenticatedProvider(Server server) {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.server = server;
    }

    @Override
    public void initialize() {
        System.out.println("Сервис аунтентификации запущен: SQL режим");
    }

    private String getUserInfoByLoginAndPassword(String login, String password) {
        boolean flag = false;
        try (PreparedStatement ps = connection.prepareStatement(USER_ROLE_BY_EMAIL_PASSWORD_QUERY)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return login;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private boolean isLoginAlreadyExists(String login) {
        boolean flag = false;
        try (PreparedStatement ps = connection.prepareStatement(USER_ROLE_BY_EMAIL_QUERY)) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUserInfoByLoginAndPassword(login, password);
        if (authUsername == null) {
            clientHandler.sendMsg("Некорректный логин/пароль");
            return false;
        }
        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        clientHandler.setUsername(authUsername);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername + " " + authUsername);
        return true;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String username) {
        if (login.length() < 3) {
            clientHandler.sendMsg("Логин должен быть 3+ символа");
            return false;
        }
        if (username.length() < 3) {
            clientHandler.sendMsg("Имя пользователя должна быть 3+ символа");
            return false;
        }
        if (password.length() < 3) {
            clientHandler.sendMsg("Пароль должен быть 3+ символа");
            return false;
        }
        if (isLoginAlreadyExists(login)) {
            clientHandler.sendMsg("Такой логин уже занят");
            return false;
        }
        insertUser(password, login);
        clientHandler.setUsername(username);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);
        return true;
    }

    private void insertUser(String password, String email) {
        try {
            connection.setAutoCommit(false);
            try (PreparedStatement userStmt = connection.prepareStatement(
                    "INSERT INTO users (password, email) VALUES (?, ?) RETURNING id",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)) {
                userStmt.setString(1, password);
                userStmt.setString(2, email);
                ResultSet rs = userStmt.executeQuery();
                if (rs.next()) {
                    int userId = rs.getInt(1);
                    try (PreparedStatement roleStmt = connection.prepareStatement(
                            "INSERT INTO usertorole (userid, roleid) VALUES (?, (SELECT id FROM role WHERE name = 'user'))")) {
                        roleStmt.setInt(1, userId);
                        roleStmt.executeUpdate();
                    }
                }
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    @Override
    public boolean isAdmin(String login) {
        boolean flag = false;
        try (PreparedStatement ps = connection.prepareStatement(USER_ADMIN_BY_EMAIL_QUERY)) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
