# **Requirements Document -- Team 38**

The purpose of this project is to create an application for Lauren and her students which will help perfect the students' writing skills.  Currently, students often write essays utilizing long, wordy sentences.  The application will count the number of words per sentence within an essay.  The students will have the opportunity to make adjustments to their essay and run the application again until they are satisfied with the results of their sentence lengths.

##1 User Requirements

1.0.1  Users
	1.0.1.1 Users must be students and Professor Lauren
	1.0.1.2 Users will have varying technical skills, ranging from minimal to highly technical

1.0.2  Solution Type
	1.0.2.1 The solution must be a Java program.
	1.0.2.2 It must be executable from the command line with javac
	1.0.2.3 The application must be able to be run on multiple OSes
			1.3.3.1  Windows 
			1.3.3.2  Mac 

1.0.3 Files for Analyzing
	1.0.3.1 The user should be able to provide a file path to the file they wish to be analyzed as a command line argument.
	1.0.3.2 Files to be analyzed will be raw text files

1.0.4 Analyzing Options
	1.0.4.1 Users should be able to specify which delimiters count as sentence separators. Their choices should be from 			those identified as acceptable by Lauren.	
	1.0.4.2 The user should be able to specify a minimum word length, defaulting to 3 characters

1.0.5 Output - Results

	1.0.5.1 The program's output should provide the user with the average sentence length, rounded down to the nearest 	 	    integer
	1.0.5.2 The program should be able to run repeatably after the student changes their document, displaying new 				results.

1.0.6 Error Conditions
	1.0.6.1 Error conditions should display friendly messages to the user to help assist them in correcting any identified issues.

###1.1 Software Interfaces

1.1.1 The program will use standard Java libraries only. 

1.1.2 JRE 1.7u80

1.1.3 The program will work on any Windows, Linux and OS X

1.1.4 The user's computer runs everything locally and receives no data from a server, etc.

###1.2 User Interfaces

The user will interact with the product via a terminal command line interface. They will be able to specify the file they wish to input and some additional flag options to change the way the program will process the text file. The program will provide "user-friendly" readable errors to guide the user onto correct program usage and formatting.

1.2.1  The user interface must be executed from a command line by typing <path>/javac <appname><filename><flags>
1.2.2  There will be user friendly error messages guiding them to correct program usuage

###1.3 User Characteristics
Describe those general characteristics of the intended users of the product, including educational level, experience, and technical expertise.

1.3.1 Intended users
	1.3.1.1 Users are University students and Lauren, the Professor.
1.3.2 Educational Level
	1.3.2.1 College level
	1.3.2.2 College Professor
1.3.3 Experience
	1.3.3.1 No prior experience required
1.3.4 Technical expertise
	1.3.4.1 Varying degrees of technical proficiency
		1.3.4.1.1 Ranging from no experience to highly proficient.

##2 System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements. This part of the document should provide a numbered (possibly hierarchical) list of simple, complete, and consistent functional and non-functional requirements. 

????

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


