FROM mongo:latest
COPY customercreds.json /customercreds.json
CMD mongoimport --host mongo --db rowr --collection CusterCredentialCollection --drop --file /customercreds.json --jsonArray