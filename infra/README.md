# INFRA

Short for infrastructure. Anything needed for testing or deployment; such as container definitions.
 

## Application
- 'cd' in root directory 
- `docker build -t rowr:latest .` to locally build image used for application / references in docker-compose 

## DB
- postgresql to be deployed along with rental car application (prod dependency)
- `schema.sql` : Init script responsible for setting up DB table structure on startup
- `data.sql` : Init script responsible for populating tables on startup (executed after schema script)  
