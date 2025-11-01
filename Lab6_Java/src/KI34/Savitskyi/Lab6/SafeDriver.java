package KI34.Savitskyi.Lab6;

/**
 * Головний клас для тестування реалізації Сейфу
 */
public class SafeDriver {
    /**
     * Головний метод програми
     * @param args параметри командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        // Тестування сейфу з цінними предметами
        Safe<Valuable> valuableSafe = new Safe<>(5);
        System.out.println("Тестування сейфу з цінними предметами:");

        valuableSafe.putItem(new Valuable("Золотий злиток", 50000.0));
        valuableSafe.putItem(new Valuable("Діамант", 75000.0));
        valuableSafe.putItem(new Valuable("Рубін", 25000.0));

        System.out.println("Найцінніший предмет: " + valuableSafe.findMax());
        System.out.println("Видалений предмет: " + valuableSafe.removeItem());
        System.out.println("Розмір сейфу: " + valuableSafe.getSize());

        // Тестування сейфу з документами
        Safe<Document> documentSafe = new Safe<>(3);
        System.out.println("\nТестування сейфу з документами:");

        documentSafe.putItem(new Document("Контракт", 8));
        documentSafe.putItem(new Document("Патент", 10));
        documentSafe.putItem(new Document("Чек", 3));

        System.out.println("Найважливіший документ: " + documentSafe.findMax());
        System.out.println("Видалений документ: " + documentSafe.removeItem());
        System.out.println("Розмір сейфу: " + documentSafe.getSize());
    }
}
