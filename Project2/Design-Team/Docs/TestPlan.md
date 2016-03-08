# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \<person or team name\>

## 1 Testing Strategy

### 1.1 Overall Strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

As this will be an Android App built on Android Studio, the preferred test library will be JUnit.  A test suite comprising unit, integration, and system level tests will be developed alonside the application.  

For all tests developed, the developer should ensure the test case is failed when expected to fail and passes when expected to pass.  Both cases are required to ensure a test is not written in such a way that it will always report a false positive.  For each test, there should be at least one case that tests each expected output and each expected edge case.  

#### 1.1.1 Unit Tests

Each class will have an associated unit test to verify methods associated with that class are implemented correctly.  For methods that require other user-defined classes as an input, a stub will be used in place of the dependent class.  Unit tests will avoid testing methods or interfaces that are not exclusive to the unit under test.  

#### 1.1.2 Integration Tests

Integration tests will test the relationships between multiple classes and with external libraries.  Testing will simulate input using stubs so as to avoid test dependency on external libraries. As hardware is beyond the scope of this software project, and requiring working hardware will increase cost of testing, all hardware interfaces will be simulated as well and and data provided from hardware will be simulated.  

#### 1.1.3 System Tests

System tests will be based on user stories.  The system tests seek to simulate expected use by actors interfacing with the system. Steps in the user story will be broken down into discrete tests to isolate areas where failures are present.  

#### 1.1.4 Regression Tests

Regression tests exist to ensure addition of new features do not break existing functionality, or to ensure refactored code still passes test cases.  Regression tests will consist of all previously written test cases for the unit, integration, and system tests. 

Changes to the system's application protocol interface (API) should be avoided wherever possible to prevent breaking existing test cases.  In the event that the API must be changed, all existing test cases dependent on that API must be updated accordingly.

The test suite will be built to run automatically.  Prior to any commit to the master branch, the entire test suite must be run in its entirety and all tests must be in a passed state.  If functionality has changed to make a particular test case obsolete, the test case must be amended or removed prior to commitment to the master branch.  

### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### 1.4 Bug Tracking

#### 1.4.1 Bug Tracking

Bugs will be tracked using "Issues" in GitHub. When a bug is observed, detailed notes describing the nature of the bug, its importance, and steps to reproduce the bug.  A new branch shall be created from the latest master build to correct the bug. 

#### 1.4.2 Bug Correction

The steps used to reproduce the bug should be incorporated into a new test case, or set of test cases that adequately test the bug. The new test case must be observed to "fail" and demonstrate the behavior of the bug before any coding is to be done to correct the bug. Changes to the code to correct the bug shall be limited in scope to bug being corrected. That is, if another bug is observed, it should have its own bugfix branch and test suite.  When sufficient code changes have been implemented to correct the bug, a regression test of the entire test suite must be completed to ensure new code changes did not affect existing functionality.

Upon successful completion of new tests, and of the complete regression test, code should be inspected to ensure it meets style and maintainability requirements.  If code must be refactored, the entire test suite should be rerun.  All tests must pass before commitment to the master branch. An exception to this may be made if new bugs produced are of lesser importance than the bug being corrected.  

#### 1.4.3 Bug Importance

All bugs must be classified based on their level of importance.  The following levels of importance are defined:
- Documentation: there is an error in documentation which does not affect how the system runs
- Minor: A bug that is unlikely to occur and which only poses minor inconvenience to a user if it is encountered, and workarounds are possible.
- Moderate: A bug that is likely to occur and poses moderate to significant inconvenience for which a workaround may or may not be possible, and if not, the functionality is not excessively hindered.  
- Major: A bug that is likely to occur and for which a workaround is not possible and significantly reduces system functionality.
- Critical: A bug which can break the system to such a degree that use must be discontinued until a proper fix is implemented.  This includes security flaws which expose personal or financial data.  

### 1.5 Technology

As the system will be built in Java using the Android Studio IDE, it will utilize JUnit for a test framework.  

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*
