package KI34.Savitskyi.lab2;

import java.io.IOException;

/**
 * Клас PrinterDriver є точкою входу в програму.
 * Демонструє роботу з принтером через виклик різних методів, таких як друк, заміна картриджа,
 * перевірка стану, очищення та калібрування.
 */
public class PrinterDriver {
    /**
     * Головний метод, що виконує демонстрацію функціональності принтера.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            Printer printer = new Printer(
                    new CartridgeSystem(80),
                    new PaperTray(90),
                    new PrintingMechanism()
            );
            printer.addPaper(10);
            printer.print("Документ 1");
            printer.print("Документ 2");
            printer.replaceCartridge();
            printer.checkStatus();
            printer.cleanPrintHead();
            printer.calibrate();
            printer.enableEcoMode();
            printer.disableEcoMode();
            printer.needsCartridgeReplacement();
            printer.viewPrintHistory();
            printer.clearPaperTray();

            printer.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}

