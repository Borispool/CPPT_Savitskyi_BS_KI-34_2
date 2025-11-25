package KI34.Savitskyi.lab3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас Printer представляє принтер із можливостями друку, управління чорнильною системою та паперовим лотком.
 * Містить різноманітні методи для керування друком, калібруванням та перевіркою стану принтера.
 */
public abstract class Printer {
    protected CartridgeSystem cartridgeSystem;
    protected PaperTray paperTray;
    protected PrintingMechanism printingMechanism;
    protected Logger logger;
    protected List<String> printHistory;

    /**
     * Конструктор за замовчуванням, створює новий принтер із чорнильною системою, лотком для паперу та механізмом друку.
     *
     * @throws IOException якщо виникає помилка при створенні логера
     */
    public Printer() throws IOException {
        this.cartridgeSystem = new CartridgeSystem();
        this.paperTray = new PaperTray();
        this.printingMechanism = new PrintingMechanism();
        this.printHistory = new ArrayList<>();
        this.logger = new Logger("printer_log.txt");
        logger.log(String.format("Принтер %s створено.", this.toString()));
    }

    /**
     * Конструктор для створення принтера із заданими параметрами чорнильної системи, лотка для паперу та механізму друку.
     *
     * @param cartridgeSystem чорнильна система
     * @param paperTray лоток для паперу
     * @param printingMechanism механізм друку
     * @throws IOException якщо виникає помилка при створенні логера
     */
    public Printer(CartridgeSystem cartridgeSystem, PaperTray paperTray, PrintingMechanism printingMechanism) throws IOException {
        this.cartridgeSystem = cartridgeSystem;
        this.paperTray = paperTray;
        this.printingMechanism = printingMechanism;
        this.printHistory = new ArrayList<>();
        this.logger = new Logger("printer_log.txt");
        logger.log(String.format("Принтер %s створено.", this.toString()));
    }

    /**
     * Абстрактний метод для друку документа.
     *
     * @param document Документ для друку
     * @return true, якщо друк успішний, false - в іншому випадку
     * @throws IOException якщо виникає помилка під час друку
     */
    public abstract boolean print(String document) throws IOException;

    /**
     * Метод для заміни картриджа.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void replaceCartridge() throws IOException {
        logger.log("Заміна картриджа");
        System.out.println("Заміна картриджа");

        cartridgeSystem.replace();
    }

    /**
     * Метод для додавання паперу.
     *
     * @param sheets Кількість аркушів для додавання
     * @throws IOException якщо виникає помилка під час логування
     */
    public void addPaper(int sheets) throws IOException {
        logger.log(String.format("Додавання %s аркушів паперу", sheets));
        System.out.printf("Додавання %s аркушів паперу\n", sheets);

        paperTray.addPaper(sheets);
    }

    /**
     * Метод для перевірки стану принтера.
     *
     * @return Рядок зі станом принтера
     * @throws IOException якщо виникає помилка під час логування
     */
    public String checkStatus() throws IOException {
        String status = "Стан принтера: \n" +
                "Рівень чорнила: " + cartridgeSystem.getInkLevel() + "%\n" +
                "Кількість паперу: " + paperTray.getPaperCount() + " аркушів\n" +
                "Механізм друку: " + (printingMechanism.isReady() ? "готовий" : "не готовий");

        logger.log(String.format("Перевірка стану принтера: %s", status));
        System.out.printf("Перевірка стану принтера: %s\n", status);

        return status;
    }

    /**
     * Метод для очищення друкуючої головки.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void cleanPrintHead() throws IOException {
        logger.log("Очищення друкуючої головки");
        System.out.println("Очищення друкуючої головки");

        printingMechanism.clean();
    }

    /**
     * Метод для калібрування принтера.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void calibrate() throws IOException {
        logger.log("Калібрування принтера");
        System.out.println("Калібрування принтера");

        printingMechanism.calibrate();
    }

    /**
     * Метод для увімкнення режиму економії чорнила.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void enableEcoMode() throws IOException {
        logger.log("Увімкнення режиму економії чорнила");
        System.out.println("Увімкнення режиму економії чорнила");

        cartridgeSystem.enableEcoMode();
    }

    /**
     * Метод для вимкнення режиму економії чорнила.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void disableEcoMode() throws IOException {
        logger.log("Вимкнення режиму економії чорнила");
        System.out.println("Вимкнення режиму економії чорнила");

        cartridgeSystem.disableEcoMode();
    }

    /**
     * Метод для перевірки необхідності заміни картриджа.
     *
     * @return true, якщо картридж потребує заміни, false - в іншому випадку
     * @throws IOException якщо виникає помилка під час логування
     */
    public boolean needsCartridgeReplacement() throws IOException {
        boolean needs = cartridgeSystem.getInkLevel() < 10;
        logger.log("Перевірка необхідності заміни картриджа: " + (needs ? "потрібна заміна" : "заміна не потрібна"));
        System.out.println("Перевірка необхідності заміни картриджа: " + (needs ? "потрібна заміна" : "заміна не потрібна"));

        return needs;
    }

    /**
     * Метод для перегляду історії друку.
     *
     * @return Список рядків з історією друку
     * @throws IOException якщо виникає помилка під час логування
     */
    public List<String> viewPrintHistory() throws IOException {
        logger.log("Перегляд історії друку");
        System.out.println("Історія друку:");

        for (String entry : printHistory) {
            System.out.println(entry);
        }
        return new ArrayList<>(printHistory);
    }

    /**
     * Метод для очищення лотка для паперу.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void clearPaperTray() throws IOException {
        int removedPaper = paperTray.getPaperCount();
        while (paperTray.getPaperCount() > 0) {
            paperTray.usePaper();
        }
        logger.log(String.format("Очищення лотка для паперу. Видалено %d аркушів.", removedPaper));
        System.out.printf("Лоток для паперу очищено. Видалено %d аркушів.\n", removedPaper);
    }

    /**
     * Закриває логер для збереження даних у файл.
     *
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}
