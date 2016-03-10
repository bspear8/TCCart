# Design Document

**Author**: Team 38

## 1 Design Considerations

### 1.1 Assumptions

1.1.1 Each installation of the app has exactly one user.

1.1.2 The software user is authenticated using the built-in mechanisms of the Android device.

1.1.3 The software depends on an external library for printing cards.

1.1.4 The software depends on an external library for scanning customer cards.

1.1.5 The software depends on an external library and for processing credit cards.

1.1.6 The system depends on an external service for processing credit cards.

1.1.7 The software depends on an external library for sending emails.

1.1.8 The system depends on an external service for sending emails.

1.1.9 The device on which the app is installed has Internet access.

1.1.10 The app only supports vertical orientation.

1.1.11 The app is installed by the user using the resources checked in to the git repository.

### 1.2 Constraints

1.2.1 The software must be compatible with Android API Level 15 and greater.

### 1.3 System Environment

1.3.1 The software shall run on the Android operating system.

## 2 Architectural Design

### 2.1 Component Diagram

This component diagram demonstrates the simplicity of the TC Cart system. The diagram could be expanded to include components for Customer, Transaction, and Item. However, these components are better represented in the Class Diagram. Additionally, this diagram explicitly takes components such as the User Interface and the Persistence into account whereas the Class Diagram has no notion of these components.

![Component Diagram](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/component-diagram.png "TCCart Component Diagram")

### 2.2 Deployment Diagram

All components of the TC Cart system will be deployed on a single Android device. Thus, it is unnecessary to provide a deployment diagram.

## 3 Low-Level Design

### 3.1 Class Diagram

![Class Diagram](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/design-team.png "TCCart Class Diagram")

### 3.2 Other Diagrams

This version of the design does not include any additional diagrams.

## 4 User Interface Design

4.1 Home Screen

![](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/mainscreen.png "")

4.2 List of customers screen

![](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/customersscreen.png "")

4.3 Add customer screen

![](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/addcustomer.png "")

4.4 Edit customer screen
![](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/editcustomer.png "")

4.5 List all of a customer's transactions screen

![](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/customertransactions.png "")

4.6 List a single transaction of a customer's screen

![](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/customertransaction.png "")

