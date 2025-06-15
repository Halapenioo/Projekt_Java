Projekt - System do Zarządzania Lekami - Oskar Guła
System do zarządzania lekami w aptece
Opis
Aplikacja konsolowa napisana w Javie implementująca kompleksowy system zarządzania lekami w aptece. Umożliwia dodawanie, przeglądanie, aktualizację i usuwanie leków (CRUD) z uwzględnieniem dat ważności i kontrolą przeterminowanych produktów.

Struktura aplikacji
Main - klasa startowa z menu głównym

Medicine - klasa reprezentująca lek z polami: ID, nazwa, producent, cena, ilość, data ważności

Prescription - klasa reprezentująca receptę z listą leków (przykład kompozycji)

Pharmacy - główna klasa zarządzająca z implementacją operacji CRUD

ExpiredMedicineException - niestandardowy wyjątek dla przeterminowanych leków

Kluczowe funkcjonalności
Zarządzanie lekami:

Dodawanie nowych leków z walidacją daty ważności

Przeglądanie pełnej listy leków

Aktualizacja istniejących pozycji

Usuwanie leków z systemu

Walidacja danych:

Sprawdzanie dat ważności leków

Kontrola poprawności wprowadzanych danych

Obsługa błędów i wyjątków

Przykład recepty:

Demonstracja relacji kompozycji między receptą a lekami

Możliwość tworzenia przykładowych recept z listą leków

Działanie
Uruchom klasę Main

Wybierz opcję z menu:

Dodaj nowy lek (nazwa, producent, cena, ilość, data ważności)

Wyświetl listę wszystkich leków

Zaktualizuj istniejący lek

Usuń lek z systemu

Pokaż przykład recepty

Zakończ program

Dane przechowywane w pamięci (ArrayList dla leków)

Program zawiera pełną walidację danych i obsługę wyjątków

Wymagania techniczne
Java 17+

Środowisko IDE (IntelliJ, Eclipse) lub narzędzia wiersza poleceń do kompilacji
### Autor
Oskar Guła  
Uniwersytet Rzeszowski  
Informatyka i Ekonometria

Rok akademicki: 2024/2025
