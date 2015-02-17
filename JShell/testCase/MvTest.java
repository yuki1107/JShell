import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class MvTest {
	 // Test cases for the method mv() in the class Directory.
	
	@Test
	public void testMvSingleLevelDir(){
		// case1: test for moving 1 directory to another directory.
		Directory test1 = new Directory("home");
		test1.mkdir("d1");
		test1.mkdir("d2"); 
		test1.mv((FileDir)test1.content[0], (FileDir)test1.content[1]);
		// now the home directory should only contains the directory d2.
		assertEquals(test1.ls(), "d2");
		// directory d1 is in d2.
		assertEquals(((Directory)test1.content[0]).ls(), "d1");
	}
	
	@Test
	public void testMvMultipleLevelDir(){
		// case2: test for moving a 2-level directory to another directory
		Directory test2 = new Directory("home"); 
		test2.mkdir("d1");
		test2.mkdir("d2");
		((Directory)test2.content[0]).mkdir("f1");
		((Directory)test2.content[0]).mkdir("f2");
		test2.mv((FileDir)test2.content[0], (FileDir)test2.content[1]);
		// the directory d1 should be in d2
		assertEquals(((Directory)test2.content[0]).ls(), "d1");
		// the contents of d1 is moved into d2 with d1.
		assertEquals(((Directory)test2.content[0].content[0]).ls(), "f1\nf2");
	}
	
	
	@Test
	public void testMvFile(){
		// case3: test for moving a file into a directory
		Directory test3 = new Directory("home");
		File f1 = new File("f1", test3, "yoyoyoyo"); 
		test3.mkdir("d1"); 
		test3.mv((FileDir)f1, (FileDir)test3.content[1]); 
		// the home directory should only contain d1 after moving f1 in
		assertEquals(test3.ls(), "d1"); 
		// the file f1 should be in d1 now
		assertEquals(((Directory)test3.content[0]).ls(), "f1");
	}

}
