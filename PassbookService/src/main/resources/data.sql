DROP TABLE IF EXISTS passbook;
CREATE TABLE passbook AS SELECT * FROM CSVREAD('classpath:passbook.csv');