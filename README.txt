Questions :

- L'EDT est un thread charg� de g�rer toute modification graphique.
- Son r�le c'est de modifier les �l�ments graphiques.
- Un �l�ment Thread-Safe est un �l�ment dont plusieurs threads ne peuvent pas acc�der ET modifier en m�me temps. l'EDT n'est pas Thread-sage. C'est justement pour �a qu'on g�re tous les �l�ments graphics dans un seul thread
- 404
- Parce que Java n'a pas de pointeurs donc communiquer entre deux classes, c'est gal�re.