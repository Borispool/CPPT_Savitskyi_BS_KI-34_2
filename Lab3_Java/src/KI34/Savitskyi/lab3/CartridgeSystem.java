package KI34.Savitskyi.lab3;

/**
 * Клас CartridgeSystem представляє систему картриджів принтера.
 * Містить методи для перевірки рівня чорнила, використання чорнила, заміни картриджа та управління режимом економії чорнила.
 */
public class CartridgeSystem {
    private int inkLevel;
    private boolean ecoMode;

    /**
     * Конструктор за замовчуванням, ініціалізує картридж із рівнем чорнила 100% та вимкненим режимом економії чорнила.
     */
    public CartridgeSystem() {
        this.inkLevel = 100;
        this.ecoMode = false;
    }

    /**
     * Конструктор із параметром рівня чорнила. Ініціалізує систему картриджів із заданим рівнем чорнила.
     *
     * @param inkLevel початковий рівень чорнила
     */
    public CartridgeSystem(int inkLevel) {
        this.inkLevel = inkLevel;
        this.ecoMode = false;
    }

    /**
     * Перевіряє, чи є достатньо чорнила для друку.
     *
     * @return true, якщо рівень чорнила більше нуля, false - в іншому випадку
     */
    public boolean hasEnoughInk() {
        return inkLevel > 0;
    }

    /**
     * Використовує чорнило для друку. Зменшує рівень чорнила на 1 одиницю в режимі економії і на 2 одиниці в звичайному режимі.
     */
    public void useInk() {
        inkLevel -= ecoMode ? 1 : 2;
        if (inkLevel < 0) inkLevel = 0;
    }

    /**
     * Замінює картридж, встановлюючи рівень чорнила на 100%.
     */
    public void replace() {
        inkLevel = 100;
    }

    /**
     * Повертає поточний рівень чорнила.
     *
     * @return рівень чорнила у відсотках
     */
    public int getInkLevel() {
        return inkLevel;
    }

    /**
     * Вмикає режим економії чорнила, що зменшує витрату чорнила під час друку.
     */
    public void enableEcoMode() {
        ecoMode = true;
    }

    /**
     * Вимикає режим економії чорнила.
     */
    public void disableEcoMode() {
        ecoMode = false;
    }
}


