import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class LsTest {
    // test cases for ls() in the class Directory.
	
	@Test
	public void testLsEmpty(){
		// empty directory. expect an empty list(string)
		Directory test1 = new Directory("/");
		assertEquals("", test1.ls());
	}
	
	@Test
	public void testLsMultipleDir() {
		//make 2 directories in a home directory.
		Directory test2 = new Directory("/");  
		test2.mkdir("f1");
		test2.mkdir("f2");
		test2.mkdir("f3");
		// directories should be returned in separated lines
		assertEquals("f1\nf2\nf3",test2.ls());
	}	
	
	@Test
	public void testLsFile(){
		// case3: show the path of the file. 
		JShell test3 = new JShell();
		test3.echo("hellooo", ">", "f1");
		assertEquals(((File)test3.searchInAll("f1")).ls(), "/f1/");
	}
}
