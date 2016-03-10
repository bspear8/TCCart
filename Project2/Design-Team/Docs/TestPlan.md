# Test Plan

**Author**: Benjamin Pearce

## 1 Testing Strategy

### 1.1 Overall Strategy

As this will be an Android App built on Android Studio, the preferred test library will be JUnit.  A test suite comprising unit, integration, and system level tests will be developed alonside the application.  

For all tests developed, the developer should ensure the test case is failed when expected to fail and passes when expected to pass.  Both cases are required to ensure a test is not written in such a way that it will always report a false positive.  For each test, there should be at least one case that tests each expected output and each expected edge case.  

#### 1.1.1 Unit Tests

Each class will have an associated unit test to verify methods associated with that class are implemented correctly.  For methods that require other user-defined classes as an input, a stub will be used in place of the dependent class.  Unit tests will avoid testing methods or interfaces that are not exclusive to the unit under test.  

#### 1.1.2 Integration Tests

Integration tests will test the relationships between multiple classes and with external libraries.    

#### 1.1.3 System Tests

##### 1.1.3.1 Automated Tests

System tests will be based on use cases described in the use-case model.  The system tests seek to simulate expected use by actors interfacing with the system. Steps in each use-case will be broken down into discrete tests to isolate areas where failures are present.  

##### 1.1.3.2 Manual Tests

Some system tests will be dependent on aspects which cannot be tested automatically, such as screen layout.  These tests will be run manually. During development, these tests may be run using an emulator, but to ensure proper funcitonality, they must be run on actual hardware prior to production.  

#### 1.1.4 Regression Tests

Regression tests exist to ensure addition of new features do not break existing functionality, or to ensure refactored code still passes test cases.  Regression tests will consist of all previously written test cases for the unit, integration, and system tests. 

Changes to the system's application protocol interface (API) should be avoided wherever possible to preserve existing test cases.  In the event that the API must be changed, all existing test cases dependent on that API must be updated accordingly.

The test suite will be built to run automatically, with the exception of some system tests run manually.  Prior to any commit to the master branch, the entire test suite must be run in its entirety and all tests must be in a passed state.  If functionality has changed to make a particular test case obsolete, the test case must be amended or removed prior to commitment to the master branch.  Changes to code which do not affect layout of screens or functionality of controls, do not require the manual tests to be rerun.  Manual tests do have to be rerun if changes are made to the user interface.  

### 1.2 Test Selection

#### 1.2.1 Unit Tests

Unit Tests will utilize white-box techniques to ensure that the funtions in each class provide predicted output given a set of inputs.  Tests will involve inspection of return values of methods or checking the state of the instance of the class before and after a function.  

#### 1.2.2 Interface Tests

Where multiple classes interact with each other, testing will be done following a white-box methodology where function return values and states of instances of the class will be inspected.  For interface tests regarding external libraries or hardware interface, the external library will be viewed as a black box to be used by the class, however the external library will be viewed as a black box.

#### 1.2.3 System Tests

System tests will be broken into smaller test cases to isolate if and where use-cases fail.  Following a white-box approach, the user-case which represents the test will be separated into multiple tests and the outputs or states will be checked at each step.  

### 1.3 Adequacy Criterion

#### 1.3.1 Unit Tests

Unit tests will test have both positive and negative versions of the same test.  This will ensure that a test is not inadvertently written which always passes regardless of input.  Adequate measures, such as using stubs of dependent classes will be used to avoid inadvertent testing of other units or the interfaces between them.  

#### 1.3.2 Integration Tests

Testing will simulate input using stubs for external interfaces so as to avoid test dependency or inadvertently testing the external library. As hardware is beyond the scope of this software project, and requiring working hardware will increase cost of testing, all hardware interfaces will be simulated as well and and data provided from hardware will be simulated.

#### 1.3.3 System Tests

