DROP TABLE IF EXISTS user;
CREATE TABLE balance AS SELECT * FROM CSVREAD('classpath:balance.csv');