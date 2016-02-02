# **Requirements Document -- Team 38**

The purpose of this project is to create an application for Lauren and her students which will help perfect the students' writing skills.  Currently, students often write essays utilizing long, wordy sentences.  The application will count the number of words per sentence within an essay.  The students will have the opportunity to make adjustments to their essay and run the application again until they are satisfied with the results of their sentence lengths.

##1 User Requirements

	1. The program should be an application.
	2. The users should  be able to execute the application from the command line.
	3. The user should be able to provide a file path to the file they wish to be analyzed as a command line argument.
	4. Multiple computer OS systems will need to be supported.
	5. File types to be analyzed are raw text files.
	6. User should be able to specify which delimiters count as sentence separators. Their choices should be from those identified as acceptable by Lauren
	7. The user should be able to specify a lower limit for word length, defaulting to Lauren's guess at what value might be good.
	8. The program should only count words greater than 3 characters
	9. The program's output should provide the user with the average sentence length, rounded down to the nearest integer.
	10. Error conditions should display friendly messages to the user to help assist them in correcting any identified issues.
	11. The application must be very user friendly and able to be run by those with technical skills ranging from none to highly technical.
 
###1.1 Software Interfaces

The program will use standard Java libraries only. It will be platform independent. 

###1.2 User Interfaces

The user will interact with the product via a terminal command line interface. They will be able to specify the file they wish to input and some additional flag options to change the way the program will process the text file. The program will provide "user-friendly" readable errors to guide the user onto correct program usage and formatting.

###1.3 User Characteristics

Users are students and Lauren, the Professor.  They are expected to function at college level. The users have varying degrees of technical proficiency, ranging from no experience to very technically proficient.

##2 System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of simple, complete, and consistent functional and non-functional requirements. 
 
###2.1 Functional Requirements

	1. The program should have a main method and should be executable from the command line using the javac command without additional options/switches.
	2. The user should be able to provide a file path to the raw text file they wish to be analyzed as a command line argument.
	3. Users should be able to specify which delimiters count as sentence separators, using the flag -d, defaulting to Lauren's initial thoughts on what should be used as delimiters.
	4. Commas should not be used as delimiters for the end of the sentence per our Instructor.
	5. Acceptable delimiters for the users to mark the end of the sentence are:  question marks, periods, semicolons, colons, exclamation mark
	6. The user should be able to specify a lower limit for word length, using the flag -l, defaulting to Lauren's guess at what value might be good.
	7. The program should only count words greater than 3 characters.
	8. The program's output should be the average sentence length, rounded down to the nearest integer.


###2.2 Non-Functional Requirements

	1. Error conditions should display friendly messages to the user to help assist them in correcting any identified issues.
	2. Multiple computer OS systems will need to be supported.
	3. The application should be written in Java.
	4. The application should use Java 1.7 JRE version
	5. The application must not create any nonstandard Java libraries
	6. All code required to execute the program that is not part of the standard JDK, must be included as source code with the program.
	7. The Testing platform should be on machines with a vanilla installation of Java 1.7.


