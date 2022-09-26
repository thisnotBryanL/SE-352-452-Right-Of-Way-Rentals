# INFRA

Short for infrastructure. Anything needed for testing or deployment; such as container definitions. 

## DB 
- postgresql to be deployed along with rental car application (prod dependency)
- `schema.sql` : Init script responsible for setting up DB table structure on startup 
- `data.sql` : Init script responsible for populating tables on startup (executed after schema script)  