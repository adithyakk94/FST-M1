import pytest

#Addition Test

def test_method_add():
    num1 = 25
    num2 = 10
    #Addition of numbers
    sum = num1 + num2
    #Assertion
    assert sum == 35

#Subtraction Test

def test_method_sub():
    num1 = 55
    num2 = 10
    #Subtraction of numbers
    sub = num1 - num2
    #Assertion
    assert sub == 45

#Multiplication Test

@pytest.mark.activity
def test_mul():
    num1 = 10
    num2 = 10
    #Multiplication of numbers
    mul = num1 * num2
    #Assertion
    assert mul == 100

#Division Test

@pytest.mark.activity
def test_div():
    num1 = 100
    num2 = 10
    #Division of numbers
    div = num1 / num2
    #Assertion
    assert div == 10