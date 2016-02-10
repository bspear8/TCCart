package edu.gatech.seclass.project1;


public class CommandLineArguments {
	
    public static final String DEFAULT_DELIMITTERS = ".:;!?"; 
    public static final int DEFAULT_MIN_WORD_LENGTH = 4;
	
	private String[] _rawArgs;
	
	private String _filePath;
	
	private char[] _delimiters;
	
	private int _minimumWordLength;
	
	public CommandLineArguments() {
	}
	
	public void setArgs(String[] args) {
		this._rawArgs = args;
		this.processArgs();
	}
	
	private void validate() throws FilePathNotProvidedException {
		if (this._filePath == null || this._filePath.equals("")) {
			throw new FilePathNotProvidedException("Please specify a file to process");
		}
		
		if (this._minimumWordLength <= 0) {
			throw new InvalidMinimumLengthException("Bad ", Integer.toString(this._minimumWordLength));
		}
		
	}
	
	private void processArgs() throws FilePathNotProvidedException {
		Boolean foundPath = false;
		Boolean foundMinWordLengthFlag = false;
		Boolean foundDelimittersFlag = false;
		String delimiters = CommandLineArguments.DEFAULT_DELIMITTERS;
		int minWordLength = CommandLineArguments.DEFAULT_MIN_WORD_LENGTH;
		String filePath = null;
		
		for (int index = 0; index < this._rawArgs.length; index++) {
			String arg = this._rawArgs[index];
			
			if (arg.equals("-d") && !foundDelimittersFlag) {
				foundDelimittersFlag = true;
				index++;
				if (index < this._rawArgs.length) {
					delimiters = this._rawArgs[index];
					continue;
				}
			} else if (arg.equals("-l") && !foundMinWordLengthFlag) {
				foundMinWordLengthFlag = true;
				index++;
				if (index < this._rawArgs.length) {
					try {
						minWordLength = Integer.parseInt(this._rawArgs[index]);
					} catch (NumberFormatException e) {
						throw new InvalidMinimumLengthException("Bad length", this._rawArgs[index]);
					}
				}
			} else if (!foundPath) {
				foundPath = true;
				filePath = this._rawArgs[index];
			}
			
		}
		
		this._delimiters = delimiters.toCharArray();
		this._minimumWordLength = minWordLength;
		this._filePath = filePath;
		
		this.validate();
		
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
