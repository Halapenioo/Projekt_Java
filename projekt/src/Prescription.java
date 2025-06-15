package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca receptę (przykład kompozycji)
 */
public class Prescription {
    private String number;
    private String doctorName;
    private final List<Medicine> medicines = new ArrayList<>();

    public Prescription(String number, String doctorName) {
        this.number = number;
        this.doctorName = doctorName;
    }

    // Kompozycja: recepta zawiera listę leków
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
    }

    public List<Medicine> getMedicines() {
        return new ArrayList<>(medicines);
    }

    @Override
    public String toString() {
        return "Recepta nr: " + number + " | Lekarz: " + doctorName + " | Ilość leków: " + medicines.size();
    }
}