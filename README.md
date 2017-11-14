##PROJET TAA-GLI: Planification de week-ends


##INSTALLATION
1.
   Builder le projet par
   
   	Se placer à la racine du projet weekendplanning/

		Lancer la commande : mvn package

2.
   Application de frond end

	   	Se placer dans le dossier weekendplanning/src/main/webapp/
                Lancer la comande : npm install
				Lancer la commande : npm start

   Application de back end

		Se placer dans le dossier weekendpalnning/target/

			Lancer la commande : docker build -t weekendplanning-back .
			
3.
   Création du réseau pour les conteneurs 

		Lancer la commande : docker network create weekend-network
	
4.
   Dans le dossier weekendplanning/src/main/docker/backend/

		Lancer les containers

		Lancer la commande : docker-compose -f app.yml up
		
		Stoper les containers
		
		Lancer la commande : docker-compose -f app.yml down
		

##PRESENTATION

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
