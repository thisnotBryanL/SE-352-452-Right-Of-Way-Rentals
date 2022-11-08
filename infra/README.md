# INFRA

Short for infrastructure. Anything needed for testing or deployment; such as container definitions.
 

## Application
- 'cd' in root directory 
- `docker build -t rowr:latest .` to locally build image used for application / references in docker-compose 

## DB
- postgresql to be deployed along with rental car application (prod dependency)
- `schema.sql` : Init script responsible for setting up DB table structure on startup
- `data.sql` : Init script responsible for populating tables on startup (executed after schema script)  

## NO SQL
- mongodb to be deployed along with rental car application (prod dependency)
- `mongo-seed` directory contains the credentials used in order to pass login basic authentication and gain access to vehicles/reservations related views in UI


### Complete Build 
- `docker-compose.yml`
```bash
docker compose up -d && sleep 10 && docker ps && sleep 10 && docker logs app && docker logs db && docker logs mongodb
```


### Services (app not included) Build
- `docker-compose_persistence.yml`
- `docker compose -f docker-compose_persistence.yml up --build -d`
- Run application in preferred IDE


### ENV file
Defines the configurable values used in docker build manifests