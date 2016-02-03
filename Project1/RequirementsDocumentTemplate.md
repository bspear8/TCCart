# **Requirements Document -- Team 38**

The purpose of this project is to create an application for Lauren and her students which will help perfect the students' writing skills.  Currently, students often write essays utilizing long, wordy sentences.  The application will count the number of words per sentence within an essay.  The students will have the opportunity to make adjustments to their essay and run the application again until they are satisfied with the results of their sentence lengths.

##1 User Requirements

####1.0.1  Users
	1.0.1.1 Users shall be students and Professor Lauren
	1.0.1.2 Users will have varying technical skills, ranging from minimal to highly technical

####1.0.2  Solution Type
	1.0.2.1 The solution must be a Java program.
	1.0.2.2 It must be executable from the command line with javac
	1.0.2.3 The application must be able to be run on multiple OSes
			1.3.3.1  Windows 
			1.3.3.2  Mac 

####1.0.3 Files for Analyzing
	1.0.3.1 The user should be able to provide a file path to the file they wish to be analyzed as a command line argument.
	1.0.3.2 Files to be analyzed will be raw text files

####1.0.4 Analyzing Options

	1.0.4.1 Users should be able to specify which delimiters count as sentence separators. Their choices should be from 			those identified as acceptable by Lauren.	
	1.0.4.2 The user should be able to specify a minimum word length, defaulting to 3 characters

####1.0.5 Output - Results

	1.0.5.1 The program's output should provide the user with the average sentence length, rounded down to the nearest 	 	    integer
	1.0.5.2 The program should be able to run repeatably after the student changes their document, displaying new 				results.

1.0.6 Error Conditions
	1.0.6.1 Error conditions should display friendly messages to the user to help assist them in correcting any identified issues.

###1.1 Software Interfaces

	1.1.1 The program shall use Java Runtime Environment 1.7 with only standard libraries.
	1.1.3 The program shall be required, but not restricted to operate on Windows, OS X, and Linux operating systems.  
	1.1.4 The end user shall run the program everything locally, and receive no data from a external source.

###1.2 User Interfaces

The user will interact with the product via a terminal command line interface. They will be able to specify the file they wish to input and some additional flag options to change the way the program will process the text file. The program will provide "user-friendly" readable errors to guide the user onto correct program usage and formatting.

	1.2.1  The user interface shall be executed from a command line by typing <path>/javac <appname> <filename> <flags>
	1.2.2  Error conditions shall display relevant error messages to the user.  

###1.3 User Characteristics
Describe those general characteristics of the intended users of the product, including educational level, experience, and technical expertise.

####1.3.1 Intended users
	1.3.1.1 Users are college students and Lauren, the Professor.
	1.3.2 Educational Level
	1.3.2.1 Some college education
	1.3.2.2 College Professor
	1.3.3 Experience
	1.3.3.1 The program shall require no prior experience or training to operate.  
	1.3.4 Technical expertise
	1.3.4.1 The program shall not require technical knowledge of of the underlying technologies.  

##2 System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of simple, complete, and consistent functional and non-functional requirements. 

###2.1 Functional Requirements

	2.1.1. The program shall be executable from the command line using the "javac" command without additional options options switches.
	2.1.2. The user shall provide a file path to the file they wish to be analyzed as a command line argument.
	2.1.3. The input file shall be plain text.  
	2.1.3. Users shall be able to specify which delimiters count as sentence separators, using the flag '-d'.
	2.1.4. The default sentence delimiters shall include:
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


