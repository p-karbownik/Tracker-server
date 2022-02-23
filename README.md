# Tracker-server
Backendowa część aplikacji zrealizowana w ramach przedmiotu "Wytwarzanie aplikacji internetowych i korporacyjnych" na Politechnice Warszawskiej.

Aplikacja pozwala na zbieranie statystyk ze strony internetowej, która wykorzystuje bibliotekę: https://github.com/p-karbownik/Tracker-library .

Część frontendowa aplikacji znajduje się pod adresem: https://github.com/p-karbownik/Tracker-website

Technologie wykorzystane w projekcie:

- Java 11
- SpringBoot
- Maven
- PostgreSQL
- MongoDB
- Lombok
- Jenkins
- Docker

Poszczególne kroki służące uruchomieniu aplikacji:
- zbudowanie pliku .jar: mvn clean install
- zbudowanie obrazu: docker build -t <nazwa_obrazu> . 
- uruchomienie obrazu: docker run -p <port_hosta>:8080 <nazwa_obrazu>

Pozostali Autorzy:
- Aleksandra Okrutny (https://github.com/aleokr)
- Aniela Kosek (https://github.com/aksek)
- Zuzanna Santorowska (https://github.com/HasuNoHana)
