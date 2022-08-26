numbers = tuple(input("Enter the numbers with comma separated values: ").split(","))
print(numbers)

for number in numbers:
    if(int(number) % 5 == 0):
        print(number)

