This project is a sample spring boot microservices project. It is a simple web application used to store Magic:The gathering decks, and consists of:
* card-frontend: The Angular.js frontend for the application.
* card-service: The Rest enabled service, also containing a in memory database for storing decks. As per the 12-factor apps, the real database will be a separate microservice
* card-discovery: The Eureka discovery service, enabling modules to communicate with each other much more loosely among other things.
* card-config: The exteranlized config server - This server will fetch the configuration for each client from a github repository and inject it into the client based on the spring-.application.name property (also used by Eureka)

All of these modules are separate microservices, and can be packaged and run as docker containers. 
There is also a docker module, which will allow you to fire up the enire application with the command "docker-compose up"

All of these micorservices aim to use the Netflix OSS/Spring cloud stack. Currently it features:
* Zuul for server side load balancing (in the frontend project)
* Eureka service discovery (discovery project)
* Externalized config (config project)
* Spring actuators (service project) for many cool REST enabled endpoint like for instance health checks.

Stuff not implemented yet but which will be soon:
* Hystrix/Turbine for cool looking GUI monitoring
