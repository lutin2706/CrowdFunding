# CrowdFunding

1. Installer l'environnement de dev

Importer le projet de GitHub
Editer la configuration : profil = dev, paramètre : secret=... (à définir)
Installer une DB mySQL locale crowdfunding

2. Installer l'environnement de prod

2.1 Packager le .jar : mvn xxxxx
2.2 Transférer le .jar sur le server dans le folder /home/debian
2.2bis Si nécessaire, arrêter le process java en cours (ps -ef | grep "crowd", puis kill -9)
2.3 Lancer le ./crowdfunding.sh
