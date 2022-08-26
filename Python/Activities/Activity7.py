numbers = list(input("Enter the numbers with comma separated values: ").split(","))
sum = 0

for number in numbers:
    sum += int(number)

print("Sum of all the elements in the list: ", sum)
