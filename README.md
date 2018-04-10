# CrowdFunding

1. Installer l'environnement de dev

Importer le projet de GitHub
Editer la configuration : profil = dev, paramètre : secret=... (à définir)
Installer une DB mySQL locale crowdfunding

2. Installer l'environnement de prod

2.1 Packager le .jar : mvnw clean install
2.2 Transférer le .jar du folder Back-End/target sur le server dans le folder /home/debian
2.2bis Si nécessaire, arrêter le process java en cours (ps -ef | grep "crowd", puis kill -9)
2.3 Lancer le ./crowdfunding.sh

2.4 pour le front-end, builder la prod : ng build --prod
2.5 Transférer du folder Front-End/dist dans le folder /var/www/html
