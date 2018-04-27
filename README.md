# Weekend Planning : Planification de week-ends

A web platform that advice users to plan their weekends according their preferences


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

## PRESENTATION

Ce projet réalisé fait suite aux cours de TAA & GLI que nous avons eu en premier semestre. De ce fait nous étions amenée à mettre en place 
les technologies recommandées par le projet. Pour celà nous avons réalisé l'architecture de l'application comme suite:

	=> Modèle de métier 
	
		Diagramme de classe: Nous avons fait le diagramme de classe en fonction du cahier de charge
		
	=> Spring 

		Domaine: Nous avons utilisées les annotations de JPA sur les entités du domaine

		Repositories: Les données de spring sur JPARepository

		Services: L'archictecture du service REST à l'API
		
	
	=> Base de donnée
		
		Utilisation de MySQL
		
		
Conclusion:

Ce projet était d'une grande importance, car nous a permis de mieux comprendre, l'architecture en couches du modèle MVC, 
que nous avons utilisé tout au long du projet. 
