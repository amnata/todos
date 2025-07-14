
# todos
Ce projet a pour but de vousfamiliariser avec les pratiques CI/CD, les tests automatisés et la qualité logicielle via un cas concret en Java + Spring Boot.  Chaque groupe travaillera à partir du code source fourni et réalisera l’ensemble des tâches dans un nouveau dépôt GitHub collaboratif.


📌 Projet CI/CD avec Java, Spring Boot et Docker
🎯 Objectif pédagogique
Ce projet a pour but de vous familiariser avec les pratiques CI/CD, les tests automatisés et la qualité logicielle via un cas concret en Java + Spring Boot.
 Chaque groupe travaillera à partir du code source fourni et réalisera l’ensemble des tâches dans un nouveau dépôt GitHub collaboratif.


✅ Objectifs généraux (par ordre de priorité)
1️⃣ Tests unitaires (importance élevée)
TagServiceImpl


TagResource


2️⃣ Tests fonctionnels avec Cucumber (importance moyenne)
Pour les nouvelles fonctionnalités liées aux Tags


3️⃣ Configuration des pipelines CI/CD (importance très élevée)
pr.yml et build.yml selon les spécifications ci-dessous


🔁 pr.yml – Pipeline de Pull Request
🎯 But : Vérifier la qualité du code avant fusion. Ce pipeline s'exécute à la création et à chaque commit d’une pull request. 
Étapes attendues :
Checkout du code (branche de la PR)


Scan de secrets (ex : Gitleaks, GitGuardian, ...)


Scan des vulnérabilités des dépendances (ex : OWASP Dependency-Check, risque de ralentir les buil, peut être configuré et commenté pendant la phase de config )


Compilation et tests


Analyse Quality Gate avec Sonar (ex: SonarCloud)


Vérification du Quality Gate


⚠️ Si une étape échoue, les suivantes sont annulées.




🚀 build.yml – Pipeline de Build & Déploiement
🎯 Objectif : Automatiser les étapes de test, analyse, release, build Docker et déploiement après chaque merge dans main ou master selon la config.
🔧 Étapes clés :
Checkout du code 


Scan de secrets


Scan des vulnérabilités des dépendances


Compilation et tests


Analyse qualité de code avec Sonar


Vérification du Quality Gate



🔖 Release


Lire la version depuis version.txt


Incrémenter la version (1.0 → 1.1)


Commit du fichier version.txt


Création d’un tag Git : v1.1


🐳 Build and Publish to Docker


Construire deux images Docker :


monapp:<version> (ex. todo:1.1)


monapp:latest


Pousser les deux images sur Docker Hub (ou autre registre)


🚀 Déploiement optionnel mais encouragé


⚠️ Règles importantes :
Le pipeline s’interrompt dès qu’une étape échoue


version.txt est la source de vérité


Toujours publier deux images : :latest et :<version>



🛠️ Prérequis
Chaque groupe doit :
être composée de 4 à 6 élèves
Créer un nouveau dépôt GitHub dénommé todos
Ajouter tous les membres du groupe
Ajouter le professeur :


GitHub : seenibu


Email : senei@ept.sn


Le projet de base vous sera fourni via la classe virtuelle



📊 Attentes de qualité (via Sonar)
Quality Gate : Passed


Reliability : A


Security : A


Maintainability : A


Coverage : ≥ 95 %


Duplications : < 1 %


Couverture de test de 100 % pour TagServiceImpl et TagResource


Aucun bug, vulnérabilité ou erreur critique



📝 Modalités d’évaluation
Réalisation complète des objectifs 


Respect des délais


Qualité et conformité du code, des tests et des pipelines


Clarté et pertinence du rapport final


Qualité de la démonstration (capsule vidéo)


🧾 Contenu attendu dans le rendu
Votre rapport de projet devra inclure :
Liste des membres du groupe


Lien vers une capsule vidéo illustrant les résultats obtenus
 (la vidéo doit couvrir toute la chaîne : configuration, exécution, résultats)


Captures ou lien vers les résultats Sonar


Toute information utile 



📅 Date limite
🗓️ 19 juillet 2025 à 23h59
 📤 Mode de rendu : via la plateforme Classroom

