# test-task-shop
### simple Spring boot app 

## Tools
- PostgreSQL
- Tomcat(spring-boot)
- Java11
- Maven

## DB Setting
Create DB with name shopDB
login = postgres, password = postgres
Hibernate will create all tables which we need

## Run an application
- Uncommit method initDB() in ProductServiceImpl for initialization DB , after commit this method
- Compile project use maven and run class TestTaskShopApplication (server.port: 8888)
- Use Postman Address of application: http://localhost:8888/shop//product
send Get http reqest with 2 parametrs:
- nameFilter (Regular Expressions)
- amount (Amount of products in response)

### Example: 

- request (method Get)

http://localhost:8888/shop/product?nameFilter=%5E.*%5B1%5D.*%24&amount=10

- response (Json)

[
    {
        "id": 1,
        "name": "name0",
        "description": "description"
    },
    {
        "id": 3,
        "name": "name2",
        "description": "description"
    },
    {
        "id": 4,
        "name": "name3",
        "description": "description"
    },
    {
        "id": 5,
        "name": "name4",
        "description": "description"
    },
    {
        "id": 6,
        "name": "name5",
        "description": "description"
    },
    {
        "id": 7,
        "name": "name6",
        "description": "description"
    },
    {
        "id": 8,
        "name": "name7",
        "description": "description"
    },
    {
        "id": 9,
        "name": "name8",
        "description": "description"
    },
    {
        "id": 10,
        "name": "name9",
        "description": "description"
    },
    {
        "id": 21,
        "name": "name20",
        "description": "description"
    }
]