System tests will be based on the defined use-cases.  The use case diagram will demonstrate the different outputs expected during the test.  The test for each use case will be broken into steps consisting of smaller test cases to isolate where in the use-case the test might fail.  

### 1.4 Bug Tracking

#### 1.4.1 Bug Tracking

Bugs will be tracked using "Issues" in GitHub. When a bug is observed, detailed notes describing the nature of the bug, its importance, and steps to reproduce the bug.  A new branch shall be created from the latest master build to correct the bug. 

#### 1.4.2 Bug Correction

The steps used to reproduce the bug should be incorporated into a new test case, or set of test cases that adequately test the bug. The new test case must be observed to "fail" and demonstrate the behavior of the bug before any coding is to be done to correct the bug. Changes to the code to correct the bug shall be limited in scope to bug being corrected. That is, if another bug is observed, it should have its own bugfix branch and test suite.  When sufficient code changes have been implemented to correct the bug, a regression test of the entire test suite must be completed to ensure new code changes did not affect existing functionality.

Upon successful completion of new tests, and of the complete regression test, code should be inspected to ensure it meets style and maintainability requirements.  If code must be refactored, the entire test suite should be rerun.  All tests must pass before commitment to the master branch. An exception to this may be made if new bugs produced are of lesser importance than the bug being corrected.  

#### 1.4.3 Bug Importance

All bugs must be classified based on their level of importance.  The following levels of importance are defined:
- Documentation: There is an error in documentation which does not affect how the system runs
- Enhancement: This is an system improvement and is not required but may improve system performance, reduce costs, or improve user experience. 
- Minor: A bug that is unlikely to occur and which only poses minor inconvenience to a user if it is encountered, and workarounds are possible.
- Moderate: A bug that is likely to occur and poses moderate to significant inconvenience for which a workaround may or may not be possible, and if not, the functionality is not excessively hindered.  
- Major: A bug that is likely to occur and for which a workaround is not possible and significantly reduces system functionality.
- Critical: A bug which can break the system to such a degree that use must be discontinued until a proper fix is implemented.  This includes security flaws which expose personal or financial data.  

### 1.5 Technology

As the system will be built in Java using the Android Studio IDE, it will utilize JUnit for a test framework. Espresso may be used to automate user interface testing of the application wherever possible.  

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*

### 2.1 Unit Tests

| Purpose              | Test Procedure           | Expected Output         | Actual Output   |
|----------------------|--------------------------|-------------------------|-----------------|
Item: getPrice | Create Item, run getPrice method | equal to price set in constructor

### 2.2 Integration Tests

| Purpose              | Test Procedure           | Expected Output         | Actual Output   |
|----------------------|--------------------------|-------------------------|-----------------|
Customer: addTransactions | Create customer, create transaction, run Customer.addTransaction with the transaction as an input | Customer.transactions list includes the transaction
Customer: addVipDiscountStatus | Create customer, create VIPDiscount run Customer.addVipDiscountStatus with the VIPDiscount as an input | verify Customer is now VIP


### 2.3 System Tests
Purpose | Test Procedure | Expected Output | Actual Output |
---|---|---|---
Addition of Customer | Manager selects 'Add Customer', Manager enters information for customer, Manager selects 'Create Customer' | New customer with expected fields is added to the array of customers
Edit of Customer information | Manager selects 'Edit Customer Information', Manager enters new information for customer, Manager selects 'Accept Changes' | Customer information is changed from prior data to new data
Process Transactions | Manager selects 'Process Transaction', Manager receives input from CreditCard stub | Transaction with finalized information
Process Transaction with Customer Card | Transaction is created, input stub of scanner API used to select a customer, customer is added to the transaction, transaction is processed with credit card | Transaction with finalized information, valid email information to provide to email API
List Transactions | Manager selects 'List Transactions', Manager receives input from CustomerCardScanner stub | List of all transactions associated with that customer
Print Customer Card | Manager selects a customer from the system, Manager selects 'Print Customer Card' | Output meeting printer API requirements with customer QR code embedded




