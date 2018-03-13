# TP3

## Objectif

- Création d’une application simple qui utilise une base de données MongoDB

## Quelles sont les types de données stockés dans Redis, que peut on faire comme types de requêtes? 

### Réponse

Redis permettre stocker d'information du type clé-valeur en memoire RAM, contrairement à d'autres bases de données de clés-valeurs, il comporte de nombreux types de données complexes tels que des listes, des piles (Stack), des files d'attente (Queue), des ensembles, des ensembles ordonnés et des opérations atomiques définies pour ces types de données, la limite de stockage de Redis est de 1 Go. Pour faire des requêtes les principales commandes associées sont SET, GET, INCR, DECR, et GETSET.

- INCR et EXPIRE ensemble à chaque vue d'une page pour qu'un compteur ne compte que les N dernières pages vues séparées par moins de la quantité spécifiée de secondes.
- GETSET pour obtenir atomiquement la valeur de compteur actuelle et la réinitialiser à zéro. Par exemple, il est possible d'enregistrer de sessions d'utilisateur sur un site internet. 
- DECR ou INCRBY, pour gérer des valeurs qui peuvent être plus ou moins importantes selon les opérations effectuées par l'utilisateur. Imaginez par exemple le score de différents utilisateurs dans un jeu en ligne.


## Author

* **MONZON, Christian** - *work* - [cmonzonc](https://github.com/cmonzonc)


## License

This project is licensed under the GNU License.
