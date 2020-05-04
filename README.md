# ProjetYuGiOh
## Présentation
Projet qui utilise l'architecture MVC dans une application android codé en Java.

Cette application permet de se renseigner sur le jeu de cartes YuGiOh.
Elle utilise l'API de Github permettant d'aller chercher les informations nécessaires pour l'affichage.

## Prérequis
- Installation d'Android Studio
- Si vous utiliser git via un terminal pour récupérer le projet :
    - Pull la branche Master ( git pull origin master )
    
    Ou bien :
    - git clone https://github.com/Raffael93/ProjetYuGiOh.git

## Consignes respectées
- Architecture MVC
- Appels d'une API Rest
- Sauvegarde de donnée en cache
- 6 écrans : 6 activités
- Affichage d'une liste dans un RecyclerView
- Affichage du détail d'un item de la liste
- Fonctions supplémentaires ajoutés par moi-même :
    - Pdf Viewer qui permet de lire les règles du jeu de carte
    - Affichage d'une liste dans une GridView 
    - Video Viewer permettant d'afficher une vidéo en tant que qu'écran de démarrage
    
## Fonctionnalités 

### Premier écran
![Vidéo de démarrage](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/d%C3%A9but.PNG)

Si vous voulez voir la vidéo en entière, voici le lien : 

https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/video.mp4

### Ecran home
Menu permettant de lier les règles, la banlist et les cartes avec 3 bouttons

![Menu](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/main.PNG)

### Ecran règles
![regle](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/regle_debut.PNG)
![regle](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/regle_scroll.PNG)

### Ecran banlist
- Affiche les noms des cartes qui sont ban

![banlist](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/banlist.PNG)

### Ecran cartes jouables
- Affiche les noms des cartes qui sont jouables

![carte](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/allCardsAPI.PNG)

- Chaque élément de la gridView est cliquable :
  - Cela emmène vers le détail de la carte choisis
  
![carte](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/allCardsAPIClick.PNG)

- L'application permet de regarder les cartes jouables sans connection internet

![carte](https://github.com/Raffael93/ProjetYuGiOh/blob/master/image/saveDataWorks.PNG)

