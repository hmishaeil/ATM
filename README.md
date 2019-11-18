# A command-line ATM application

This Java project is related to Tala QA assignment which is implementng a simple ATM application with below specification. 

Application gets the input from the user as 4 options of Balance, Deposit, Withdrawal, Quit

The start menu looks like following,

### Choose your option from menu ###
1. Balance
2. Deposit
3. Withdrawal
4. Quit

- The Balance option:
i. Displays remaining balance (The sample initial value is 1000)

- The Deposit option:
i. Reads deposit amount from user. 
ii. Maximum amount of deposit for the day is 150K. 
iii. Maximum deposit amount per transaction is 40K. 
iv. Max deposit frequency per day is 4 times.


- The Withdrawal option:
i. Reads withdrawal amount from user input
ii. Maximum withdrawal amount for the day is 50K. 
iii. Maximum withdrawal amount per transaction is 20K. 
iv. Maximum withdrawal frequency per day is 3 times. 
v. User cannot withdraw when balance is less than withdrawal amount. 

- The Quit option:
i. Confirms to quit. 
ii. Terminates the program. 
iii. Data is not persist, i.e. when the user quits and restarts, data will be reset.


After importing the project to the Eclipse IDE,
To run the application as "Java Application", right-click on the Tala_QA_Assignment, choose "Run As" and then choose "Java Application"
To run the application as "JUnit Tests", right-click on the Tala_QA_Assignment, then choose "Run As" and then choose "JUnit Test"



