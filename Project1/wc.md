WC General Commands Manual
 
###NAME  


Wc - calculates average sentence length from sentences in raw text file.
 
###SYNOPSIS  


java Wc [filepath_filename] [flags]  
OR  
java Wc [flags] [filepath_filename]

###DESCRIPTION  


For each operand that specifies a default_delimiter and default_min_word_length, the "java wc" command executes the program 'wc' from the command line and returns a result indicating the average word length in a sentence to the user.  


If no operand is specified for the default_delimiter, then the default delimiters 
used to identify the end of sentences will be ".:;!?" If no operand are specified for the default_min_word_length, 
then 4 characters will be used.

###OPTIONS  

**-d**  
Flag used to identify the delimiters to use indicate the end of a sentence.  
*Example:*  -d [sequence_of_characters]  --- there must be a space between the flag and the delimiter characters.
>	     -d ;/?-  
>	     delimiters may appear in any order  
>	     delimiters may only be single characters  
	    
**-l**  
Flag to identify the minimum word length.
Any value above 0 may be used, and there must be a space between the flag and the value.  
*Example:*  -l 3
	     
	     
Example when specifying both delimiter and minimum word length flags:  
>	     java wc -l4 -d./;:! [filepath_filename]


Other information:  

[filepath] -- a full path to the filename must be provided  

[filename] -- this must be a raw text file  


	     
	     
