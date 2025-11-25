package KI34.Savitskyi.lab3;

import java.io.IOException;

/**
 * Клас MultifunctionalDevice розширює функціональність {@link Printer} та реалізує інтерфейс {@link Scannable},
 * що дозволяє виконувати функції друку, сканування та копіювання документів.
 *
 * <p>Багатофункціональний пристрій поєднує можливості принтера та сканера, дозволяючи виконувати копіювання
 * документів шляхом їх сканування і наступного друку. Всі операції супроводжуються логуванням для забезпечення
 * відстеження виконання завдань.
 */
public class MultifunctionalDevice extends Printer implements Scannable {

    /**
     * Конструктор за замовчуванням для створення екземпляра багатофункціонального пристрою.
     *
     * @throws IOException якщо виникає помилка при створенні логера
     */
    public MultifunctionalDevice() throws IOException {
        super();
    }

    /**
     * Виконує друк документа на багатофункціональному пристрої.
     *
     * @param document назва або зміст документа для друку
     * @return true, якщо друк успішний, false - якщо недостатньо ресурсів (чорнила, паперу або пристрій не готовий)
     * @throws IOException якщо виникає помилка при друку
     */
    @Override
    public boolean print(String document) throws IOException {
        logger.log("Початок друку документа на багатофункціональному пристрої");
        System.out.println("Початок друку документа на багатофункціональному пристрої");

        if (cartridgeSystem.hasEnoughInk() && paperTray.hasPaper() && printingMechanism.isReady()) {
            cartridgeSystem.useInk();
            paperTray.usePaper();
            printHistory.add(document);

            System.out.println("Друкую: " + document);
            logger.log("Документ успішно надруковано на багатофункціональному пристрої");
            return true;
        }

        logger.log("Друк неможливий: недостатньо ресурсів");
        System.out.println("Друк неможливий: недостатньо ресурсів");
        return false;
    }

    /**
     * Виконує сканування документа.
     *
     * @param documentName назва документа для сканування
     * @throws IOException якщо виникає помилка при скануванні
     */
    @Override
    public void scan(String documentName) throws IOException {
        logger.log("Початок сканування документа: " + documentName);
        System.out.println("Сканування документа: " + documentName);
        // Логіка сканування документа
        logger.log("Документ успішно відскановано");
        System.out.println("Документ успішно відскановано");
    }

    /**
     * Метод для копіювання документа, який поєднує сканування та друк.
     *
     * @param documentName назва документа для копіювання
     * @throws IOException якщо виникає помилка під час копіювання
     */
    public void copy(String documentName) throws IOException {
        logger.log("Початок копіювання документа: " + documentName);
        System.out.println("Копіювання документа: " + documentName);

        scan(documentName);
        print("Копія: " + documentName);

        logger.log("Документ успішно скопійовано");
        System.out.println("Документ успішно скопійовано");
    }
}
