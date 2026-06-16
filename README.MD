# Data Standardisation API

## About

The Data Standardisation API is a micro-service that allows the user to input a String of text
and apply data standardisation to that text. The service allows the user to choose the level of
standardisation via the endpoint:

#### /fullStandardise
`/fullStandardise` endpoint takes a String to be standardised and applies all available
data standardisers to the String.

```
Input:              "Tuomas Petäjä, 21056879"
Output:             "TUOMAS PETAJA " 
```

#### /singleStandardise
`/singleStandardise` endpoint takes a String to be standardised and a valid standardiser name,
then applies the requested data standardiser to the String.

```
Input:              "Tuomas Petäjä, 21056879"
StandardiserName:   "ToUpperCase"

Output:             "TUOMAS PETAJA, 21056879"
```

#### /multipleStandardise
`/multipleStandardise` endpoint takes a map of String to be standardised and an arrayList
of valid standardiser objects, then applies the requested data standardisers to the String.

```
Input:              "Tuomas Petäjä, 21056879"
StandardiserName:   {"ToUpperCase", "RemovePunctuation", "RemoveNumbers"}

Output:             "TUOMAS PETAJA "
```

## Setup

1. Ensure Postgres db is available 
2. Add the following config in src/main/resources/application.properties:
    ```
    server.port=8081

    spring.datasource.url=jdbc:postgresql://<HOSTNAME:PORT>/<DB_USER>
    spring.datasource.username=<DB_USER>
    spring.datasource.password=<DB_PASS>
    ```
2. Create audit table (if not already present):
    ```
    CREATE TABLE standardise_audit(  
        record_id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
        date_time TIMESTAMP NOT NULL,
        term VARCHAR(255),
        standardisation_method VARCHAR(255),
        output_term VARCHAR(255)
    );
    ```
3. Run `mvn spring-boot:run` to stand up the spring boot application server (localhost port 8081)
4. Run `cd ui/ && npm run serve` to start the vue.js front-end server


## Swagger

The Swagger UI can be accessed at
``
http://localhost:8081/swagger-ui/index.html
``.

The Swagger source JSON can be accessed at
``
http://localhost:8081/v3/api-docs
``.
