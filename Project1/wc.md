WC General Commands Manual
 
NAME
java wc {arguments} --- executes the java program "wc" to calculate the average sentence length 
 
SYNOPSIS
java wc [arguments]  [filepath_filename]

DESCRIPTION
	For each operand that specifies a default_delimiter and default_min_word_length, the "java wc" command executes the program 'wc' from the command line and returns a result indicating the average word length in a sentence to the user.  

	If no operand is specified for the default_delimiter, then the defaults delimiters used to identify the end of words will be ".:;!?" If no operand is specified for the default_min_word_length, then 4 is used.

The following options are available:

-d Flag used to identify the delimiters to use indicate the end of a sentence.
	Example:  -d<sequence_of_characters>  --- there should not be a space between the flag and the value
	     -d;/?-
	     delimiters may appear in any order
	     delimiters may only be single characters
	     
-l  Flag to identify the minimum word length 
	Any value may be including a value of zero (0), there should not be a space between the flag and the value
	Example:  -l3
	     
Example when specifying both delimiter and minimum word length flags:
	java wc -l4 -d./;:! [filepath_filename]

Other information:
filepath -- a full path to the filename must be provided

filename -- this must be a raw text file


	     
	     
