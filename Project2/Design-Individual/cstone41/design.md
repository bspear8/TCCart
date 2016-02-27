**Disclaimers:**

The UML tool only allowed attributes to be created with + signs. I did not worry about that because Alex indicated it did not matter.

The UML tool only allowed for creating interfaces with a circle or ball.  

**Assumptions:**

A customer may have more than one customerAccount.  The latest customerAccount will be called by the program and not the earliest account.  (Ex: A customer might close an account and need another account. )

**Adding a customer -- CartManagerUtility and addCustomer() method**

The CartManagerUtility adds a new customer, via the +addCustomer() method.  The information added will be that shown in the Customer class.  It will also create one instance of the CustomerAccount class and save the data. It will populate the customrId and dateOpened fields. Not all information in the CustomerAccount class is added at this time.

**Printing the customer card - CartManagerUtility and printCustomerCard() method and CardPrinter**

The CartManagerUtility will use the +printCustomerCard() method invoking the external libraries and print the QR coded customer card using the CardPrinter.  The card will encode the customer's unique ID.  The printCustomerCard method will take the customerId as input.

**Editing a customer - CartManagerUtility and editCustomer() method**

The CartManagerUtility method +editCustomerInfo() will be invoked.  Depending upon what information needs to be updated, this method will corrector update the necessary information in the Customer class.

**Display / Track Purchases and Rewards**

The CartManagerUtility will use the +displayRewardsAndPurchases method to show, in a detailed tabular format, all the purchases made by the customer.  The information for each individual purchase that will be displayed is: +purchaseTime, +grossAmount (purchase total before discount or rewards), +discountApplied (discounts applied, including Vip discounts), and +creditApplied (rewards), and +netAmount (purchase total after discount). The purchase information will come from the Purchase class. 

**Purchases**

The Cart Manager using the startPurchase() method in the CartManagerUtility adds a value to the grossAmount() attribute in the Purchase class.

Then, the readCustomerCard() method from the PurchaseUtility class is invoked.

1. It reads the information of the Customer Id card.  
2. Step 1 is performed by scanning the card using the VideoCam invoking the needed external libraries.  
3. The customerID is used to identify the correct CustomerAccount and Customer class data.  

Next, the applyVipDiscount() method from the PurchaseUtiltiy class is invoked. This method does the following:

1. The vipStatus in the CustomerAccount class is checked.  
2. If the value is True, then a 10% Vip discount is applied
3. This dollar value of the discount amount is then passed to the discountApplied attribute in the Purchase class.  
4. The value amount from the discount applied is also deducted from the grossAmount attribute called in the Purchase class  and passed to the netAmount attribute.

Next, the applyCredit() methiod from the PurchaseUtility class is invoked.  

1. If creditBal (rewards) value from the CustomerAccount class has a credit balance, then the creditExpirationDate is  evaluated.  If creditExpirationDate > SystemDate + 30 days, no credit is deducted from the grossAmount.  
2. If creditExpirationDate < SystemDate + 30 days, then the value amount from creditBal is deducted from the  purchase total (grossAmount) in the Purchase Class.  
3. The creditBal is also reduced by the amount removed.
4. The value amount from the credit applied is also deducted from the grossAmount attribute called in the Purchase class  and updates thee netAmount value.  

Finally the processCCPayment method in the Payment Utility is invoked  It performs the following:

1.  The scanner reads the information defined in the CreditCard class when the credit card is swiped.    
2.  The readCustomerCreditCard() method invokes the CreditCardScanner interface and external libraries.
3.  The processPurchase method in the PurchaseUtiltiy retrives the netAmount value from the Purchase class.
The processPurchase method invokes the processCCPayment method from the PaymentUtility class.
The processingCCPayment method next invokes the PaymentProcessing Service Provider interface and external libraries to gather approval for the charged purchased and to complete the charge process.
4.  If the charge is approved, the processPurchase() calls the NotifierUtility and sends an email to the customer regarding their purchase.  (Emails are sent as described in this document below under Email Notifications.)
5.  The purchase transaction id (purchaseID from the Purchase class) is updated.
6.  The purchaseTime from the Purchase class is also updated.
7.  The numberOfPurchases is incremented by 1 (one) in the CustomerAccount class.
8.  The purchaseYTD is increased by the value of the netAmount that was previously charged to the customer's credit card.
9.  If the purchaseYTD value reached $300, then the value for vipStatus in the CustomerAccount class is changed to True.
10. If the purchaseYTD is less than$300, then the value for vipStatus in the CustomerAccount class should be False.
11. If the value for netAmount in the Purchase class is equal to or greater than $30, then a $3 credit is added to the creditBal value in the CustomerAccount class and the credit expirationDate is changed to the currentDate.
12. If the customer receives a new credit (reward), then the processPurchase method invoked the sendEmail process in the NotiferUtility and send the customer an email.

**VIP Status**

Once the purchaseYTD value reaches $300, then the vipStatus value in the CustomerAccount class changes from False to True.  At the beginning of the year, following the year in the purchaseTime value for the purchase transaction that caused the customer to reach $300 in purchase totals for the current year, all future purchases will apply a 10% discount to purchases throughout that calendar year.  The vipDisount will not be applied during the remainder of the year during which the customer initially achieves vipStatus = True.  

On December 31st of each year , if purchaseYTD equals $300 or more for a customer, the vipStatus will remain True. The vipStatus for all other customers will be False.  For all customers purchaseYTD becomes $0 (zero dollars) on January 1st of any given year.

Additional details provided in the Purchase section of this document further explain the Vip Status process.

**Email Notifications**

The processPurchase method from the PruchaseUtiltiy class inovkes  the sendEmail() method in the NotifierUtility class to send emails to a Customer following a completed purchase when the following circumstances occur:

1.  A customer purchase is completed.  
2.  A customer receives a new credit.  
3.  A customer achieves VIP Status.

The sendEmail method retreives the email value from the Customer class.  
