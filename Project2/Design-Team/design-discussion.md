





#Team 38 Project 2  
####_Deliverable 0_




Team Members:  
Ben Pearce, bpearce9  
Carol Stone, cstone41  
Daniel Dersch, ddersch3  
Blaine Spear, bspear8  

####Individual Designs Review

#####Design 1
![alt text](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Individual/bspear8/design1.png?raw=true "Design 1")

Pros:

- Details public and private methods and attributes.
- Shows class composition.
- Modular structure that would work well for the program. 
- Shows utility classes and one to one or one to many relationships.
- References external Java libraries
- Transaction class has a means for differentiating pending/complete
- A customer contains a list of Transactions. Allows ease in retrieving purchase history for a specific user. 

Cons:

- Needs external library connections.
- Lacks descriptors between classes describing how they use other or interact with other classes.
- Transaction should have some sort of association between both Credit and VIPStatus. (It isn’t apparent how the system would list each discount for a given Transaction.)
- Not sure why CartManager is associated with a Credit. (Credit and Customer’s relationship may be sufficient.)
- Since payments are handled by an external library, the Payment class may not be necessary. 
- Credit card number probably best not stored as an int (not enough digits in 32-bit integer).
- DiscountUsed is probably not necessary since there is already a credit member in the transaction class.
- Value in credit should be a decimal value, not an int.


#####Design 2
![alt text](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Individual/bpearce9/design.png?raw=true "Design 2")

Pros: 

- Uses good descriptors between classes describing relationship.  
- Shows one to one or one to many relationships on major classes.
- Customer has an aggregate relationship with Transaction.
- It is fitting that a single Transaction consists of many Product objects.

Cons: 

- Detail private versus public attributes and methods.
- Diagram utility classes.
- The CoffeeAndTeaCart class needs an aggregate relationship with Customer where one CoffeeAndTeaCart can have 0 to many Customer objects.
- A Customer having only one Credit associated with it isn’t a perfect design (though could work given the requirements). 
- What about the case where a Credit expires, and then the Customer earns another Credit? The system should be able to store Credit history? 
- Missing interface and library relationships.


#####Design 3
![alt text](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Individual/cstone41/design3.png?raw=true "Design 3")

Pros: 

- Diagrammed and showed interaction between classes and external libraries and hardware connections.
- Labeled most major connections.
- Having both a Customer and CustomerAccount class could be helpful.
- CartManagerUtility - this seems to be a static class since it has Utility in the name. (Good approach since we  won’t be storing the Customers in memory in the final design. Could implement it as a Singleton class.)


Cons: 

- Some attributes listed as public instead of private.
- Some class connection relationships are not entirely clear without reading design description.
- Needs a few more passthroughs to better clarify multiplicities between relationships.
- VIPStatus as a boolean of the Customer class is insufficient since a Customer can have up to 2 VIP statuses at any given time. (One for the current year and one for the next year.)
- CustomerAccount has a property called purchasesYtd. Teammate feels this would be better served by being a method.



#####Design 4
![alt text](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Individual/ddersch3/design4.png?raw=true "Design 4")

Pros: 

- Clear connections and relationships between classes. 
- Descriptions on most major connections and attributes or methods that clearly indicate whether a class “contains” another class or how it uses another class. 
- Provides a very high level of detail.  
- Clearly shows interaction between external libraries.



Cons: 

- Should specify public versus private on attributes and methods.
- If there are separate classes for TeaItem and CoffeeItem, there should be a class of OtherItem 
- Items should have a name attribute.  
- Remove the separate Discount class and only use VIP Discount and Credit Discount, since these discounts are calculated in separate ways with separate dependencies.
- Are dependent or aggregated classes required in the attribute lists?  Wouldn’t the relationship alone show the presence without needing the atrribute as a member of the class?
- Needs a way to track separate transactions - perhaps a transaction ID.


####Team Design
![alt text](https://github.gatech.edu/gt-omscs-softeng/6300Spring16Team38/blob/master/Project2/Design-Team/design-team.png?raw=true "Team Design")

Our final “Team Design” is a modified version of “Design 4.” The following modifications were made:
- Added private and public UML modifiers to all methods and attributes.
- Added “OtherItem” class to enable application flexibility.
- Added name attribute to Item class.
- Added Interface and External notation where applicable.

####Summary
During our design discussion process, Team 38 looked for a diagram that was thoroughly detailed and left little to the imagination. This ultimately led to choosing to modify and utilize “Design 4” as the team design because it was the most detailed and clear diagram with very little of the implementation details left to be assumed or decided upon. While many of the diagrams were similar, we felt this design would require the fewest modifications to “perfect.” Most of the modifications dealt with corner cases that the original author oversaw and a fresh pair of eyes caught, or simply adding “nice to have” details to the diagram.
