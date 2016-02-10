package edu.gatech.seclass.project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;


public class Core {
	
	private int _minWordLength;
	private HashSet<Character> _delimiters;
	
	
	public Core(char[] delimiters, int minWordLength) {
		this._minWordLength = minWordLength;
		this._delimiters = new HashSet<Character>();

		for (char c : delimiters) {
			this._delimiters.add(new Character(c));
		}
	}
	
	private Boolean isDelimiter(char c) {
		
		return this._delimiters.contains(new Character(c));
	}
	
	public double Calculate(Reader r) throws IOException {
		
		ArrayList<Double> sentenceLengths = new ArrayList<Double>();
		
		int i;
		int currentNumWords = 0;
		int currentWordLength = 0;
		for (i = r.read(); i != -1; i = r.read()) {
			
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
		
		return this.average(sentenceLengths);
	}
	
	private double average(ArrayList<Double> lengths) {
		
		double total = 0.0;
		
		for (Double d : lengths) {
			total += d;
		}
		
		return total / ((double)lengths.size());
	}
	
	public static Reader LoadFileStream(String filePath) throws UnsupportedEncodingException, FileNotFoundException {
		FileInputStream in = new FileInputStream(filePath);
		InputStreamReader r = new InputStreamReader(in, "US-ASCII");
		
		return r;

	}

}
