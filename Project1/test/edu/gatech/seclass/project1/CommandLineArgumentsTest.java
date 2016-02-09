package edu.gatech.seclass.project1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandLineArgumentsTest {

	private  CommandLineArguments myargs;
	private String SomeDirectoryPath = "/some/directory/path";
	
	@Before
	public void setUp() throws Exception {
		myargs = new CommandLineArguments();
	}

	@After
	public void tearDown() throws Exception {
		myargs = null;
	}
	
	/**
	 * Tests functionality when only the File Path is provided properly
	 */
	@Test
	public void testCommandLineArguments_PathOnly() {
		String[] args = {this.SomeDirectoryPath};
		myargs.setArgs(args);
		assertEquals(this.SomeDirectoryPath, myargs.getFilePath());
		assertEquals(CommandLineArguments.DEFAULT_MIN_WORD_LENGTH, myargs.getMinWordLength());
		assertArrayEquals(CommandLineArguments.DEFAULT_DELIMITTERS.toCharArray(), myargs.getDelimiters());
	}
	
	/**
	 * Tests functionality when the File Path is provided properly, along with Min Word Length flag
	 */
	@Test
	public void testCommandLineArguments_PathAndMinWordLength() {
		String[] args = {"-l", "7", this.SomeDirectoryPath};
		myargs.setArgs(args);
		assertEquals(this.SomeDirectoryPath, myargs.getFilePath());
		assertEquals(7, myargs.getMinWordLength());
		assertArrayEquals(CommandLineArguments.DEFAULT_DELIMITTERS.toCharArray(), myargs.getDelimiters());
	}
	
	/**
	 * Tests functionality when the File Path is provided properly, along with the custom delimiter flag
	 */
	@Test
	public void testCommandLineArguments_PathAndCustomDelimiters() {
		String[] args = {"-d", "abcd", this.SomeDirectoryPath};
		myargs.setArgs(args);
		assertEquals(this.SomeDirectoryPath, myargs.getFilePath());
		assertEquals(CommandLineArguments.DEFAULT_MIN_WORD_LENGTH, myargs.getMinWordLength());
		assertArrayEquals("abcd".toCharArray(), myargs.getDelimiters());
	}

	
	/**
	 * Tests functionality when the File Path is provided properly, 
	 * along with the custom delimiter flag
	 * and the minimum word length flag
	 */
	@Test
	public void testCommandLineArguments_WithAllFlags() {
		String[] args = {"-d", "abcdef", "-l", "9", this.SomeDirectoryPath};
		myargs.setArgs(args);
		assertEquals(this.SomeDirectoryPath, myargs.getFilePath());
		assertEquals(9, myargs.getMinWordLength());
		assertArrayEquals("abcdef".toCharArray(), myargs.getDelimiters());
	}
	
	/**
	 * Tests functionality when the File Path is provided first in the arg order, 
	 * along with the custom delimiter flag
	 * and the minimum word length flag
	 */
	@Test
	public void testCommandLineArguments_WithAllFlags_WithPathFirst() {
		String[] args = {this.SomeDirectoryPath, "-l", "9", "-d", "abcdef" };
		myargs.setArgs(args);
		assertEquals(this.SomeDirectoryPath, myargs.getFilePath());
		assertEquals(9, myargs.getMinWordLength());
		assertArrayEquals("abcdef".toCharArray(), myargs.getDelimiters());
	}
	
	/**
	 * Tests functionality when the File Path is not provided
	 */
	@Test(expected = FilePathNotProvidedException.class)
	public void testCommandLineArguments_NoFilePathProvided() {
		String[] args = {"-l", "9", "-d", "abcdef" };
		myargs.setArgs(args);
	}	
}
