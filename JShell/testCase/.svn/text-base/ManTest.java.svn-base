import static org.junit.Assert.*;
import org.junit.Test;

/**
* @author Huda Mohamad Salleh
* @author Yue Jun Ding
* @author Fanling Luo
* @author Ying Qi He
*/

public class ManTest {
	 // Test cases for the method printDocumentation() in the class 
	 //CommandDocs.
	
	@Test
	public void testPrintDocumentation() {
		// Test if it shows the right documentation string for the command.
		CommandDocs a = new CommandDocs("pwd");
		assertEquals("pwd \n" + "Print the current working directory, " +
				"including the whole path.", a.printDocumentation());
	}
	
	@Test
	public void testPrintDocumentation2(){
		// Test: should show "Invalid command input" if the entering 
		// command DNE. 
		CommandDocs b = new CommandDocs("hello");
		assertEquals("Invalid command input!",b.printDocumentation());
	}

}
