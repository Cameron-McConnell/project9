''' mermaid

classDiagram

class HasMenu {
<<interface>>
+String menu()
+void start()
}

class CheckingAccount {
-double balance
+CheckingAccount()
+CheckingAccount(double balance)
+main()
+String menu()
+void start()
+double getBalance()
+String getBalanceString()
+void setBalance(double balance)
+void checkBalance()
+void makeDeposit()
+void makeWithdrawal()
-double getDouble()
}

class SavingsAccount {
-double interestRate
+main()
+void calcInterest()
+void setInterestRate(double rate)
+double getInterestRate()
}

class User {
<<abstract>>
-String userName
-String PIN
+boolean login()
+boolean login(String userName, String PIN)
+void setUserName(String userName)
+String getUserName()
+void setPIN(String PIN)
+String getPIN()
+String getReport()
}

class Customer {
-CheckingAccount checking
-SavingsAccount savings
+Customer()
+Customer(String userName, String PIN)
+main()
+void start()
+String menu()
+void changePin()
+String getReport()
}

HasMenu <|.. CheckingAccount
HasMenu <|.. User
CheckingAccount <|-- SavingsAccount
User <|-- Customer

Customer *-- CheckingAccount
Customer *-- SavingsAccount

