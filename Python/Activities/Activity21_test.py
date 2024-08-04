import pytest

def test_addition():
	
	num1 = 35
	num2 = 50
    
	sum = num1 + num2
	assert sum == 85

def test_subtraction():
  
	num1 = 20
	num2 = 10
    
	diff = num1 - num2

	assert diff == 10
def test_multiplication():
  
	num1 = 5
	num2 = 20
    
	prod = num1 * num2
	assert prod == 100
def test_division():
  
	num1 = 100
	num2 = 5

	quot = num1 / num2

	assert quot == 20