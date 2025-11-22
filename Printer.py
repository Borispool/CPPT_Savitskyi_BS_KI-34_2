class Printer:
    """
    Базовий клас, що представляє Принтер.
    Реалізує функціональність друку.
    """
    
    def __init__(self, model: str, print_speed: int):
        """
        Конструктор класу Printer.
        :param model: Назва моделі принтера.
        :param print_speed: Швидкість друку у стор/хв.
        """
        self._model = model  # Захищене поле для моделі
        self._print_speed = print_speed
        self._paper_count = 100 # Початкова кількість паперу
        print(f"Принтер '{self._model}' ініціалізовано.")

    def print_document(self, pages: int):
        """
        Метод для друку документа.
        Перевіряє наявність паперу.
        :param pages: Кількість сторінок для друку.
        """
        if pages > self._paper_count:
            print(f"*** ПОМИЛКА: Недостатньо паперу для друку {pages} сторінок. Залишилося: {self._paper_count}.")
            return
        
        self._paper_count -= pages
        print(f"Друк {pages} сторінок на принтері '{self._model}'... Успішно.")
        print(f"Залишок паперу: {self._paper_count} аркушів.")

    def get_model(self):
        """Повертає модель принтера."""
        return self._model

    def add_paper(self, count: int):
        """Додає папір у лоток."""
        self._paper_count += count
        print(f"Додано {count} аркушів паперу. Всього: {self._paper_count}.")

if __name__ == "__main__":
    hp = Printer("HP LaserJet 1020", 14)
    hp.print_document(5)
    hp.print_document(150)
    hp.add_paper(200)
    hp.print_document(10)