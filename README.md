# Tracker-server

Uruchomienie projektu przy użyciu Dockera (wymagany zainstalowany Docker):
- zbudowanie pliku jar: mvn clean install
- zbudowanie obrazu: docker build -t <nazwa_stworzonego_obrazu> . 
- uruchomienie obrazu: docker run <nazwa_stworzonego_obrazu>
- obraz uruchamia się domyślnie na porcie 8080, w celu zmienienia portu należy dodać w komendzie uruchmiającej dockera opcje -p<nowy_port>:8080
