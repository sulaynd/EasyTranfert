# Secure microservice with Keycloak

Comment faire pour sécuriser votre microservice developper avec spring boot ? Pour cela nous allons utilisé keycloak. 
![enter image description here](ArchitectureGlobaleGatewayeEreukaMicroService.jpg)

**Keycloak** est un produit logiciel open source permettant la connexion unique avec la gestion des identités "Identity management"  et la gestion des accès "Gestion des accès" destinées aux applications et services modernes. Depuis mars 2018, ce projet communautaire JBoss est sous la direction de Red Hat, qui l'utilise comme projet en amont (développement logiciel)") pour leur produit RH-SSO.


# Installation et démarrage keycloak

Tres facile, pour installer keycloak il suffit de telecharger le zip de la version standalone sur le [site web de keycloak]("[https://www.keycloak.org/downloads](https://www.keycloak.org/downloads)"). Decompresser le fichier sur votre machine et positionner vous sur le repertoire /bin puis executer l'application 
> keycloak-10.0.1/bin/standalone.bat
> 
Apres le demarrage du service, acceder a l'interface via 

> http://votreHost:8080 dans notre cas nous sommes en localhost

- Créer un profil Admin
- Créer votre application a sécurisée
- Créer un ou plusieurs utilisateurs 
- Créer les roles de votre choix
- Affecter a chaque utilisateur un rôle

## MicroService SpringBoot

Ici nous supposons que vous avez déjà créer votre micro-service. Pour notre cas le micro-service permet d’accéder a la ressource suivante 
> http://localhost:8081/contributions

1. Dans notre code nous allons prendre la précaution d'exposer les ID des contribution avec Spring Data.
> @Autowired  
private RepositoryRestConfiguration restConfiguration;
.
public void run(String... args) throws Exception {
	restConfiguration.exposeIdsFor(Contribution.class);
}

