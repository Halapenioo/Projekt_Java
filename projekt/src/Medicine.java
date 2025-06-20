package model;

import java.util.Objects;

/**
 * Klasa reprezentująca pojedynczy lek
 * Przykład hermetyzacji i przeciążania metod
 */
public class Medicine {
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private String expirationDate;

    // Przeciążony konstruktor
    public Medicine(String name, String manufacturer, double price, int quantity, String expirationDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public Medicine(int id, String name, String manufacturer, double price, int quantity, String expirationDate) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    // Gettery i settery (hermetyzacja)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    // Przesłonięta metoda toString()
    @Override
    public String toString() {
        return String.format("ID: %d | %s | Producent: %s | Cena: %.2f | Ilość: %d | Ważny do: %s",
                id, name, manufacturer, price, quantity, expirationDate);
    }

    // Przesłonięte metody equals() i hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}