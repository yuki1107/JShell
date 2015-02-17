import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class GetURLTest {
	 // Test cases for the method getURL in the class JShell.
	
	@Test
	public void testGetUrl() {
		JShell test = new JShell();
		// call the method getUrl, get the contents from the link.
		test.getUrl("http://www.cs.cmu.edu/~spok/grimmtmp/073.txt");
		// now the current directory should contains the link file 
		assertEquals("073.txt", test.getCurrDir().ls());
			
	}

}
