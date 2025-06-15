package model;

import exceptions.ExpiredMedicineException;
import java.util.ArrayList;
import java.util.List;

/**
 * Główna klasa zarządzająca lekami (CRUD + wyjątki)
 */
public class Pharmacy {
    private final List<Medicine> medicines = new ArrayList<>();
    private int nextId = 1;

    // Operacje CRUD
    public void addMedicine(Medicine medicine) throws ExpiredMedicineException {
        if (isExpired(medicine.getExpirationDate())) {
            throw new ExpiredMedicineException("Lek ma przeterminowaną datę ważności: " + medicine.getExpirationDate());
        }
        medicine.setId(nextId++);
        medicines.add(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return new ArrayList<>(medicines);
    }

    public Medicine findMedicineById(int id) {
        for (Medicine med : medicines) {
            if (med.getId() == id) {
                return med;
            }
        }
        return null;
    }

    public void updateMedicine(Medicine updatedMedicine) throws ExpiredMedicineException {
        if (isExpired(updatedMedicine.getExpirationDate())) {
            throw new ExpiredMedicineException("Nie można zaktualizować - przeterminowana data");
        }

        for (int i = 0; i < medicines.size(); i++) {
            if (medicines.get(i).getId() == updatedMedicine.getId()) {
                medicines.set(i, updatedMedicine);
                return;
            }
        }
        throw new IllegalArgumentException("Lek o ID " + updatedMedicine.getId() + " nie istnieje");
    }

    public void deleteMedicine(int id) {
        Medicine medicine = findMedicineById(id);
        if (medicine != null) {
            medicines.remove(medicine);
        } else {
            throw new IllegalArgumentException("Lek o ID " + id + " nie istnieje");
        }
    }

    // Prosta walidacja daty (RRRR-MM-DD)
    private boolean isExpired(String date) {
        // W rzeczywistym projekcie należy użyć LocalDate
        return date.compareTo("2023-12-31") < 0; // Przykład: data ważności przed 2024 rokiem
    }
}