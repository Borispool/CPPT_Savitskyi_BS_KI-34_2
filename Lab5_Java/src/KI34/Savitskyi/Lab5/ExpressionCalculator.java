package KI34.Savitskyi.Lab5;

import java.io.FileWriter;
import java.io.IOException;

public class ExpressionCalculator {

    /**
     * Обчислює вираз y = ctg(x)/(sin(2x)+4cos(x)).
     *
     * @param x значення змінної x в радіанах
     * @return результат обчислення виразу
     * @throws CalcException якщо виникає помилка ділення на нуль (ctg або зна-менник)
     */
    public double calculate(double x) throws CalcException {
        
        double rad = x * Math.PI / 180.0;

        double sinX = Math.sin(rad);
        if (Math.abs(sinX) < 1e-9) {
            throw new CalcException("Помилка: sin(x) = 0, котангенс не визначе-ний.");
        }

        double denominator = Math.sin(2 * rad) + 4 * Math.cos(rad);
        if (Math.abs(denominator) < 1e-9) {
            throw new CalcException("Помилка: знаменник (sin(2x) + 4cos(x)) = 0.");
        }

        double cotangent = Math.cos(rad) / sinX;
        double result = cotangent / denominator;

        
        if (Double.isNaN(result)) {
             throw new CalcException("Помилка: результат не є числом (NaN).");
        }

        return result;
    }

    /**
     * Записує результат обчислення у файл.
     * @param filePath шлях до файлу для запису
     * @param result результат обчислення
     * @throws IOException якщо виникає помилка запису у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }
}
