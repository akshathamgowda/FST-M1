import pytest

@pytest.fixture
def num_list():

    int_list = [2,1,3,5,6,9,1,2,4,5]
    

    return int_list

def test_sum(num_list):


    sum = 0
    for n in num_list:
        sum += n

    
    assert sum == 55
    import pytest

@pytest.fixture
def num_list():


    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    

    return list