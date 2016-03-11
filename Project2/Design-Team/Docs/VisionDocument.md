# Vision Document

**Author**: Carol Stone (cstone41)

| *Version* | *Description*     |
| --------|:---------------:|
| *V1*    | *Initial version* |

## 1 Introduction

TCCart is a Payment and Rewards Management System for Tea and Coffee Carts that runs on an Android platform. The application is intended to be used by customers to make credit card payments and to generate product loyalty via a rewards system.

## 2 Business Needs/Requirements

Currently cart managers do not have a way to quickly determine a customer's reward balances, VIP status, process credit card payments, display customer account / purchase histories or update customer information.  Customers do not have a way to make credit card payments from their Android cell phones.  

The tea and coffee carts operate in Piedmont Park.  Due to the high risk for robbery, if the cart took cash payments, tea and coffee purchases can only be made using credit cards. Often customers in the park, do not have their physical credit cards readily available.  The TCCart application will help facilitate credit card transactions.

In order to accurately process credit card payments, the customers and cart managers need to know what the customer's reward balance.  Reward credits will automatically be applied toward a customer's next purchase. VIP customers will receive a 10% discount toward all purchases made in the calendar year following the year their VIP status is achieved.  

The TCCart application will help cart managers access up-to-date customer account information and edit information as needed providing an efficient platform to better service their customers.  It will also make purchasing items more convenient for customers while visiting Piedmont Park. The rewards system will generate customer loyalty and should lead to repeat sales.

Key factors to adopting the development of the TCCart Payment and Rewards Management System for Tea and Coffee Carts on an Android platform were as follows:

2.1. The ability to create a simple application with a bird's eye view of only needed functions

2.2. Ease of Use - the application will be easy for consumers and employees to navigate and feel comfortable using. 

2.3. Little to no training required to use the application

2.4. Affordable application pricing - Application can be developed at a low cost.  

2.5. Ability to add 'pay for features' to the application later, if the business decides to add other features to create a more robust application that might include social media features, etc.

2.6. Security - The data will be available only to the business.

2.7. The application will use a credit card processing system interface, utilizing external libraries, and all credit card transactions will be encrypted.  No actual credit numbers will be stored.

## 3 Product / Solution Overview

TCCart, an Android application, will provide real-time access to current customer account information.  The information will include both customer and purchase history information.  Available information will include: customer id, customer name, and the customer's email address.  The account information will include the number of purchases made in a year, the cumulative YTD dollar amount of the purchases made, the rewards value earned and available to be applied toward the customers' next purchase, the customer's VIP status for the current year and the next year.  The  date any current reward balances expire will also be available.

Additionally, the TCCart application will interface with a Payment Processing Service Provider to obtain credit card approval for a given purchase.  The TCCart application will also interact with a NotifierUtility to send an email to the customer when a purchase is completed, when a credit/reward is received, and when a customer obtains VIP status for the following year.

The application is being developed to align with future needs for incrementatl, iterative work cadences and possible adaptation of agile software development processes, as an alternative to waterfall and traditional sequential development methods.

## 4 Major Features (Optional)

## 5 Scope and Limitations

The initial version of the TCCart application will focus on the the needs of the customer and cart manager to facilitate credit card payments, rewards management (tracking, earning, usage), purchase display management, and customer account creation and maintenance. The system will only maintain limited information that identifies a customer beyond the Customer ID.  

In particular this means the following features will not be available:

5.1  The system will not maintain credit card information.

5.2  The system will not maintain physical addresses for customers (Street, City, State, Zip, etc.)

5.3  The system will not provide salutation or gender information (Mr.,Mrs., Ms., Sir, Female, Male, etc.)

5.4  The system will not generate paper receipts.
