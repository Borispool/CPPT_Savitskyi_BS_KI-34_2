package KI34.Savitskyi.Lab5;

import java.io.*;

/**
 * Клас для роботи з файлами: запис та читання результату
 * обчислення (типу double) у текстовому та двійковому форматах.
 *
 * @version 1.0
 */
public class ResultIO {

    /**
     * Записує результат (double) у текстовий файл.
     *
     * @param result   Результат обчислення
     * @param filename Ім'я файлу
     * @throws IOException Помилка запису у файл
     */
    public void writeResultTxt(double result, String filename) throws IOException {
        // Використовуємо try-with-resources, щоб PrintWriter закрився автоматично
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(result);
        }
    }

    /**
     * Зчитує результат (double) з текстового файлу.
     *
     * @param filename Ім'я файлу
     * @return Прочитаний результат (double)
     * @throws IOException Помилка читання файлу
     * @throws NumberFormatException Помилка, якщо в файлі не число
     */
    public double readResultTxt(String filename) throws IOException, NumberFormatException {
        // Використовуємо try-with-resources, щоб BufferedReader закрився автоматично
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("Файл порожній.");
            }
            return Double.parseDouble(line);
        }
    }

    /**
     * Записує результат (double) у двійковий файл.
     *
     * @param result   Результат обчислення
     * @param filename Ім'я файлу
     * @throws IOException Помилка запису у файл
     */
    public void writeResultBin(double result, String filename) throws IOException {
        // Використовуємо try-with-resources
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeDouble(result);
        }
    }

    /**
     * Зчитує результат (double) з двійкового файлу.
     *
     * @param filename Ім'я файлу
     * @return Прочитаний результат (double)
     * @throws IOException Помилка читання файлу (напр. EOFException - кінець файлу)
     */
    public double readResultBin(String filename) throws IOException {
        // Використовуємо try-with-resources
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            return dis.readDouble();
        }
    }
}