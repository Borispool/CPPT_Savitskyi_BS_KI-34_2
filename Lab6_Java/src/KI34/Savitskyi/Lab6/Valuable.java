package KI34.Savitskyi.Lab6;

/**
 * Клас, що представляє цінні предмети, які можуть зберігатися в сейфі
 */
class Valuable implements Comparable<Valuable> {
    private String name;
    private double value;

    /**
     * Конструктор створює новий цінний предмет
     * @param name назва предмету
     * @param value грошова вартість предмету
     */
    public Valuable(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(Valuable other) {
        return Double.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return name + " (вартість: $" + value + ")";
    }
}
