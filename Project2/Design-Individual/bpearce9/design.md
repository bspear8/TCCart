#Coffee & Tea Card Payment Processing System Design Document

##Classes
The following classes are determined to be necessary to properly represent the system.  A database will include entries matching these classes with the exception of the CreditCard as this is not expected to be persistent.  The credit card will be created upon making a transaction and kept in memory until a receipt is generated, at which point it will be destroyed.  

###CoffeeAndTeaCart
This class represents the primary system.  It will be responsible for printing cards, reading cards, processing transactions, and giving customers VIP Status.  

###CoffeeAndTeaCartUser
This class encapsulates data common to all actors that use the system.  In this case, it is only a name and email.

####Manager
The manager is responsible for operating the cart.  The manager has a PIN for signing into the cart which is hased to provide PinHash.  When the manger enters the PIN, this one way hash confirms it is valid without storing the PIN itself.  

####Customer
The customer makes purchases.  It can have several transactions associated with it.  Through the transactions and the transaction dates, it is known what the annual spending of the customer is for determining VIP status.  

###CustomerCard
The customer card is a physical item printed by the system.  The system can also read the card to yield the customer it belongs to.  The card contains a QR code that represents the CustomerID.

###Credit
A credit is owned by a customer if it is generated. The transaction will generate the credit if it is above the $30 threshold.  The presense of a credit can be determined by the Transaction class via the associated Customer.  

###Product
A product has a name and a price.  No classes specific to Tea or Coffee are specified to avoid limiting the system to only Tea and Coffee sales.  

###Transaction
Transactions are assigned to a customer and are comprised of one or more products.  A customer does not have to be associated with a transaction as the system does not want to preclude customers that are not registered with the credit system. 

###CreditCard
The credit card class would be a plain-old-object and will not have a database entry associate with it.  The CoffeeAndTeaCart will use a CreditCard to process transactions.

##Additional Features

###VIP Status
The relationship between transactions and customers provides a means for VIP status to be determined.  The transactions are all maintained and associated with a customer including price spent.  By totaling the transactions, the system can determine who is eligible for VIP status.  The status will periodically update status every year, and use an external library to send emails.  A boolean attribute of the customer keeps its VIP status.  

###Transaction Display
By maintaining all of the transactions in a database with an associate customer, transactions can easily be called up by the system.

###Processing Transactions
Credits are awarded by the Transaction.  The transaction will award a credit if the amount is above $30.  

Transactions are processed by a function of the system that takes Transaction and CreditCard as input.  The Transaction provides access to the Customer through which the system is aware of VIP status and any available credit.  The Transaction has a total based on the items that compose it. The transaction will also keep the transaction date, and the last 4 digits of the CreditCard for security.  

Transactions can also send receipts.  This function encapsulates the data in the Transaction class to create an email and uses an external library to send it to the customer.  The association between customer and transaction gives this function access to the customer email.  

###Identifying Customers
A camera with a QR code reading library is attached to the system.  The QR code is distinct from the customer ID number, but a function associated with the system can be used to decode it.  
