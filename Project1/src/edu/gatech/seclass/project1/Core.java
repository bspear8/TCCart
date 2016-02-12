package edu.gatech.seclass.project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Core Class
 * Takes the arguments from the Wc main function, reads the characters in 
 * and counts each word, then returns the average word length.
 */
public class Core {
	
	private int _minWordLength;
	private HashSet<Character> _delimiters;
	private InputStreamReader _r;
	
	/*
	 * Constructor
	 */
	public Core(char[] delimiters, int minWordLength) {
		this._minWordLength = minWordLength;
		this._delimiters = new HashSet<Character>();

		for (char c : delimiters) {
			this._delimiters.add(new Character(c));
		}
	}
	
	/*
	 * Returns true if the character is in the set of delimiters
	 */
	private Boolean isDelimiter(char c) {
		
		return this._delimiters.contains(new Character(c));
	}
	
	/*
	 * Where the magic happens.
	 * Counts words (delimited by white space)
	 * Counts sentences (delimited by delimiter character set)
	 */
	public double Calculate() throws IOException {
		
		ArrayList<Double> sentenceLengths = new ArrayList<Double>();
		
		boolean empty = true;
		int i;
		int currentNumWords = 0;
		int currentWordLength = 0;
		for (i = this._r.read(); i != -1; i = this._r.read()) {
			empty = false;
			
			char ch = (char) i;
			
			if (this.isDelimiter(ch)) {
				if (currentNumWords > 0) {
					if (currentWordLength >= this._minWordLength) {
						sentenceLengths.add(new Double(currentNumWords + 1));
					} else {
						sentenceLengths.add(new Double(currentNumWords));
					}
					
				}
				currentNumWords = 0;
				currentWordLength = 0;
			} else if (Character.isWhitespace(ch)) {
				if (currentWordLength >= this._minWordLength) {
					currentNumWords++;
				}
				currentWordLength = 0;
			} else {
				currentWordLength++;
			}
		
		}
		if(empty){
			return 0;
		}
		if(sentenceLengths.isEmpty()){
			return currentNumWords;
		}
		
		return this.average(sentenceLengths);
	}
	
	/*
	 * Calculates average
	 */
	private double average(ArrayList<Double> lengths) {
		
		double total = 0.0;
		
		for (Double d : lengths) {
			total += d;
		}
		
		return total / ((double)lengths.size());
	}
	
	/*
	 * IO Function
	 */
	public void LoadFileStream(String filePath) throws UnsupportedEncodingException, FileNotFoundException {
		FileInputStream in = new FileInputStream(filePath);
		this._r = new InputStreamReader(in, "US-ASCII");
	}

}
