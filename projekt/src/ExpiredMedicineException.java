package exceptions;

/**
 * Niestandardowy wyjątek dla przeterminowanych leków
 */
public class ExpiredMedicineException extends Exception {
    public ExpiredMedicineException(String message) {
        super(message);
    }
}