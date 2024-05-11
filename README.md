# Basic-ATM-software-with-GUI
ATM System Project
This project implements an Automated Teller Machine (ATM) system using Java Swing for the user interface and MySQL for database management. It allows users to perform various banking transactions such as login, deposit, withdrawal, and password change.

Features
Login: Users can authenticate using their account number and password.
Deposit: Users can deposit money into their accounts.
Withdrawal: Users can withdraw money from their accounts.
Main Balance: Users can view their account balance.
Password Change: Users can change their account password.
Prerequisites
Java Development Kit (JDK)
MySQL Server
Setup
Database Setup:

Create a MySQL database named atm1.
Create a table named Account with columns Account_no (INT) and password (INT).
Java Development:

Install Java Development Kit (JDK) on your system.
Compile the ATM.java file using javac ATM.java.
MySQL Connector:

Download and add the MySQL Connector/J JAR file to your project's classpath.
Run the Program:

Run the compiled Java class using java ATM.
Usage
Login:

Enter your account number and password to login.
Deposit:

Click on the "Deposit" button, enter the deposit amount, and click "YES" to confirm.
Withdrawal:

Click on the "Withdraw" button, enter the withdrawal amount, and click "YES" to confirm.
Main Balance:

Click on the "Main Balance" button to view your account balance.
Password Change:

Click on the "PIN Change" button, enter the new password, and click "Change" to update your password.
Security Considerations
Password Security:
Passwords are stored in the database as plaintext, which is not secure. Implement password hashing for better security.
Dependencies
Java Swing: Used for creating the graphical user interface.
MySQL Connector/J: Java driver for MySQL database connectivity.
Developed by:-
Jagat Jeevan Behera - beherajagat713@gmail.com
