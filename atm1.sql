create database atm1;
use atm1;
create table Account(Account_no int(10),Name varchar(30),password int(8),Amount int(10));
insert into Account(Account_no,name,password,Amount) values(58791,"Rajesh Singh",2564,50000),
(44564,"Siddhart Kapoor",2417,50000),
(98211,"Subhranshu Sekhar ",1594,50000),
(12457,"Dayanand seth",7514,50000),
(87543,"Subrat Singh ",2456,50000),
(15975,"Vikram Singh",1478,50000),
(35795,"Ajay Kumar",3333,50000);
Select * from Account;