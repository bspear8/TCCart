# Assignment 5: Software Design

This document details assumptions and rationale used when I created *TCCart a Payment and Rewards Management System for Tea and Coffee Carts* class diagram.

## Assumptions

That VIPDiscount discount of 10% policy could possibly change in the future for new VIPs.

That items (such as tea or coffee) to be purchased are manually entered into the system by the Manager during a transaction.

## Rationale

I chose a one to many association between class Customer and class Discount for the following reason:

Discount is an abstract class for the two kinds of of discounts that a customer can earn.

A Customer can have more than one VIP status (and thus more than one VIPDiscount). Consider the case where VIP status is earned in 2016 for 2017. Then, in 2017, VIP status is earned for 2018. At this point, the Customer has VIP status for both 2017 and 2018 (though only 2017 is used during 2017, etc).

Additionally, a Customer can only have one active Credit available at a time. However, it is entirely possible that he or she could have accumulated several expired Credits. A Credit is considered inactive if its remainingAmount is 0 or if it is expired.

A transaction consists of Items and Discounts.

Emails are sent by a Customer object in the addTransaction(transaction) call.

I put a dependency between Customer class and CreditDiscount class because addAvailableCredit() method takes a CreditDiscount as a parameter. I put a dependency between Customer class and VIPDiscount class because addVipDiscountStatus() takes a VIPDiscount as a parameter. Admittedly, this makes the chart less clean.

In the Discount class, the computeDiscount(amount) takes an amount parameter. Amount is a dollar amount that is meant to be the total cost of a transaction at a given time. This amount parameter is needed because the Discount class doesn't contain all of the necessary information to compute the discount.
