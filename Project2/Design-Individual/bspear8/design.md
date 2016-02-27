#Assignment 5: TC Cart Design
Blaine Spear - bspear8 - blaine.spear@gmail.com

##Assumptions:
1. The QR Code is Numeric only.
2. If the customer is already a VIP for the next year, and they spend another $300, they will not receive it for the year after that, and will not receive a notification.
3. The specific type of item is not relevant to the TC Cart Manager program.

##Design Description & Explanation:
This section ellaborates on certain methods' functionality to make the overall program structure and access paths clear.  

1. The __CartManager__ class will hold a list of __Customers__ and know about transactions, credit and VIP status through that list.
2. The __*processPurchases*__ method will use the list of __Customers__ to do the following:
  - Calculate amount owed, taking previous credit & VIP status into account.
  - Calculate new credit.
  - Assign VIP status if warranted.
  - Call the __*emailCustomer*__ method, asking it to either email a reciept, a VIP notification, or a "credit awarded" message.
  - This method relies on __*transactionComplete()*__ in the __Payment__ class returning true (successful transaction).
  - This method will tell the __Transaction__ class about any credit used so it can maintain information for historical transaction display.
3. __*displayTransactionHistory*__ and __*displayPendingTransactions*__ methods will print a formatted list to the console of a customer's previous and pending transactions using their customer ID.
4. The __*addCustomer*__ method will also call __*printCard*__ in addition to creating a __Customer__ class. The method returns the ID of the new customer for reference.
5. In the __Payment__ class, upon calling __*transactionComplete()*__, the attributes will be cleared in order to prevent storing credit card information.

###Design Notes:
1. All getter and setter methods are implied and not listed in the design UML document.
2. __Item__ may use the factory pattern to become more specific about type of item (i.e. coffee or tea); however, specifics about the item did not impact overall design for the cart manager and so are not listed in the UML document.
3. Methods that could return "void" and return a Boolean instead will use that Boolean to indicate success or failure of the method's execution.
  - i.e., __*emailCustomer(String)*__ will return true if successful, false if an email was not sent or there was an error.
