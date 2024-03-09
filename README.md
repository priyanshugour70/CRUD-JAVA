# CRUD using Java & MySql

## Overview
    - Author :: Priyanshu Gour
    - Java Version  :: 17
    - Database :: MySQL
    - MySql Version :: 8.2.0

## Description
We are creating a CRUD(C-create, R-read, U-update, D-delete) application using Java and MySql.
we are insearting the data in database.

## Prerequisites
1. Java [Core java & JDBC basic]
2. MySql [MySql]


## Structure of code
```
CRUD-JDBC
|-- README.md
|-- bin
|-- src
    |-- com
        |-- pg
            |-- controller
                |-- StudentController.java
                |-- impl
                    |-- StudentControllerImpl.java
            |-- dto
                |-- Student.java
            |-- factory
                |-- StudentControllerFactory.java
                |-- StudentRepoFactory.java
                |-- StudentServiceFactory.java
            |-- properties
                |-- database.properties
            |-- repository
                |-- StudentRepo.java
                |-- impl
                    |-- StudentRepoImpl.java
            |-- service
                |-- StudentService.java
                |-- impl
                    |-- StudentServiceImpl.java
            |-- utility
                |-- JdbcUtil.java
```


## Database Setup
1. Create Database
```sql
CREATE DATABASE pwskills;
```

2. Use Database
```sql
USE pwskills;
```

3. Create Table
```sql
CREATE TABLE student (
    sid INT PRIMARY KEY,
    sname VARCHAR(50) NOT NULL,
    sage INT,
    saddress VARCHAR(100),
    sclass VARCHAR(20),
    sdob DATE
);
```

