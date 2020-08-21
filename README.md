## Getting Started
Con las siguientes instrucciones logrará el correcto
 funcionamiento del proyecto en su máquina local para fines de desarrollo y prueba.
 
### Prerequisites
Lo que necesita para instalar el software:

* Java SDK 8.x or higher
* Maven 3.x or higher

### Building & Testing
Realizar la ejecución de los siguientes comandos:

```
mvn clean            # Clean project
mvn test             # Build & run tests (no integration test)
mvn verify           # Build, run integration test and run static code validation

# Use this for tag execution
mvn clean verify -Dcucumber.filter.tags=@web

```

## Built With
El proyecto usa las siguientes librerias para el Build y Test:

* [Maven](https://maven.apache.org/) - Gestor de dependencias
* [RestAssured](https://github.com/rest-assured/rest-assured/wiki/Usage) - Test API REST
* [SerenityBDD](http://www.thucydides.info/docs/serenity/#first-steps) - Librería SerenityBDD 
* [PMD](https://pmd.github.io/latest/pmd_rules_java.html) - Analizador de código estático
* [Spotbugs](https://find-sec-bugs.github.io/bugs.htm) - Analizador de seguridad en código

## Authors
**EVERIS PERU**  
 *Jesus Ovalle Porras*


## License

Copyright (C) Everis Perú - All Rights Reserved - Proprietary and confidential
