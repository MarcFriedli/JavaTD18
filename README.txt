Questions :

- L'EDT est un thread chargé de gérer toute modification graphique.
- Son rôle c'est de modifier les éléments graphiques.
- Un élément Thread-Safe est un élément dont plusieurs threads ne peuvent pas accéder ET modifier en même temps. l'EDT n'est pas Thread-sage. C'est justement pour ça qu'on gère tous les éléments graphics dans un seul thread
- 404
- Parce que Java n'a pas de pointeurs donc communiquer entre deux classes, c'est galère.