package ru.otus.java.basic.homeworks;


public class User {
    private String name, surname, patronymic;
    private int yearOfBirth;
    private String email;

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public User(String name, String surname, String patronymic, int yearOfBirth, String email) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public void traceInfo() {
        System.out.println("ФИО: " + name + " " + surname + " " + patronymic);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("e-mail: " + email);
    }

    public static void main(String[] arg) {
        final int CURRENT_YEAR = 2025;
        User[] user = new User[10];

        for (int i = 0; i < user.length; i++) {
            user[i] = new User("Name" + i, "Surname" + i, "Patronymic" + i, i + 1980, "email" + i + "@gmail.com");
        }

        for (User u : user) {
            if (CURRENT_YEAR - u.getYearOfBirth() > 40) {
                u.traceInfo();
                System.out.println();
            }
        }
    }
}
