This application allows you to manage your personal expenses effectively. It provides functionalities to Create, Read, Update, and Delete (CRUD) expense records.
Back-end: Spring Boot (Java)
Database: PostgreSQL

API
POST:
expense/create
{
    "name": "gigante",
    "date": "2024-04-01",
    "amount": 35.00
}

GET:
expense/{id}

GET:
expense/all
