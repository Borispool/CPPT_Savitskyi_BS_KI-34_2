package KI34.Savitskyi.Lab6;

/**
 * Параметризований клас Сейф, що може зберігати різні типи елементів
 * @param <T> тип елементів, що зберігаються в сейфі
 */

public class Safe<T extends Comparable<T>> {
    private T[] items;
    private int capacity;
    private int size;

    /**
     * Конструктор створює новий Сейф із вказаною ємністю
     * @param capacity максимальна кількість елементів, що можуть зберігатися
     */
    @SuppressWarnings("unchecked")
    public Safe(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    /**
     * Додає елемент до сейфу, якщо є вільне місце
     * @param item елемент для додавання до сейфу
     * @return true якщо елемент успішно додано, false якщо сейф повний
     */
    public boolean putItem(T item) {
        if (size < capacity) {
            items[size++] = item;
            return true;
        }
        return false;
    }

    /**
     * Видаляє та повертає останній елемент із сейфу
     * @return видалений елемент або null якщо сейф порожній
     */
    public T removeItem() {
        if (size > 0) {
            T item = items[--size];
            items[size] = null;
            return item;
        }
        return null;
    }

    /**
     * Знаходить максимальний елемент у сейфі
     * @return максимальний елемент або null якщо сейф порожній
     */
    public T findMax() {
        if (size == 0) return null;

        T max = items[0];
        for (int i = 1; i < size; i++) {
            if (items[i].compareTo(max) > 0) {
                max = items[i];
            }
        }
        return max;
    }

    /**
     * Повертає поточну кількість елементів у сейфі
     * @return кількість елементів, що зберігаються
     */
    public int getSize() {
        return size;
    }

    /**
     * Перевіряє чи сейф порожній
     * @return true якщо сейф не містить елементів, false в іншому випадку
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
