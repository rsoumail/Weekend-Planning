# Weekend Planning

A web platform that advice users to plan their weekends according their preferences

## Requirements
- Docker

## Usage
1. Build project
	On the project's root run the following command : mvn package
  
2. Run Front-End App 
	On weekendplanning/src/main/webapp/ folder run following commands : 
	- npm install
	- npm start

3. Run BackendEnd App
        
	- On weekendpalnning/target/ folder run following command : docker build -t weekendplanning-back .
	- Create network for containers : 
		Run following command : docker network create weekend-network
	- On weekendplanning/src/main/docker/backend/ folder run following command :
		- Runs Container : docker-compose -f app.yml up
 	- To stops containers  you can run : docker-compose -f app.yml down
## Resources

- Java 
- Spring
- AngularJS
