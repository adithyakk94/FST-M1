fruits = {
    "apple" : 10,
    "mango" : 35,
    "banana" : 55
}

fruit = input("Enter a fruit to check:").lower()
if(fruit in fruits):
    print("Fruit is available")
else:
    print("Fruit is not available")