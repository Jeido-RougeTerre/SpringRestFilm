# Cinémathèque

## Sujet

Créer une application cinémathèque qui comportera les routes suivantes :

- `catalogue/ ` - Pour la page d'accueil
- `catalogue/films` - La liste des films
- `catalogue/realisateur` - La liste des réalisateurs
- `catalogue/film/<id>` - La fiche d'un film
- `catalogue/realisateur/<id>` - La fiche d'un réalisateur

1. Créer les modèles

- film
  - id 
  - nom 
  - date de sortie 
  - description 
  - durée 
  - genre 
  - realisateur

- realisateur
  - id 
  - nom 
  - prenom 
  - date de naissance 
  - nationalité 

2. Implémenter les méthodes permettant de faire un CRUD des deux modèles précédemment créés
3. Créer les méthodes pour :
   - Récupérer les films
   - Récupérer un film par son id
   - Récupérer les réalisateurs
   - Récupérer un réalisateur par son id
   - Récupérer les films par réalisateur
