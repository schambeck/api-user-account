# User Accounts
[![build](https://github.com/schambeck/api-userAccount-account/actions/workflows/gradle.yml/badge.svg)](https://github.com/schambeck/api-userAccount-account/actions/workflows/gradle.yml)
[![Quality Gate Status Contract](https://sonarcloud.io/api/project_badges/measure?project=schambeck_api-userAccount-account_contract&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=schambeck_api-userAccount-account_contract)
[![Quality Gate Status Impl](https://sonarcloud.io/api/project_badges/measure?project=schambeck_api-userAccount-account_impl&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=schambeck_api-userAccount-account_impl)
[![Coverage Contract](https://sonarcloud.io/api/project_badges/measure?project=schambeck_api-userAccount-account_contract&metric=coverage)](https://sonarcloud.io/summary/new_code?id=schambeck_api-userAccount-account_contract)
[![Coverage Impl](https://sonarcloud.io/api/project_badges/measure?project=schambeck_api-userAccount-account_impl&metric=coverage)](https://sonarcloud.io/summary/new_code?id=schambeck_api-userAccount-account_impl)

## Teck Stack

- Java 11 (Amazon Corretto)
- Spring Boot
- MySQL, Flyway
- Swagger
- Redis Cache
- JUnit 5, Mockito, JaCoCo
- Spring Boot Admin
- Spring Cloud OpenFeign

## Build artifact

    ./gradlew clean build

Executable file generated: contract/build/libs/api-userAccount-account-1.0.0.jar

### Run application

    java -jar contract/build/libs/api-userAccount-account-1.0.0.jar

### Run tests

    ./gradlew test

Reports generated:
- [contract/build/reports/tests/test/index.html](contract/build/reports/tests/test/index.html)
- [impl/build/reports/tests/test/index.html](impl/build/reports/tests/test/index.html)

### Run JaCoCo Test Report

    ./gradlew jacocoTestReport

Reports generated:
- [contract/build/reports/jacoco/test/html/index.html](contract/build/reports/jacoco/test/html/index.html)
- [impl/build/reports/jacoco/test/html/index.html](impl/build/reports/jacoco/test/html/index.html)

## Swagger

- [http://localhost:8080](http://localhost:8080)

## Actuator

- [http://localhost:8080/actuator](http://localhost:8080/actuator)
