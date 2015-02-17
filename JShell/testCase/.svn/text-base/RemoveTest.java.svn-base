import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class RemoveTest {
	 // Test cases for the method rm() in the class Directory.
	
	@Test
	public void testRmOneDir() {
		// case1: remove 1 directory from the current directory.
		Directory test1 = new Directory("d1");
		test1.mkdir("f1");
		test1.mkdir("f2");
		test1.content[0].remove(false); // where content[0] is f1
		assertEquals(test1.ls(), "f2"); // only "f2" is left	
	}
			
	@Test
	public void testRmMultipleLevelDir(){
		// case2: remove a 2-level directory from the current directory. 
		Directory test2 = new Directory ("d2");
		test2.mkdir("f1");
		test2.mkdir("f2");
		((Directory)test2.content[0]).mkdir("f3");
		test2.content[0].remove(false);
		assertEquals(test2.ls(), "f2");
	}	
	
}
