### Setup
1. `make setup` to run docker container of postgres
2. `make run` to run application
2.1. Alternatively application can be deployed in a container (`docker compose up -d app`)
### Config
Configurable params are stored in `src/main/resources/application.yaml`
```
spring:
  datasource:
    ...
    ## fields related to the database setup
    ...

server:
  port: 8080 <-- port, application will be running on
  
integrations:
  jobs:
    draft-application-status-check-ms: 15000 <-- ms delay between cron for revisiting draft applications executions
  *bank integration name*:
    base: ... <-- base url for the bank integration endpoint
    enabled: true <-- a way to turn off integration for the specified bank
```