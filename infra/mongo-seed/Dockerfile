FROM mongo:latest
COPY customercreds.json /customercreds.json
CMD mongoimport --host mongo --db rowr --collection CustomerCredentials --drop --file /customercreds.json --jsonArray