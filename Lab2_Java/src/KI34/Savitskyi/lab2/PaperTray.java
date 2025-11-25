package KI34.Savitskyi.lab2;

/**
 * Клас PaperTray представляє лоток для паперу в принтері.
 * Містить методи для додавання паперу, використання аркушів, перевірки наявності паперу та отримання кількості аркушів у лотку.
 */
public class PaperTray {
    private int paperCount;
    private final int capacity;

    /**
     * Конструктор за замовчуванням, ініціалізує лоток із місткістю 100 аркушів і порожнім лотком.
     */
    public PaperTray() {
        this.capacity = 100;
        this.paperCount = 0;
    }

    /**
     * Конструктор із параметром місткості лотка. Ініціалізує лоток із заданою місткістю і порожнім лотком.
     *
     * @param capacity максимальна кількість аркушів, яку може вмістити лоток
     */
    public PaperTray(int capacity) {
        this.capacity = capacity;
        this.paperCount = 0;
    }

    /**
     * Перевіряє, чи є в лотку папір.
     *
     * @return true, якщо в лотку є аркуші, false - в іншому випадку
     */
    public boolean hasPaper() {
        return paperCount > 0;
    }

    /**
     * Використовує один аркуш паперу з лотка, якщо є аркуші.
     */
    public void usePaper() {
        if (paperCount > 0) paperCount--;
    }

    /**
     * Додає задану кількість аркушів до лотка. Якщо додане значення перевищує місткість лотка, кількість аркушів не перевищує його місткість.
     *
     * @param sheets кількість аркушів для додавання
     */
    public void addPaper(int sheets) {
        paperCount = Math.min(paperCount + sheets, capacity);
    }

    /**
     * Повертає поточну кількість аркушів у лотку.
     *
     * @return кількість аркушів у лотку
     */
    public int getPaperCount() {
        return paperCount;
    }
}
