
from Printer import Printer

class MFP(Printer):
    """
    Похідний клас, що представляє Багатофункціональний Пристрій (БФП).
    Успадковує функціональність друку від Printer та додає сканування/копіювання.
    """
    
    def __init__(self, model: str, print_speed: int, has_scanner: bool = True):
        """
        Конструктор класу MFP. Викликає конструктор базового класу.
        :param model: Назва моделі БФП.
        :param print_speed: Швидкість друку у стор/хв.
        :param has_scanner: Чи має пристрій функцію сканування.
        """
        # Виклик конструктора базового класу (Printer)
        super().__init__(model, print_speed)
        
        self.has_scanner = has_scanner # Додаткова властивість MFP
        self._scan_resolution = 600    # Роздільна здатність сканування, dpi
        print(f"БФП '{self._model}' ініціалізовано. Доступний сканер: {self.has_scanner}.")

    def scan_document(self, document_name: str):
        """
        Метод для сканування документа.
        :param document_name: Назва документа, що сканується.
        """
        if not self.has_scanner:
            print(f"*** ПОМИЛКА: БФП '{self._model}' не підтримує функцію сканування.")
            return

        print(f"Сканування документа '{document_name}' з роздільною здатністю {self._scan_resolution} dpi... Успішно.")

    def make_copy(self, pages: int, copies: int):
        """
        Метод для копіювання документа. Комбінує сканування та друк.
        :param pages: Кількість сторінок документа.
        :param copies: Кількість копій.
        """
        total_pages_to_print = pages * copies
        print(f"Початок копіювання: {pages} стор. у {copies} копіях. Всього сторінок: {total_pages_to_print}.")
        
        # Використовуємо функціональність сканування 
        self.scan_document("Оригінал для копіювання")
        
        # Використовуємо успадковану функціональність друку 
        self.print_document(total_pages_to_print)


if __name__ == "__main__":
    xerox = MFP("Xerox WorkCentre 6515", 28)
    xerox.make_copy(pages=2, copies=3)
    xerox.add_paper(50)
    xerox.scan_document("Моя лабораторна робота")