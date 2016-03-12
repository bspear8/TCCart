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
 1. The manager selects the "Add Customer" button on the main menu.   
 2. The add customer page is displayed.  
 3. The manager selects the cancel button.  
 4. The application displays the main page again.  

__2.2 Send Email__  
__2.2.1 Requirements:__ Allows the system to send a VIP or credit notification email, in addition to the transaction receipt email.  
__2.2.2 Pre-conditions:__ A transaction has been successfully completed.
__2.2.3 Post-conditions:__ The customer will receive a notification email and reciept email at the email they originally provided to the manager.  
__2.2.4 Scenarios:__  
__2.2.4.1 Expected:__  
> 1. Upon completing a transaction, the system will format a message to send to the external email sending library.  
2. The customer's transaction, number of items, last four card digits, discounts used, and amount charged will be added to the message format.  
3. If the customer purchased $30 or more, the message will include a notification that they have received a $3 credit towards their next purchase.  
4. If the system determines the customer spend $300 or more in a single calendar year, the message includes a notification of VIP status and details of that status.  

__2.3 Edit Customer Information__  
__2.3.1 Requirements:__ Allows the manager to update customer name and email as needed.  
__2.3.2 Pre-conditions:__ The customer must already exist in the system.  
__2.3.3 Post-conditions:__ The customer name and/or email will be changed in the system.  
__2.3.4 Scenarios:__  
__2.3.4.1 Expected:__   
> 1. The manager presses "Edit Customers" from the main menu.  
2. The application displays a drop down with all customers.  
3. The manager selects the customer he/she wishes to edit and then selects "Edit."  
4. The application displays a screen with editable name and email fields.  
5. The manager inputs the new data and presses "Change."  
6. The application records the changes and returns the manager to the main screen.  

__2.3.4.2 Alternates:__
> __2.3.4.2.1 Cancel Customer Selection__
 1. The manager presses "Edit Customers" from the main menu.  
 2. The application displays a drop down with all customers.  
 3. The manager presses the "Cancel" button.  
 4. The application returns the manager to the main menu page. 

>__2.3.4.2.2 Cancel Customer Edit__  
 1. The manager presses "Edit Customers" from the main menu.  
 2. The application displays a drop down with all customers.  
 3. The manager selects the customer he/she wishes to edit and then selects "Edit."  
 4. The application displays a screen with editable name and email fields.  
 5. The manager presses the "Cancel" button.  
 6. The application returns the manager to the main menu page.  

__2.4 Process Transactions__  
__2.4.1 Requirements:__ Allows the manager to "close out" a customer's "cart" by charging their credit card minus any deductions and discounts, calculating credit earned and any VIP status earned, and then sending all applicable email notifiations and a receipt.  
__2.4.2 Pre-conditions:__ The customer must have a valid customer card, credit card, and must have been added to the system previously.  
__2.4.3 Post-conditions:__ The customer's card will have been charged and all credit/VIP calculations will have been made. The customer will receive credit/VIP notifications if applicable and a receipt email.  
__2.4.4 Scenarios:__  
__2.4.4.1 Expected:__
> 1. The manager scans the customer's customer card. This is handled by the Scan Customer Card use case.
2. The manager will press "Process New Transaction."
3. The application will display the Transactions menu.
3. The manager will add all customer items.
4. The manager then presses "Pay" to complete the transaction.
5. The application displays the Payment screen.
5. The manager swipes the customer's credit card which the Scan Credit Card use case handles.
6. The Send Email use case is initiated.
7. The application will display the main menu with the toast "Transaction Successful."

__2.4.4.2 Alternates__
> __2.4.4.2.1 Cancel Transaction__  
 1. The manager presses "Cancel" at the Process New Transaction screen.
 2. The manager is returned to the main menu.

> __2.4.4.2.2 Cancel Payment__  
 1. The manager presses "Cancel" at the Payment screen.
 2. The manager is returned to the main menu.

> __2.4.4.2.3 Customer Card Invalid__ 
 1. If the Customer Card is scanned but nothing in the system is found an error toast will be displayed.
 2. The manager will remain on the main screen.

> __2.4.4.2.4 Payment Invalid__  
 1. If the payment is rejected for any reason, the system will display an error toast.
 2. The manager will remain on the Transactions screen until new payment is provided.
 3. To cancel the entire transaction, the manager will need to press "Cancel."

__2.5 List Transactions__  
__2.5.1 Requirements:__ Provides the manager with system output of that customer's transaction history.  
__2.5.2 Pre-conditions:__ The customer must be in the system.  
__2.5.3 Post-conditions:__ The results will display on the application.  
__2.5.4 Scenarios:__
__2.5.4.1 Expected:__
> 1. The manager selects a customer by either scanning the customer's card or pressing Customers and selecting a customer from that screen.
2. On the customer screen, the manager selects "List Transactions."
3. To get further details of an individual transaction, the manager can press that transaction from this screen.

__2.6 Print Customer Card__  
__2.6.1 Requirements:__ Provides the manager with a way to print a customer card for customers.  
__2.6.2 Pre-conditions:__ The customer must have been added to the system.  
__2.6.3 Post-conditions:__ The customer card will have been printed.  
__2.6.4 Scenarios:__  
> 1. The manager selects a customer through the customers drop down.
2. On the Customer screen, the manager presses the "Print Card" button.
3. The application sends the customer's information and print request to the external printer library.

__2.7 _Scan Credit Card__  
__2.7.1 Requirements:__ The system will process the scanned credit card and charge the customer's account.  
__2.7.2 Pre-conditions:__ Process transactions was initiated and a valid credit card is scanned.  
__2.7.3 Post-conditions:__ The customer's credit account is charged and the credit information is not stored on the system.  
__2.7.4 Scenarios:__ 
__2.7.4.1 Expected:__  
> 1. The credit card is scanned and external credit card handling libraries process the transaction.
2. Transaction success is returned to the application.

__2.7.4.2 Alternates:__  
> __2.7.4.2.1 Invalid Card__  
 1. The credit card is scanned and external credit card handling libraries process the transaction.
 2. Transaction failure is returned to the application.

__2.8 Scan Customer Card__  
__2.8.1 Requirements:__ The system will process the customer card's QR code to look up the customer.  
__2.8.2 Pre-conditions:__ The customer must have a customer card and have been added to the system previously.  
__2.8.3 Post-conditions:__ The customer's information will be pulled up on the system.  
__2.8.4 Scenarios:__
__2.8.4.1 Expected:__
> 1. The customer card is scanned and external QR code scanning libraries process the card.
2. The customer's screen is displayed based on the returned ID.

__2.8.4.2 Alternates:__  
> __2.8.4.2.1 Invalid Card__  
> 1. The customer card is scanned and external QR code scanning libraries process the card.
2. An error is returned to the error application from the QR code scanning libraries.
