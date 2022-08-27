def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum

list = [10,20,30]

result = calculate_sum(list)

print("The sum of all the elements is: " + str(result))