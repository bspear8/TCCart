# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Team 38

## 1 Use Case Diagram

![alt text](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/Use%20Case%20Diagram.PNG "Use Case Diagram")

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

_Add Customer_
- Requirements: Allows the manager to add a customer to the system.
- Pre-conditions: Must have the customer's name and email address.
- Post-conditions: The user will be added to the TCCart system.
- Scenarios: A new customer, or the first customer, must be added to the system before the system can track or process transactions. New customers will provide their name and email to the manager who will input the information into the TCCart application on their android device.

_Send Email_
- Requirements: Allows the system to send a VIP or credit notification email, or a transaction receipt email.
- Pre-conditions: The customer has met VIP conditions, or earned credit, or a transaction has been successfully completed.
- Post-conditions: The customer will receive a notification email or reciept email at the email they originally provided to the manager.
- Scenarios: Upon completeing a transaction, the TCCart Manager System will determine if the customer has met VIP status or earned credit and send a notification email if so. The system will also send a transaction receipt.

_Edit Customer Information_
- Requirements: Allows the manager to update customer name and email as needed.
- Pre-conditions: The customer must already exist in the system.
- Post-conditions: The customer name and/or email will be changed in the system.
- Scenarios: A customer changes their email or legal name and the manager needs to a way to modify that information in the system. The manager can directly use the application to input new customer information.

_Process Transactions_
- Requirements: Allows the manager to "close out" a customer's "cart" by charging their credit card minus any deductions and discounts, calculating credit earned and any VIP status earned, and then sending all applicable email notifiations and a receipt.
- Pre-conditions: The customer must have a valid customer card, credit card, and must have been added to the system previously.
- Post-conditions: The customer's card will have been charged and all credit/VIP calculations will have been made. The customer will receive credit/VIP notifications if applicable and a receipt email.
- Scenarios: A customer brings items to the manager who will add those items to the transaction list, then close out the transactions by scanning the customer's customer card, and then scanning the customer's credit card.

_List Transactions_
- Requirements: Provides the manager with system output of that customer's transaction history.
- Pre-conditions: The customer must be in the system.
- Post-conditions: The results will display on the application.
- Scenarios: If a customer wishes to make a return, or remember a previously purchased item, the manager will have the ability to pull up that information.

_Print Customer Card_
- Requirements: Provides the manager with a way to print a customer card for new customers.
- Pre-conditions: The customer must have been added to the system.
- Post-conditions: The customer card will have been printed.
- Scenarios: After adding a customer, the manager will select "print customer card" to provide to the customer. This will also allow the manager to print additional customer cards in case the customer lost their original.

_Scan Credit Card_
- Requirements: The system will process the scanned credit card and charge the customer's account.
- Pre-conditions: Process transactions was initiated and a valid credit card is scanned.
- Post-conditions: The customer's credit account is charged and the credit information is not stored on the system.
- Scenarios: After the manager processes transactions and the customer's card is scanned, the customer's credit card is scanned and charged.

_Scan Customer Card_
- Requirements: The system will process the customer card's QR code to look up the customer.
- Pre-conditions: The customer must have a customer card and have been added to the system previously.
- Post-conditions: The customer's information will be pulled up on the system.
- Scenarios: After the manager initiates the processes transaction use case, the customer's card is scanned.
