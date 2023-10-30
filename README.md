# POIS [![Build Status](https://www.travis-ci.com/grupoesfera/CAP-00106-CSD-POIS.svg?branch=master)](https://www.travis-ci.com/grupoesfera/CAP-00106-CSD-POIS)
Sistema de puntos de interés

## Tecnologías utilizadas
1. Java 11
2. Maven 3.6.3

## Proyecto
La herramienta de base del proyecto es [Spring Boot](https://spring.io/projects/spring-boot) utilizando una base de datos en memoria
de [H2](https://www.h2database.com/html/main.html).

Además se utiliza [Flyway](https://flywaydb.org/) para versionar la construcción de la base
de datos. El versionador se ejecuta al iniciar la aplicación.

Para construir las pruebas de aceptación se utiliza [Cucumber](https://cucumber.io/docs/installation/java/)
con la herramienta de reportes llamada [Cluecumber](https://github.com/trivago/cluecumber-report-plugin)

### Pruebas

#### Construcción
Para compilar el proyecto simplemente ejecutamos
```bash
mvn clean compile
```
Para generar el paquete de la aplicación
```bash
mvn clean package
```

#### Correr pruebas

Solo unitarias
```bash
mvn clean test
``` 

Todas las pruebas
```bash
mvn clean verify
``` 

Para ver los reportes luego de correr las pruebas abrirmos el archivo
ubicado en `target/cluecumber-report/index.html`

### CI

Usamos actions de github
