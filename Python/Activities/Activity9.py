listFirst = [10, 20, 23, 11, 17]
listSecond = [13, 43, 24, 36, 12]
print("First List: " ,listFirst)
print("Second List: ", listSecond)
listThird = []
for number in listFirst:
    if(number % 2 != 0):
        listThird.append(number)
for number in listSecond:
    if(number % 2 == 0):
        listThird.append(number)
print("Third List : ", listThird)