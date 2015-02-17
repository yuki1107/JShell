import static org.junit.Assert.*;

import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class PwdTest {
    // test cases for pwd() in the class JShell.
	
	@Test
	public void testPwdHome() {
		//test case with only a home directory. expected "/"
		JShell test1 = new JShell();
		assertEquals("/", test1.pwd());
	}
	
	@Test
	public void testPwdLongerPath(){
		// test cases with a longer path. 
		
		JShell test2 = new JShell();
		String[] folder = {"f1"};
		test2.mkdir(folder);
		
		String[] filePathArray = {"/f1"};
		test2.cd(filePathArray);
		assertEquals(test2.pwd(), test2.getCurrDir().path);
		
	}

}
