import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class CpTest {
	// Test cases for the method cp() in the class Directory
	
	@Test
	public void testCp() {
        // test for moving one directory to another.
		Directory test1 = new Directory("home");
		test1.mkdir("d1");
		test1.mkdir("d2"); 
		test1.cp((FileDir)test1.content[0], (FileDir)test1.content[1]);
		//the home directory should still contain d1 after copying
		assertEquals(test1.ls(), "d1\nd2"); 
		// d2 also should contains d1.
		assertEquals("d1", ((Directory)test1.content[1]).ls()); 
	}
	
	@Test
	public void testCpMultipleLevel(){
		// test for moving a 2-level directory to another directory
		Directory test2 = new Directory("home");
		test2.mkdir("d1");
		test2.mkdir("d2"); 
		((Directory)test2.content[0]).mkdir("f1"); 
		((Directory)test2.content[0]).mkdir("f2"); 
		test2.cp((FileDir)test2.content[0], (FileDir)test2.content[1]);		
		// d2 also should contains d1.
		assertEquals("d1", ((Directory)test2.content[1]).ls());
		assertEquals(((Directory)test2.content[1].content[0]).ls(), "f1\nf2");
	}
	
	@Test
	public void testCpFile(){
		// test for copying a file to another directory
	    Directory test3 = new Directory("home"); 
	    File file1 = new File("file1", test3, "soooooo tired!!!!!!!!!!");
	    test3.content[0] = file1;
	    test3.mkdir("d1"); 
	    test3.cp((FileDir)test3.content[0], (FileDir)test3.content[1]); 
	    // the home directory should still contain the file. 
	    assertEquals(test3.ls(), "file1\nd1"); 
	    assertEquals(((Directory)test3.content[1]).ls(), "file1");     
	}
}
