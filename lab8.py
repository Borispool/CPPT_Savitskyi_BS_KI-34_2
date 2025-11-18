import math
import struct
import os

# Функція обчислення виразу за варіантом 19
def calculate(x):
    
    tan_val = math.tan(x)
    if abs(tan_val) < 1e-9: 
        raise ZeroDivisionError("Тангенс надто близький до нуля (x ≈ 0, 180...)")
    
    if abs(math.cos(x)) < 1e-9:
        raise ValueError("Кут 90,270,.... градусів (π/2 радіан) недопустимий для обчислення тангенса.")
    
    numerator = 1 / tan_val
    denominator = math.sin(2 * x) + 4 * math.cos(x)

    if abs(denominator) < 1e-9:
        raise ValueError("Знаменник дорівнює нулю, ділення неможливе.")
        
    return numerator / denominator

def writeResTxt(fName, result):
    try:
        with open(fName, 'w', encoding='utf-8') as f:
            f.write(str(result))
            print(f"Результат успішно записано у текстовий файл: {fName}")
    except OSError as e:
        print(f"Помилка запису у файл {fName}: {e}")

def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r', encoding='utf-8') as f:
                result = float(f.read())
        else:
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    except ValueError:
        print(f"Помилка: файл {fName} містить некоректні дані.")
    except Exception as e:
        print(f"Непередбачена помилка при читанні {fName}: {e}")
    return result

# --- Робота з бінарними файлами ---

def writeResBin(fName, result):
    try:
        with open(fName, 'wb') as f:
            # Використовуємо 'd' для double (8 байт), це забезпечує високу точність
            packed_value = struct.pack('d', result)
            f.write(packed_value)
            print(f"Результат успішно записано у бінарний файл: {fName}")
    except OSError as e:
        print(f"Помилка запису у бінарний файл {fName}: {e}")

def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                # Зчитуємо 8 байт, бо 'd' займає саме стільки
                bytes_data = f.read(struct.calcsize('d'))
                if not bytes_data:
                     raise ValueError("Файл порожній")
                result = struct.unpack('d', bytes_data)[0]
        else:
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    except struct.error as e:
        print(f"Помилка розпакування даних з файлу {fName}: {e}")
    except Exception as e:
        print(f"Непередбачена помилка при читанні {fName}: {e}")
    return result

# --- Головна частина програми ---

if __name__ == "__main__":
    try:
        # Введення даних користувачем
        data_str = input("Введіть значення x: ")
        x_degrees = float(data_str)
        x_radians = math.radians(x_degrees)
        
        # Обчислення
        result = calculate(x_radians)
        print(f"Обчислений результат y: {result}")
        
        # Запис у файли
        txt_file = "textRes.txt"
        bin_file = "binRes.bin"
        
        writeResTxt(txt_file, result)
        writeResBin(bin_file, result)
        
        # Перевірка зчитування (контроль)
        print("-" * 20)
        print(f"Зчитано з txt: {readResTxt(txt_file)}")
        print(f"Зчитано з bin: {readResBin(bin_file)}")

    except ValueError as e:
        print(f"Помилка обчислення: {e}")
    except Exception as e:
        print(f"Виникла помилка: {e}")