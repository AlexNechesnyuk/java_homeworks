
```plantuml
@startuml
actor Пользователь
participant Сервис
participant "TAPOK HUB" as Hub
participant "Сервер конфигураций" as Config
participant "T-BOX" as TBox
participant ECU

Пользователь -> Сервис: Запрос изменения конфигурации
Сервис -> Hub: Запрос информации об авто
Hub --> Сервис: Данные авто и ECU
Сервис -> Config: Отправка данных
Config --> Сервис: CDS для ECU или ошибка

alt Ошибка конфигурации
    Сервис --> Пользователь: Уведомление об ошибке
else Успешно
    Сервис -> TBox: Пакет CDS и конфигурация
    TBox -> ECU: Применить CDS 1
    ECU --> TBox: Результат 1
    TBox -> ECU: Применить CDS 2
    ECU --> TBox: Результат 2
    TBox --> Сервис: Итоговый статус
    Сервис -> Hub: Обновить конфигурацию
    Hub --> Сервис: Подтверждение
    Сервис --> Пользователь: Результат операции
end
@enduml
'''