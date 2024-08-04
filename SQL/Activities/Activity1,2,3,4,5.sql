REM   Script: Session 01
REM   Activity1, Activity2, Activity3, Activity4, Activity5

CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar2(32) not null, salesman_city varchar2(32), commission int);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

Select * from salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=100;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

