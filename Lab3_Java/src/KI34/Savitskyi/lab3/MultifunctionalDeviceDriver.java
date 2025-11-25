package KI34.Savitskyi.lab3;

import java.io.IOException;

/**
 * Клас PrinterDriver є точкою входу в програму.
 * Демонструє роботу з принтером через виклик різних методів, таких як друк, заміна картриджа,
 * перевірка стану, очищення та калібрування.
 */
public class MultifunctionalDeviceDriver {
    /**
     * Головний метод, що виконує демонстрацію функціональності принтера.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            MultifunctionalDevice device = new MultifunctionalDevice();
            device.addPaper(10);
            device.print("Документ 1");
            device.scan("Сканований документ 1");
            device.copy("Документ для копіювання");
            device.replaceCartridge();
            device.checkStatus();
            device.cleanPrintHead();
            device.calibrate();
            device.enableEcoMode();
            device.disableEcoMode();
            device.needsCartridgeReplacement();
            device.viewPrintHistory();
            device.clearPaperTray();

            device.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
