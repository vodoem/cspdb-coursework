# Project Management System (Spring Boot + PostgreSQL + Thymeleaf)

## Технологии
- Java 21
- Spring Boot 3.x
- Spring Web (MVC)
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven
- Bootstrap 5

## Структура проекта
- `entity` — JPA-сущности по SQL-схеме
- `repository` — Spring Data репозитории
- `service` — бизнес-логика приложения
- `controller` — MVC-контроллеры для страниц
- `dto` — формы и DTO отчетов
- `templates` — Thymeleaf-шаблоны
- `static` — CSS

## Соответствие SQL-схеме
Схема БД не изменяется. JPA-мэппинг повторяет таблицы:
- справочники: `company_position`, `project_type`, `project_role`, `task_status`, `task_type`
- сущности: `employee`, `projects`, `task`
- связи: `employee_project_role`, `employee_task_on_project`

## Функциональность
- Главная страница `/`
- Проекты: `/projects`, `/projects/{id}`
- Сотрудники: `/employees`, `/employees/{id}`
- Задачи: `/tasks`, `/tasks/{id}`
- Назначения:
  - `/project-assignments/new`
  - `/task-assignments/new`
- Отчеты:
  - `/reports/projects-payload`
  - `/reports/employee-workload`
  - `/reports/overdue-tasks`

## Настройки БД
Параметры в `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5434/cspdb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=validate
```

> `ddl-auto=validate` — Hibernate только проверяет структуру таблиц и не создает их.

## Запуск
1. Убедиться, что PostgreSQL запущен и схема создана SQL-скриптом из задания.
2. Проверить параметры подключения в `application.properties`.
3. Собрать проект:
   ```bash
   mvn clean package
   ```
4. Запустить приложение:
   ```bash
   mvn spring-boot:run
   ```
5. Открыть в браузере: `http://localhost:8080/`

## Примечания
- Основной интерфейс — серверный рендеринг Thymeleaf.
- REST API, Security, Docker, Liquibase/Flyway не используются.
- Для форм добавлена базовая валидация и дружелюбные сообщения о дубликатах назначений.
