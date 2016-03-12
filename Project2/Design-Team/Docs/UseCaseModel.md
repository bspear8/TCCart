# Use Case Model

**Author**: Team 38

| Version | Description     |
| --------|:---------------:|
| V1      | Initial version |

## 1 Use Case Diagram

![alt text](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/Use%20Case%20Diagram.PNG "Use Case Diagram")

## 2 Use Case Descriptions

__2.1 Add Customer__  
__2.1.1 Requirements:__ Allows the manager to add a customer to the system.  
__2.1.2 Pre-conditions:__ Must have the customer's name and email address.  
__2.1.3 Post-conditions:__ The user will be added to the TCCart system.  
__2.1.4 Scenarios:__  
__2.1.4.1 Expected:__  
> 1. The manager selects the "Add Customer" button on the main menu.  
> 2. The add customer page is displayed.  
> 3. The manager enters the customer name and email.  
> 4. The manager selects the add button.    
> 5. The system adds a customer entry with the specified name and email.  
> 6. The application displays the main page again.  

__2.1.4.2 Alternates:__  
> __2.1.4.2.1 Cancel adding customer__   
> 1. The manager selects the "Add Customer" button on the main menu.   
> 2. The add customer page is displayed.  
> 3. The manager selects the cancel button.  
> 4. The application displays the main page again.  

__2.2 Send Email__  
__2.2.1 Requirements:__ Allows the system to send a VIP or credit notification email, or a transaction receipt email.  
__2.2.2 Pre-conditions:__ The customer has met VIP conditions, or earned credit, or a transaction has been successfully completed.  
__2.2.3 Post-conditions:__ The customer will receive a notification email or reciept email at the email they originally provided to the manager.  
__2.2.4 Scenarios:__ 
__2.2.4.1 Expected:__
> 1. Upon completing a transaction, the system will format a message to send to the external email sending library.
2. The customer's transaction, number of items, last four card digits, and 
Upon completeing a transaction, the TCCart Manager System will determine if the customer has met VIP status or earned credit and send a notification email if so. The system will also send a transaction receipt.  

__2.3 Edit Customer Information__  
__2.3.1 Requirements:__ Allows the manager to update customer name and email as needed.  
__2.3.2 Pre-conditions:__ The customer must already exist in the system.  
__2.3.3 Post-conditions:__ The customer name and/or email will be changed in the system.  
__2.3.4 Scenarios:__ A customer changes their email or legal name and the manager needs to a way to modify that information in the system. The manager can directly use the application to input new customer information.  

__2.4 Process Transactions__  
__2.4.1 Requirements:__ Allows the manager to "close out" a customer's "cart" by charging their credit card minus any deductions and discounts, calculating credit earned and any VIP status earned, and then sending all applicable email notifiations and a receipt.  
__2.4.2 Pre-conditions:__ The customer must have a valid customer card, credit card, and must have been added to the system previously.  
__2.4.3 Post-conditions:__ The customer's card will have been charged and all credit/VIP calculations will have been made. The customer will receive credit/VIP notifications if applicable and a receipt email.  
__2.4.4 Scenarios:__ A customer brings items to the manager who will add those items to the transaction list, then close out the transactions by scanning the customer's customer card, and then scanning the customer's credit card.  

__2.5 List Transactions__
__2.5.1 Requirements:__ Provides the manager with system output of that customer's transaction history.  
__2.5.2 Pre-conditions:__ The customer must be in the system.  
__2.5.3 Post-conditions:__ The results will display on the application.  
__2.5.4 Scenarios:__
__2.5.4.1 Expected:__
>If a customer wishes to make a return, or remember a previously purchased item, the manager will have the ability to pull up that information.  

__2.5.4.2 Alternates:__

__2.6 Print Customer Card__
__2.6.1 Requirements:__ Provides the manager with a way to print a customer card for new customers.  
__2.6.2 Pre-conditions:__ The customer must have been added to the system.  
__2.6.3 Post-conditions:__ The customer card will have been printed.  
__2.6.4 Scenarios:__ After adding a customer, the manager will select "print customer card" to provide to the customer. This will also allow the manager to print additional customer cards in case the customer lost their original.  

__2.7 _Scan Credit Card__
__2.7.1 Requirements:__ The system will process the scanned credit card and charge the customer's account.  
__2.7.2 Pre-conditions:__ Process transactions was initiated and a valid credit card is scanned.  
__2.7.3 Post-conditions:__ The customer's credit account is charged and the credit information is not stored on the system.  
__2.7.4 Scenarios:__ After the manager processes transactions and the customer's card is scanned, the customer's credit card is scanned and charged.  

__2.8 Scan Customer Card__
__2.8.1 Requirements:__ The system will process the customer card's QR code to look up the customer.  
__2.8.2 Pre-conditions:__ The customer must have a customer card and have been added to the system previously.  
__2.8.3 Post-conditions:__ The customer's information will be pulled up on the system.  
__2.8.4 Scenarios:__ After the manager initiates the processes transaction use case, the customer's card is scanned.  
