import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class MkdirTest {
	 // Test cases for the method mkdir() in the class Directory.
	
	@Test
	public void testMkdir() {
		// make a directory in the current directory.
		Directory test = new Directory("home"); 
		test.mkdir("f1"); 
		test.mkdir("f2"); 
		File file1 = new File("file1", test, "hello"); 
		assertEquals(test.ls(), "f1\nf2\nfile1");
	}
}
