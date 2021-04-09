# Tracker-server
Pusty projekt został wygenerowany za pomocą https://start.spring.io/. Jest realizowany w strukturze Maven, testy jednostkowe wykonujemy za pomocą JUnit. Używamy jacoco, jest realizowany jaco stage mavena.

Aby wygenerować ładnie wyglądające raporty jacoco użyj: mvn jacoco:report

Uruchomienie projektu przy użyciu Dockera (wymagany zainstalowany Docker):
- zbudowanie pliku jar: mvn clean install
- zbudowanie obrazu: docker build -t <nazwa_stworzonego_obrazu> . 
- uruchomienie obrazu: docker run <nazwa_stworzonego_obrazu>
- obraz uruchamia się domyślnie na porcie 8080, w celu zmienienia portu należy dodać w komendzie uruchmiającej dockera opcje -p<nowy_port>:8080
