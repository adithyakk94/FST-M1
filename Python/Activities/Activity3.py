firstUser = input("Enter first user choice:")
secondUser = input("Enter second user choice:")
if firstUser == secondUser:
    print("Tie")
elif firstUser == "paper":
    if secondUser == "rock":
        print("Paper beats rock")
    else:
        print("Scissors beats paper")
elif firstUser == "rock":
    if secondUser == "scissors":
        print("Rock beats scissors")
    else:
        print("Paper beats rock")
elif firstUser == "scissors":
    if secondUser == "paper":
        print("Scissors beats paper")
    else:
        print("Rock beats scissors")
else:
    print("Input is invalid")
