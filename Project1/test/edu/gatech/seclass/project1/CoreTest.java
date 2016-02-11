package edu.gatech.seclass.project1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoreTest {
	
	private char[] delims = {'.'};
	private Core c;

	@Before
	public void setUp() throws Exception {
		c = new Core(delims, 3);
	}

	@After
	public void tearDown() throws Exception {
		delims = null;
		c = null;
	}

	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Basic Test on a File with two three word sentences.  
	 */
	public void test1() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/Test1.txt");
		assertEquals(3.0, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Basic Test on a File with sentences of 1, 2, and 3 words.  
	 */
	public void test2() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/Test2.txt");
		assertEquals(2.0, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Basic Test on a File with sentences of 2, 3, 2, 3 words.  
	 */
	public void test3() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/Test3.txt");
		assertEquals(2.5, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Basic Test on a File with one sentence.  
	 */
	public void test4() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/Test4.txt");
		assertEquals(6.0, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Tests That one word sentences are processed correctly.    
	 */
	public void oneWordSentences() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/oneWordSentences.txt");
		assertEquals(1.0, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Tests that multiple delimiters work correctly.    
	 */
	public void multipleDelimiters() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		char[] mul_delims = {'.', '?', '!'};
		c = new Core(mul_delims, 3);
		c.LoadFileStream("junitfiles/multipleDelimiters.txt");
		assertEquals(2.0, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Tests that words below the minimum length are not counted.   
	 */
	public void excludeWordsBelowMinimum() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/excludeWordsBelowMinimum.txt");
		assertEquals(2.0, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Tests that other delimiters are treated "stupidly" and ignored or seen as part 
	 * of the words.   
	 */
	public void ignoreOtherDelimiters() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/ignoreOtherDelimiters.txt");
		assertEquals(5.0, c.Calculate(), 0.001);
	}
	
	@Test(expected=FileNotFoundException.class)
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Test that a bad filename throws an exception.
	 */
	public void badFileTest() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/badFileTest.txt");
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Check the result of an empty file is 0
	 */
	public void emptyFileBehavior() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/emptyFileBehavior.txt");
		assertEquals(0.0, c.Calculate(), 0.001);
	}
	
	@Test
	/**
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * 
	 * Check that sentences of zero length are ignored.
	 */
	public void zeroLengthSentencesIgnored() throws IOException, UnsupportedEncodingException, FileNotFoundException {
		c.LoadFileStream("junitfiles/zeroLengthSentencesIgnored.txt");
		assertEquals(6, c.Calculate(), 0.001);
	}
	
}
