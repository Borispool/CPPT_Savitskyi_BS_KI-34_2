import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab1SavitskyiKI304 {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);

            System.out.println("Введіть розмір матриці: ");
            int row = sc.nextInt();

            System.out.println("Введіть символ заповнювач: ");
            String symbol = sc.next();

            if (symbol.length() != 1) {
                System.out.println("Введіть коректний символ заповнювач.");
                return;
            }

            String fileName = "Lab1.txt";
            printMatrix(symbol, row, fileName);
            

        } catch (IOException e) {
            System.err.println("Сталася помилка під час запису в файл: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    /**.
     * Метод, що генерує і виводить ромб в консоль та файл.
     * Працює як з парними, так і з непарними розмірами матриці.
     *
     * @param symbol символ заповнювач
     * @param row розмір матриці
     * @param file назва файлу
     * @throws IOException якщо сталася помилка при записі в файл
     */
    public static void printMatrix(String symbol, int row, String file) throws IOException {
        System.out.println("Результат матриці: ");

        try (FileWriter writer = new FileWriter(file)) {
            int mid = row / 2;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    if (Math.abs(i - mid) + Math.abs(j - mid) <= mid) {
                        writer.write(symbol + " ");
                        System.out.print(symbol + " ");
                    } else {
                        writer.write("  ");
                        System.out.print("  ");
                    }
                }
                writer.write("\n");
                System.out.println();
            }
        }
    }
}