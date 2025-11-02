import sys
rows_num = int(input("Введіть розмір квадратної матриці: "))

lst = []
filler = input("Введіть символ-заповнювач: ")

if len(filler) == 0:
    print("Не введено символ-заповнювач")
    sys.exit(1)
elif len(filler) > 1:  
    print("Забагато символів-заповнювачів")
    sys.exit(1)

center = rows_num // 2

print("Сформований масив:")

for i in range(rows_num):
    lst.append([])  
    for j in range(rows_num):
        if abs(i - center) + abs(j - center) <= center:
            lst[i].append(ord(filler))
            print(filler, end=" ")
        else:
            print(" ", end=" ")
            
    print()