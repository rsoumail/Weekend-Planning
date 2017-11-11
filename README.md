## Fonctionalité
Sign up
Sign in
Selection ensemble de lieu:
	list
	map
	region
Notifier l'user

## taches
Algo pour le choix des activ
Modele, API, documentation (map, place, messaging...)

Cron (tache bash mardi mercredi)
Possibilité pour l'user de proposer un nouv activité


## remarques

Pour une activité il y a des contraintes meteologiques et geologiques. Exemple:
	Activité voil : un peu de vent coté meteo mais, il faut de la flote coté lieu sinon il faut que notre BD contient uniquement des activités sans contraintes geologique

###############################################################################################################################
PROJET TAA-GLI: Planification de week-ends

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
