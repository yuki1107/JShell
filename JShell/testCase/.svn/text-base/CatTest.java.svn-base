import static org.junit.Assert.*;
import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class CatTest {
   // Test cases for the method cat() in the class File.
	
	@Test
	public void testCatEmpty() {	
		// test with an empty file.
		File tester1 = new File( "file1");
		assertEquals(null, tester1.cat());		
	}
	
	@Test
	public void testCatExisting(){
		// test with a file containing string.
		FileDir home = new FileDir("home");
		File tester2 = new File("file2", home, "hellolalala");
		assertEquals("hellolalala", tester2.cat());
	}
}
