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

2.1.8. The program output shall be the average sentence length.  It will be displayed to the console as a real number with 2 decimal points.  There will be no additional text included.

2.1.9  The minimum number of words in a sentence is one (1).

###2.2 Non-Functional Requirements

2.2.1. Error conditions will display friendly messages to the user to help assist them in correcting any identified issues.

2.2.1.1 Notify user if no file is specified.

2.2.1.2 Notify user if specified file does not exist.

2.2.1.3 Notify user if specified file is not readable.

2.2.1.4 Notify user if the specified minimum word length (see 2.1.6) is not valid. (Only positive integers are valid).
	
2.2.2. All code required to execute the program that is not part of the standard JDK, will be included as source code with the program.
	
2.2.3. The testing platform shall be restricted to only the Java Runtime Environment and standard libraries.

2.2.4  The program should be able to process 5000 characters per second on average.

2.2.5  A word will be defined as being greater than 3 characters.  The lower limit is 4 characters inclusive.

2.2.5.1  Numbers greater than 3 characters will be considered a word
	
2.2.5.2  "Mr." and "Mrs." do not require special handling
	
2.2.5.3  Only ASCII characters will be counted for this project.  No Unicode considerations necessary.
	
2.2.5.4  Contractions and hyphens will be considered as normal words and character.  No special handling is required
	
2.2.5.5  Line breaks do not count as sentence delimiters
	
2.2.5.6  A sentence can span multiple lines
	
2.2.5.7 Bulleted lists are nothing special.
	
2.2.5.8  A sentence that is length 0 should NOT be considered.  They should not lower the average.
	
2.2.5.9  Capitalization does not matter.

2.2.6  The program will only read one file at a time.

2.2.7  If a command flag is missing, an error message will be thrown

2.2.8  Delimiters are specified as typical:

2.2.8.1  -d <sequence_of_chars>
	
2.2.8.2 delimiters may appear in any order
	
2.2.8.3 delimiters are operating system dependent
	
2.2.8.4  delimiters replace defaults
	
2.2.8.5  Single characters as delimiters only

2.29  The program will NOT be compiled as a JAR

2.3.0  Characters with SPECIAL meanings on a command line are not our issue.  (We can suggest the users escape the special characters, but the problem belongs to whoever runs the program.)

2.3.1  Language does not matter.  (Spanish, English, gibberish, etc.)

2.3.2  If all sentences in file to be evaluated are of size 0, just return 0

2.3.3  Security issues are outside the scope of this project

2.3.4  Checking file permissions is outside the scope of this project, but we will provide an error to the user.

2.3.5  An error message will be provided if the file specified is not readable or does not exist

2.3.6  All error messages will start with "ERROR: <message>

2.3.7  A word will be defined as consecutive ASCII characters followed by a:

2.3.7.1 Tab
	
2.3.7.2 Newline
	
2.3.7.3 Space

2.3.8 Both /r and /r/n are considered whitespace

2.3.9  A standard rounding mode will be used in the program.  (.5 exclusive round down, .5 inclusive round up)
	2.3.9.1  round to  two decimal places, not to an integer

2.4.0  Average is arithmetic mean

2.4.1  There will be no status messages presented during runtime

2.4.2  If no delimiter is presented, then the result will be 1 sentence.

2.4.3  Output will go to stdout Errors to stderr

2.4.4  /n will mean a new word

2.4.5  The data will not be permanently stored

2.4.6  Error conditions will exist for command line arguments, well formed

2.4.7  An error condition will exist if the specified input file is not accessible

2.4.8  Software distribution is outside the scope of this project.



