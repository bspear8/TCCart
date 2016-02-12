WC General Commands Manual
 
NAME
java wc {arguments} --- executes the java program "wc" to calculate the average word length in a sentence
 
SYNOPSIS
java wc [arguments]  [filepath_filename]

DESCRIPTION
	For each operand that specifies a default_delimiter and default_min_word_length, the "java wc" command executes the program 'wc' from the command line and returns a result indicating the average word length in a sentence to the user.  

	If no operand is specified for the default_delimiter, then the defaults delimiters used to identify the end of words are ".:;!?" If no operand is specified for the default_min_word_length, then 4 is used.

The following options are available:

-d Switch used to identify the delimiters to use indicate the end of a sentence.
	Ex:  -d <sequence_of_characters>
	      -d 
	     delimiters may appear in any order
	     
