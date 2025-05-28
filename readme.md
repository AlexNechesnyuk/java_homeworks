sequenceDiagram
    actor User as Пользователь
    participant Service as Сервис конфигурации
    participant Hub as TAPOK HUB
    participant Config as Сервер конфигураций
    participant TBox as T-BOX (автомобиль)
    participant ECU as Электронные блоки (ECU)

    User->>Service: Запрос на изменение конфигурации
    activate Service

    Service->>Hub: Запрос информации об автомобиле (VIN)
    activate Hub
    Hub-->>Service: Модификация авто, версии ECU
    deactivate Hub

    Service->>Config: Отправка данных: 
    Service->>Config: - Модификация авто
    Service->>Config: - Текущие версии ECU
    Service->>Config: - Желаемая конфигурация
    activate Config

    alt Конфигурация возможна
        Config-->>Service: CDS для каждого ECU
    else Ошибка конфигурации
        Config-->>Service: Ошибка: конфигурация недостижима
        Service-->>User: Уведомление об ошибке
        deactivate Config
        deactivate Service
        return
    end
    deactivate Config

    Service->>TBox: Отправка CDS и конфигурации
    activate TBox

    loop Для каждого ECU
        TBox->>ECU: Применение CDS
        activate ECU
        ECU-->>TBox: Результат применения
        deactivate ECU
    end

    TBox->>TBox: Анализ ответов ECU
    TBox-->>Service: Итоговый статус конфигурации
    deactivate TBox

    Service->>Hub: Обновление конфигурации авто
    activate Hub
    Hub-->>Service: Подтверждение обновления
    deactivate Hub

    Service-->>User: Результат операции
    deactivate Service

