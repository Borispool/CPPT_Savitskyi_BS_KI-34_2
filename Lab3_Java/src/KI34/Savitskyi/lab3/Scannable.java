package KI34.Savitskyi.lab3;

import java.io.IOException;

/**
 * Інтерфейс для сканування документів.
 */
public interface Scannable {
    /**
     * Метод для сканування документа.
     *
     * @param documentName Назва документа для сканування
     * @throws IOException якщо виникає помилка під час сканування
     */
    void scan(String documentName) throws IOException;
}
