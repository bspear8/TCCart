# **Requirements Document -- Team 38**

The purpose of this project is to create an application for Lauren and her students which will help perfect the students' writing skills.  Currently, students often write essays utilizing long, wordy sentences.  The application will count the number of words per sentence within an essay.  The students will have the opportunity to make adjustments to their essay and run the application again until they are satisfied with the results of their sentence lengths.

##1 User Requirements

###1.1 Software Interfaces

1.1.1 The program shall use Java Runtime Environment 1.7 with only standard libraries.

1.1.2 The program shall be required, but not restricted to operate on Windows, OS X, and Linux operating systems.

1.1.3 The end user shall run the program locally.

1.1.4 The program shall operate on plaintext files.  

###1.2 User Interfaces

The user will interact with the product via a terminal command line interface. They will be able to specify the file they wish to input and some additional flag options to change the way the program will process the text file. The program will provide "user-friendly" readable errors to guide the user onto correct program usage and formatting.

1.2.1  The user interface shall be executed from a command line by typing <path>/javac <appname> <filename> <flags>

1.2.2  Error conditions shall display relevant error messages to the user.  

###1.3 User Characteristics

####1.3.1 Intended users

1.3.1.1 The program shall require no prior experience or training to operate.  

1.3.2.1 The program shall require no knowledge of of the underlying technologies.  

##2 System Requirements

###2.1 Functional Requirements

2.1.1. The program shall be executable from the command line using the "javac" command without additional options options switches.

2.1.2. The user shall provide a file path to the file they wish to be analyzed as a command line argument.

2.1.3. Users shall be able to specify which delimiters count as sentence separators, using the flag '-d'.

2.1.4. The default sentence delimiters shall be:
- Question marks
- Periods
- Semicolons
- Colons
- Exclamation marks

2.1.6. The user shall be able to specify a minimum word length, using the flag -l.

2.1.7. The default minimum word length shall be three (3).

2.1.8. The program output shall be the average sentence length, rounded down to the nearest integer.

###2.2 Non-Functional Requirements

2.2.1. Error conditions will display friendly messages to the user to help assist them in correcting any identified issues.
	
2.2.2. All code required to execute the program that is not part of the standard JDK, will be included as source code with the program.
	
2.2.3. The testing platform shall be restricted to only the Java Runtime Environment and standard libraries. 


