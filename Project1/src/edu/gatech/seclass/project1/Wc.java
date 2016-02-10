package edu.gatech.seclass.project1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class Wc {
	
	

	public static void main(String[] args) throws UnsupportedEncodingException, 
	FileNotFoundException, IOException {
		
		CommandLineArguments arguments = new CommandLineArguments();
		
		try {
			arguments.setArgs(args);
		} catch(FilePathNotProvidedException e) {
			System.err.println("ERROR: A file path was not specified as a command-line argument.");
			System.exit(1);
		} catch(InvalidMinimumLengthException e) {
			System.err.printf("ERROR: An invalid minimum word length (the -l flag) was provided '%s'", e.getBadValue());
			System.exit(1);
		}
		
		Reader r = Core.LoadFileStream(arguments.getFilePath());
		
		Core c = new Core(arguments.getDelimiters(), arguments.getMinWordLength());
		
		double result = c.Calculate(r);
		
		r.close();
		
		System.out.println(result);

	}
	
	

}
