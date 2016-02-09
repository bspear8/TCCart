package edu.gatech.seclass.project1;



public class CommandLineArguments {
	
    private final String DEFAULT_DELIMITTERS = ".:;!?"; 
    private final int DEFAULT_MIN_WORD_LENGTH = 4;
	
	private String[] _rawArgs;
	
	private String _filePath;
	
	private char[] _delimiters;
	
	private int _minimumWordLength;
	
	public CommandLineArguments(String[] args) {
		this._rawArgs = args;
	}
	
	private void processArgs() {
		Boolean foundPath = false;
		Boolean foundMinWordLengthFlag = false;
		Boolean foundDelimittersFlag = false;
		String delimiters = this.DEFAULT_DELIMITTERS;
		int minWordLength = this.DEFAULT_MIN_WORD_LENGTH;
		String filePath = null;
		
		for (int index = 0; index < this._rawArgs.length; index++) {
			String arg = this._rawArgs[index];
			
			if (arg == "-d" && !foundDelimittersFlag) {
				foundDelimittersFlag = true;
				index++;
				if (index < this._rawArgs.length) {
					delimiters = this._rawArgs[index];
					continue;
				}
			}
			
			if (arg == "-l" && !foundMinWordLengthFlag) {
				foundMinWordLengthFlag = true;
				index++;
				if (index < this._rawArgs.length) {
					minWordLength = Integer.parseInt(this._rawArgs[index]);
				}
			}
			
			if (!foundPath) {
				foundPath = true;
				filePath = this._rawArgs[index];
			}
			
		}
		
		this._delimiters = delimiters.toCharArray();
		this._minimumWordLength = minWordLength;
		this._filePath = filePath;
		
	}

	public char[] getDelimiters() {
		return _delimiters;
	}
	
	public String getFilePath() {
		return this._filePath;
	}
	
	public int getMinWordLength() {
		return this._minimumWordLength;
	}


}
