switchyard-bp
=============

1. Build the project:
    mvn clean install
2. Replace your server's standalone.xml with src/main/resources/standalone.xml
2. Start JBoss AS 7 in standalone mode (other modes are fine too):
    ${AS}/bin/standalone.sh
3. Create database table using h2 console. To do that download [h2console](https://github.com/jboss-jdf/jboss-as-quickstart/blob/master/h2-console/h2console.war).
4. Open browser page http://localhost:8080/h2console
5. Put following data in connection parameters
    - connection url: jdbc:h2:mem:test;DB_CLOSE_DELAY=-1
    - username: sa
    - password: sa
6. Copy contents of src/main/resources/schema.sql file and execute query.
7. Create some gas stations
	- INSERT INTO GasStation (id, name) VALUES (1, 'Test1')
	- INSERT INTO GasStation (id, name) VALUES (2, 'Test2')
8. Deploy the project
9. Open SoapUi
10. Create SoapUi project
	- Name: WebService
	- URL: http://localhost:8080/switchyard-bp/WebService?wsdl
11. Execute request, valid values for stationType are:
	- STATIC
	- DB
12. Enjoy