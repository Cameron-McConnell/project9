
# ================= COMPILE RULES =================

Customer.class: Customer.java User.class CheckingAccount.class SavingAccount.class
	javac -g Customer.java

User.class: User.java HasMenu.class
	javac -g User.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

SavingAccount.class: SavingAccount.java CheckingAccount.class
	javac -g SavingAccount.java

Admin.class: Admin.java User.class HasMenu.class
	javac -g Admin.java

CustomerList.class: CustomerList.java Customer.class
	javac -g CustomerList.java

Bank.class: Bank.java Admin.class CustomerList.class Customer.class
	javac -g Bank.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

# ================= RUN TARGETS =================

testAdmin: Admin.class
	java Admin

testCustomer: Customer.class
	java Customer

testChecking: CheckingAccount.class
	java CheckingAccount

testSaving: SavingAccount.class
	java SavingAccount

runBank: Bank.class
	java Bank

# ================= CLEAN =================

clean:
	rm -f *.class *.dat
