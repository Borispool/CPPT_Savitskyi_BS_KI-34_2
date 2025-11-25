package KI34.Savitskyi.Lab5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас-драйвер для тестування коректності роботи класу ResultIO.
 *
 * @version 1.0
 */
public class Lab5App {

    public static void main(String[] args) {
        // Імена файлів для тесту
        final String TEXT_FILE = "result.txt";
        final String BINARY_FILE = "result.bin";

        // Ініціалізуємо об'єкти
        ExpressionCalculator calculator = new ExpressionCalculator();
        ResultIO ioManager = new ResultIO();
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Отримуємо X та рахуємо оригінальний результат
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();
            double originalResult = calculator.calculate(x);
            System.out.println("Оригінальний результат: " + originalResult);
            System.out.println("-------------------------------------");

            // 2. Тестуємо запис
            ioManager.writeResultTxt(originalResult, TEXT_FILE);
            System.out.println("Результат записано у " + TEXT_FILE);
            
            ioManager.writeResultBin(originalResult, BINARY_FILE);
            System.out.println("Результат записано у " + BINARY_FILE);
            System.out.println("-------------------------------------");

            // 3. Тестуємо читання
            double resultFromText = ioManager.readResultTxt(TEXT_FILE);
            System.out.println("Результат, прочитаний з " + TEXT_FILE + ": " + resultFromText);

            double resultFromBinary = ioManager.readResultBin(BINARY_FILE);
            System.out.println("Результат, прочитаний з " + BINARY_FILE + ": " + resultFromBinary);
            System.out.println("-------------------------------------");
            
            ioManager.write(TEXT_FILE, resultFromBinary, 0);
            System.out.println("Результат записано у " + TEXT_FILE);
            
            double resultfromRandomaccses = ioManager.read(TEXT_FILE, 0);
            System.out.println("Результат, прочитаний з допомогою RandomAccessFile"+ ": "+ resultfromRandomaccses);

            ioManager.write(BINARY_FILE, resultFromBinary, 0);
            System.out.println("Результат записано у " + BINARY_FILE);
            
            double resultfromRandomaccsesBinary = ioManager.read(BINARY_FILE, 0);
            System.out.println("Результат, прочитаний з допомогою RandomAccessFile"+ ": "+ resultfromRandomaccsesBinary);
           
            // 4. Перевіряємо коректність
            if (originalResult == resultFromText && originalResult == resultFromBinary) {
                System.out.println("ТЕСТ ПРОЙДЕНО: Всі результати збігаються.");
            } else {
                System.out.println("ТЕСТ ПРОВАЛЕНО: Результати не збігаються.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Помилка: Введено нечислове значення для x.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Виникла неочікувана помилка: " + e.getMessage());
        } finally {
            scanner.close(); // Обов'язково закриваємо Scanner
        }
    }
}