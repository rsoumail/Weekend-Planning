##PROJET TAA-GLI: Planification de week-ends


##INSTALLATION
1.
   Lancement de la commande du projet

		Faire un mvn package

2.
   Application de frond end

	   	Dans le dossier webapp/src/main/docker/

				Commande : docker build -t weekendplanning-front .

   Application de back end

		Dans le dossier weekendpalnning/target/

			Commande : docker build -t weekendplanning-back .

3.
	Création du réseau

		Commande : docker netowrk create weekend-network
	
	Dans le dossier src/main/docker/frontend/

	   Lancement d'un conteneur

			Commande : docker-compose -f app.yml up


	Dans le dossier src/main/docker/backend/

		Eteindre 

		Commande : docker-compose -f app.yml down

Ce projet réalisé fait suite aux cours de TAA & GLI que nous avons eu en premier semestre. De ce fait nous étions amenée à mettre en place 
les technologies recommandées par le projet. Pour celà nous avons réalisé l'architecture de l'application comme suite:

	=> Modèle de métier 
	
		Diagramme de classe: Nous avons fait le diagramme de classe en fonction du cahier de charge
		
	=> Spring 

		Domaine: Nous avons utilisées les annotations de JPA sur les entités du domaine

		Repositories: Les données de spring sur JPARepository

		Services: L'archictecture du service REST à l'API

		Swagger: 
		
	
	=> Base de donnée
		
		Utilisation de MySQL
		
		
Conclusion:

Ce projet était d'une grande importance, car nous a permis de mieux comprendre, l'architecture en couches du modèle MVC, 
que nous avons utilisé tout au long du projet. 
