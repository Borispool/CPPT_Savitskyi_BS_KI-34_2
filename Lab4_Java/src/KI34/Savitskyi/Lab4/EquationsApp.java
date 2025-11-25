package KI34.Savitskyi.Lab4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EquationsApp {

    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);
        String filePath = "result.txt"; 

        try {
            
            System.out.print("Введіть значення x (в градусах): ");
            double x = scanner.nextDouble();

            
            double result = calculator.calculate(x);
            System.out.println("Результат: " + result);

            
            calculator.writeResultToFile(result, filePath);
            System.out.println("Результат записано у файл: " + filePath);

        } catch (CalcException e) {
            System.out.println("Помилка обчислення: " + e.getMessage());
        
        } catch (InputMismatchException e) {
            System.out.println("Помилка вводу: Потрібно було ввести число.");
        
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        
        } finally {
            scanner.close();
            System.out.println("Роботу програми завершено.");
        }
    }
}