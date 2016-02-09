package edu.gatech.seclass.project1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class Wc {
	
	

	public static void main(String[] args) throws UnsupportedEncodingException, 
	FileNotFoundException, IOException {
		
		CommandLineArguments arguments = new CommandLineArguments();
		arguments.setArgs(args);
		
		Reader r = Core.LoadFileStream(arguments.getFilePath());
		
		Core c = new Core(arguments.getDelimiters(), arguments.getMinWordLength());
		
		double result = c.Calculate(r);
		
		r.close();
		
		System.out.println(result);

	}
	
	

}
