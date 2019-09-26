# Simple Bank System
This is the bank system I wrote in my Software Engineering lab
Provide command line interaction as a real world bank system

## Scenario and system requirements

A simple banking system is to be developed with the intention of providing a generic, reusable system from which to develop more realistic systems. The requirements of the system are to offer a number of different accounts, each of which provides specific services to the customer. The following are all types of accounts are supported by the system:
- Saver account
- Junior account
- Current account
When a customer joins the bank, they are required choose an account type to open, and must credit it with a minimum figure. A customer may open more than one type of account.


## Basic Function:

1: Create a new account (SavingAccount, JuniorAccount, CreditAccount)
2: Deposit money
3: Withdraw money
4: Clear your uncleared value
5: Close account
6: suspend account

## Basic Function Description
The following core functions are to be supported by the system:,

1. Open Account: In order to open an account, the customer must provide the following information:
- name
- address
- date of birth
- type of account to be opened

Only customers under the age of 16 may open a Junior account. To determine the credit status of a customer, the bank sends the customer's details to a Credit Agency, who then carries out a credit search. Provided that the customer has a satisfactory credit history, a new account is opened. Each account has a unique account number. A customer is also issued a separate personal identification number (PIN) for that account.

2. Deposit Funds: Funds may be deposited in an account provided that the depositor provides the appropriate account number. When funds are deposited, they are either cleared (the funds have been fully credited, e.g Cash), or un-cleared (transfer of funds is pending, e.g. using Cheque). Cleared funds are immediately credited to the account.

3. Clear Funds: An external bank clearing system periodically clears un-cleared funds. Once cleared, they are immediately credited to the account.

4. Withdraw Funds: Customers may withdraw funds from an account by supplying their account number, an appropriate identification (in this case, their PIN), and the amount to be withdrawn. A customer cannot withdraw more funds than their limit permits. The type of account the funds are being drawn from determines a customer’s limit. In the case of Junior and Saver accounts, no withdrawal should result in a negative balance. In the case of a Current account, a customer may withdraw additional funds, up to, but not exceeding, their overdraft limit. For a withdrawal from a Saver account, a minimum period of notice (in days) must be given before any withdrawal can be made.

5. Suspend Account: In some situations, accounts may be suspended and no further transactions may occur until the account is re- instated.

6. Close Account: A customer can choose to close their account provided that the balance has been cleared.



This Project is only for the learning purpose, All file are created in 2018 under MIT license

