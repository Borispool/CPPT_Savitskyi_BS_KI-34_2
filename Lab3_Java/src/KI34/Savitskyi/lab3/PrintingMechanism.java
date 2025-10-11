package KI34.Savitskyi.lab3;

/**
 * Клас PrintingMechanism представляє механізм друку в принтері.
 * Містить методи для перевірки готовності, очищення і калібрування механізму.
 */
public class PrintingMechanism {
    private boolean ready;

    /**
     * Конструктор за замовчуванням, ініціалізує механізм друку як готовий до роботи.
     */
    public PrintingMechanism() {
        this.ready = true;
    }

    /**
     * Перевіряє, чи готовий механізм до друку.
     *
     * @return true, якщо механізм готовий, false - в іншому випадку
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Очищає механізм друку, встановлюючи його в стан готовності.
     */
    public void clean() {
        ready = true;
    }

    /**
     * Калібрує механізм друку, встановлюючи його в стан готовності.
     */
    public void calibrate() {
        ready = true;
    }
}


