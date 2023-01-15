##Build a REST service in Java

#1. Compile and run application:
 - Open a terminal (git bash, powershell, cmd) inside the project folder
 - Run command: mvn clean install
 - Run command: mvn spring-boot:run

#2. The application Swagger is in the URL: 
 - http://localhost:8080/swagger-ui.html

#3. H2
 - http://localhost:8080/h2/
 - URL jdbc:h2:mem:clients
 - username diogo
 - password @123456

#4. Dockerfile
 - Run the published image on docker hub > docker run -p 8080:8080 diogolages/client:1.0
 - Generate image from api local > docker build -t diogolages/client:1.0 .
 - Run image in container local > docker run -p 8080:8080 diogolages/client:1.0
 
#5. Heroku
 - https://diogolages-client-rest-api.herokuapp.com/swagger-ui.html
## Authentication
	 - user: diogo
	 - password: Dlt@21#

	 - user: capitani
	 - password: C@pitan1
 
#6. Repository in Github
 - https://github.com/DiogoLages/client-rest-api/
 
 