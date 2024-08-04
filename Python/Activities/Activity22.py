import pytest
def test_addition():
    num1=5
    num2=6
    sum=num1+num2

    assert sum==11

def test_substraction():
    num1=9
    num2=5

    difference=num1-num2
    assert difference==4

@pytest.mark.activity
def test_multiplication():
    num1=5
    num2=5

    multiply=num1*num2
    assert multiply==25

@pytest.mark.activity
def test_division():
    num1=10
    num2=5

    remainder=num1/num2 
    assert remainder==2     