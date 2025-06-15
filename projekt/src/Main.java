import exceptions.ExpiredMedicineException;
import model.Medicine;
import model.Pharmacy;
import model.Prescription;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Pharmacy pharmacy = new Pharmacy();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Konsumuj pozostały newline

            switch (choice) {
                case 1 -> addMedicine();
                case 2 -> showAllMedicines();
                case 3 -> updateMedicine();
                case 4 -> deleteMedicine();
                case 5 -> showPrescriptionExample();
                case 6 -> exit = true;
                default -> System.out.println("Nieprawidłowy wybór!");
            }
        }
        System.out.println("Program zakończony.");
    }

    private static void printMenu() {
        System.out.println("\n=== System Zarządzania Lekami ===");
        System.out.println("1. Dodaj nowy lek");
        System.out.println("2. Wyświetl wszystkie leki");
        System.out.println("3. Aktualizuj lek");
        System.out.println("4. Usuń lek");
        System.out.println("5. Pokaż przykład recepty");
        System.out.println("6. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    private static void addMedicine() {
        System.out.print("Nazwa leku: ");
        String name = scanner.nextLine();

        System.out.print("Producent: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Cena: ");
        double price = scanner.nextDouble();

        System.out.print("Ilość: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Konsumuj newline

        System.out.print("Data ważności (RRRR-MM-DD): ");
        String expirationDate = scanner.nextLine();

        try {
            Medicine medicine = new Medicine(name, manufacturer, price, quantity, expirationDate);
            pharmacy.addMedicine(medicine);
            System.out.println("Lek dodany pomyślnie! ID: " + medicine.getId());
        } catch (ExpiredMedicineException e) {
            System.err.println("Błąd: " + e.getMessage());
        }
    }

    private static void showAllMedicines() {
        List<Medicine> medicines = pharmacy.getAllMedicines();
        if (medicines.isEmpty()) {
            System.out.println("Brak leków w systemie.");
            return;
        }
        System.out.println("\nLista leków:");
        medicines.forEach(System.out::println);
    }

    private static void updateMedicine() {
        System.out.print("Podaj ID leku do aktualizacji: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Konsumuj newline

        Medicine medicine = pharmacy.findMedicineById(id);
        if (medicine == null) {
            System.out.println("Lek o podanym ID nie istnieje!");
            return;
        }

        System.out.println("Aktualne dane: " + medicine);
        System.out.print("Nowa nazwa (enter - pomiń): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) medicine.setName(name);

        System.out.print("Nowy producent (enter - pomiń): ");
        String manufacturer = scanner.nextLine();
        if (!manufacturer.isEmpty()) medicine.setManufacturer(manufacturer);

        System.out.print("Nowa cena (0 - pomiń): ");
        double price = scanner.nextDouble();
        if (price > 0) medicine.setPrice(price);

        System.out.print("Nowa ilość (0 - pomiń): ");
        int quantity = scanner.nextInt();
        if (quantity > 0) medicine.setQuantity(quantity);

        scanner.nextLine();  // Konsumuj newline
        System.out.print("Nowa data ważności (enter - pomiń): ");
        String expirationDate = scanner.nextLine();
        if (!expirationDate.isEmpty()) medicine.setExpirationDate(expirationDate);

        try {
            pharmacy.updateMedicine(medicine);
            System.out.println("Lek zaktualizowany pomyślnie!");
        } catch (ExpiredMedicineException e) {
            System.err.println("Błąd aktualizacji: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Błąd: " + e.getMessage());
        }
    }

    private static void deleteMedicine() {
        System.out.print("Podaj ID leku do usunięcia: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Konsumuj newline

        try {
            pharmacy.deleteMedicine(id);
            System.out.println("Lek usunięty pomyślnie!");
        } catch (IllegalArgumentException e) {
            System.err.println("Błąd: " + e.getMessage());
        }
    }

    private static void showPrescriptionExample() {
        Prescription prescription = new Prescription("RW/2023/123", "Dr Kowalski");
        prescription.addMedicine(new Medicine("Apap", "USP", 15.99, 2, "2025-06-30"));
        prescription.addMedicine(new Medicine("Ibuprom", "Polfa", 12.50, 1, "2024-12-31"));

        System.out.println("\nPrzykład recepty:");
        System.out.println(prescription);
        System.out.println("Leki na recepcie:");
        prescription.getMedicines().forEach(System.out::println);
    }
}