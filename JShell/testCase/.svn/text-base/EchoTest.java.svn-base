import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class EchoTest {
	 // Test cases for the method echo() in the class JShell.
	  
	@Test
	public void testEchoReplace() {
		// case1: in an existing file, replace the original content.
		//with a new string 
		JShell test1 = new JShell();
		File file1 = new File("file1", test1.getCurrDir(), "abcdefg");
		test1.echo("hihihihihi", ">", "file1");
		assertEquals("hihihihihi", file1.cat());
	}
	
	@Test
	public void testEchoAppend(){
		// case2: in an existing file, append a string to the original content
		// to a separated line
		JShell test2 = new JShell();
		File file2 = new File("file2", test2.getCurrDir(), "abcdefg");
		test2.echo("hihihihihi", ">>", "file2");
		assertEquals("abcdefghihihihihi", file2.cat());
	}
	
	@Test
	public void testEchoCreate(){
		// case3: create a file with the input string if the file DNE.
		JShell test3 = new JShell();
		test3.echo("the file does not exist.", ">", "file3");
		// a file named "file3" should be created in the current home directory.
		assertEquals("file3", test3.getCurrDir().ls());
		// test if file3 contains the input string.
		assertEquals(((File)test3.getCurrDir().content[0]).contentstr,
				"the file does not exist.");		
	}
	
}
