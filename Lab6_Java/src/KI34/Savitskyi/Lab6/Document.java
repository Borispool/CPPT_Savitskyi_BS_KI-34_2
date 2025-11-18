package KI34.Savitskyi.Lab6;

/**
 * Клас, що представляє документи, які можуть зберігатися в сейфі
 */

class Document implements Comparable<Document> {
    private String title;
    private int importance;

    /**
     * Конструктор створює новий документ
     * @param title назва документу
     * @param importance рівень важливості (1-10)
     */
    public Document(String title, int importance) {
        this.title = title;
        this.importance = importance;
    }

    @Override
    public int compareTo(Document other) {
        return Integer.compare(this.importance, other.importance);
    }

    @Override
    public String toString() {
        return title + " (важливість: " + importance + ")";
    }
}
