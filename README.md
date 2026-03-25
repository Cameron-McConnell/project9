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

class Admin {
+Admin()
+String menu()
+void start()
+String getReport()
}

class Bank {
-Admin admin
-CustomerList customers
+Bank()
+main()
+void loadSampleCustomers()
+void saveCustomers()
+void loadCustomers()
+void reportAllUsers()
+void addUser()
+void applyInterest()
+void loginAsCustomer()
+String menu()
+void start()
+void startAdmin()
}

class CustomerList {
<<container>>
}

HasMenu <|.. CheckingAccount
HasMenu <|.. User
HasMenu <|.. Bank

CheckingAccount <|-- SavingsAccount
User <|-- Customer
User <|-- Admin

Customer *-- CheckingAccount
Customer *-- SavingsAccount

Bank *-- Admin
Bank *-- CustomerList
CustomerList "1" o-- "*" Customer
