#Data Standardisation API

##About

The Data Standardisation API is a micro-service that allows the user to input a String of text
and apply data standardisation to that text. The service allows the user to choose the level of
standardisation via the endpoint:

####/fullStandardise
`/fullStandardise` endpoint takes a String to be standardised and applies all available
data standardisers to the String.

```
Input:              "Tuomas Petäjä, 21056879"
Output:             "TUOMAS PETAJA " 
```

####/singleStandardise
`/singleStandardise` endpoint takes a String to be standardised and a valid standardiser name,
then applies the requested data standardiser to the String.

```
Input:              "Tuomas Petäjä, 21056879"
StandardiserName:   "ToUpperCase"

Output:             "TUOMAS PETAJA, 21056879"
```

####/multipleStandardise
`/multipleStandardise` endpoint takes a map of String to be standardised and an arrayList
of valid standardiser objects, then applies the requested data standardisers to the String.

```
Input:              "Tuomas Petäjä, 21056879"
StandardiserName:   {"ToUpperCase", "RemovePunctuation", "RemoveNumbers"}

Output:             "TUOMAS PETAJA "
```

##Swagger

The Swagger UI can be accessed at
``
http://localhost:8080/swagger-ui/
``.

The Swagger source JSON can be accessed at
``
http://localhost:8080/v2/api-docs
``.
