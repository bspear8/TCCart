# Design Document

*This is the template for your design document. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Team 38

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the design, as well as issues that may influence the design process.*

### 1.1 Assumptions

*Describe any assumption, background, or dependencies of the software, its use, the operational environment, or significant project issues.*

1.1.1 Each installation of the app has exactly one user.

1.1.2 The software user is authenticated using the built-in mechanisms of the Android device.

1.1.3 The software depends on an external library for printing cards.

1.1.4 The software depends on an external library for scanning customer cards.

1.1.5 The software depends on an external library and for processing credit cards.

1.1.6 The system depends on an external service for processing credit cards.

1.1.7 The software depends on an external library for sending emails.

1.1.8 The system depends on an external service for sending emails.

1.1.9 The device on which the app is installed has Internet access.

### 1.2 Constraints

*Describe any constraints on the system that have a significant impact on the design of the system.*

1.2.1 The software must be compatible with Android API Level 15 and greater.

### 1.3 System Environment

*Describe the hardware and software that the system must operate in and interact with.*

1.3.1 The software shall run on the Android operating system.


## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work. These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

*This section should provide and describe a diagram that shows the various components and how they are connected. This diagram shows the logical/functional components of the system, where each component represents a cluster of related functionality. In the case of simple systems, where there is a single component, this diagram may be unnecessary; in these cases, simply state so and concisely state why.*

This component diagram demonstrates the simplicity of the TC Cart system. The diagram could be expanded to include components for Customer, Transaction, and Item. However, these components are better represented in the Class Diagram. Additionally, this diagram explicitly takes components such as the User Interface and the Persistence into account whereas the Class Diagram has no notion of these components.

![Component Diagram](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/Docs/component-diagram.png "TCCart Component Diagram")

### 2.2 Deployment Diagram

*This section should describe how the different components will be deployed on actual hardware devices. Similar to the previous subsection, this diagram may be unnecessary for simple systems; in these cases, simply state so and concisely state why.*

All components of the TC Cart system will be deployed on a single Android device. Thus, it is unnecessary to provide a deployment diagram.

## 3 Low-Level Design

*Describe the low-level design for each of the system components identified in the previous section. For each component, you should provide details in the following UML diagrams to show its internal structure.*

### 3.1 Class Diagram

*In the case of an OO design, the internal structure of a software component would typically be expressed as a UML class diagram that represents the static class structure for the component and their relationships.*

![Class Diagram](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/design-team.png "TCCart Class Diagram")

### 3.2 Other Diagrams

*<u>Optionally</u>, you can decide to describe some dynamic aspects of your system using one or more behavioral diagrams, such as sequence and state diagrams.*

## 4 User Interface Design
*For GUI-based systems, this section should provide the specific format/layout of the user interface of the system (e.g., in the form of graphical mockups).*

