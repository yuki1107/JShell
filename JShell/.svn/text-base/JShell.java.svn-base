

import java.util.Scanner;
import java.net.*;
import java.io.*;

/**
 * @author Huda Mohamad Salleh
 * @author Yue Jun Ding
 * @author Fanling Luo
 * @author Ying Qi He
 */

public class JShell {

	/////////////////FIELD/////////////////////////

	public String userInput;
	public String command;
	public String[] arguments;
	public int argIndex;

	//for redirection
	public String outputStr;

	final public int DEFAULT_NUM_ARGS =100;

	// current JShell directory
	private Directory currDir;
	//home directory
	private Directory home;



	//////////////////CONSTRUCTOR//////////////////////////////

	/**
	 * Construct a new JShell
	 */

	public JShell(){
		userInput = "";
		command = "";
		arguments = new String[DEFAULT_NUM_ARGS];
		argIndex = 0;
		home = new Directory(""); 
		currDir = home;
		outputStr = "";
	}

	//////////////////METHODS/////////////////////////////////

	/***************************************
	 * Main Method 						  * /
	 ***************************************/

	public static void main (String args []){ 


		// *** need two while loops to handle the case where only 
		// spaces are entered
		while (true){

			JShell shell1 = new JShell();

			while (true){
				// clear the arguments each time the method called
				// prints working directory + prompt
				shell1.printPrompt(); 
				// gets user input
				String input= "";
				Scanner in = new Scanner(System.in);
				input = in.nextLine();

				// sets the userinput field
				shell1.setUserInput(input);


				// *************handles EXIT command**********************
				String arr[] = input.split(" ", 2);
				String command1 = arr[0];
				//exit
				if (command1.equals("exit")){
					return;
				}
				// ^^^^^^^^^^^^handles EXIT command^^^^^^^^^^^^^^^^^^^^^^^

				// *** this part handles the case where only spaces 
				// 	   are entered
				// *** if the length of the input is zero, then start the 
				//     loop over again
				if (shell1.getInputCount()==0){
					break;
				}

				// parses user input into commands and arguments
				shell1.parseInput();

			}
		}
	}

	/***************************************
	 * printPrompt Method 				  * /
	 ***************************************/

	/**
	 * prints the command line prompt, i.e. working directory + #
	 * @exception NullPointerException
	 */

	public void printPrompt(){
		try{									
			System.out.print(currDir.path + " ");
			System.out.println("# ");
		} catch (NullPointerException e){
			currDir = home;
			printPrompt();
		}
	}	 

	/***************************************
	 * setUserInput Method 				  * /
	 ***************************************/


	/**
	 * sets the user input
	 * @param input
	 */

	public void setUserInput(String input){
		this.userInput = input;
	}


	/**
	 * gets the number of words in the input
	 * @return int the input string length
	 */

	public int getInputCount(){
		String[] input = userInput.split(" +");
		return input.length;
	}

	/**
	 * Check if the user enters valid inputs
	 * @param command
	 * @param input
	 * @return boolean
	 */

	public boolean validArgument(String command, int argLength){
		if (command.equals("mkdir") || command.equals("echo") 
				|| command.equals("rm")) {
			return argLength >= 1;
		}
		else if (command.equals("find") || command.equals("grep")){
			return argLength >= 2;
		}
		else if (command.equals("pwd")){
			return argLength == 0;
		}
		else if( command.equals("cd") || command.equals("cat") 
				|| command.equals("get") || command.equals("man")){
			return argLength == 1;
		}
		else if (command.equals("mv") || command.equals("cp")){
			return argLength == 2;
		}
		return true;
	}


	/***************************************
	 * redirection Method 				  * /
	 ***************************************/

	/**
	 * Check if the user need to save the output to a file
	 * @param arguments
	 * @param argIndex
	 * @return boolean
	 * @exception ArrayIndexOutOfBoundsException
	 */

	public boolean needRedirection(String[] arguments, int argIndex){
		// check if the input string needs redirection
		try {
			return (arguments[argIndex - 2].equals(">") 
					|| arguments[argIndex - 2].equals(">>"));
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}


	/**
	 * Save the output string to a file
	 * @param output
	 * @param sign
	 * @param filename
	 */

	public void redirection(String output, String sign, String filename){
		// redirect the output       	
		if (sign.equals(">") || sign.equals(">>")) {
			echo(outputStr, sign, filename);
		}
	}


	/***************************************
	 * parseInput Method				  * /
	 ***************************************/

	/** 
	 * Handle the command and arguments appropriately
	 *  and if the output need redirection
	 * @exception NullPointerException
	 */

	public void parseInput(){
		String[] input= userInput.split(" +");
		// the first word of the array is the command
		command = input[0];

		// everything else is the argument
		for (int i = 1; i < input.length; i++) {
			arguments[argIndex] = input[i];
			argIndex++; 
		}

		// for redirection
		String strSign = "";
		String fileName = "";
		boolean redirect = needRedirection(arguments, argIndex);
		if (!command.equals("echo") && redirect){
			strSign = arguments[argIndex - 2];
			fileName = arguments[argIndex - 1];
			argIndex = argIndex - 2;
		}

		if (validArgument(command, argIndex)){
			// prints command in first line, arguments in second line
			//printOutput();
			commandMatcher(input, command, arguments);
		}

		else
			System.out.println("Invalid input argument!!");

		if (!outputStr.equals("") && !redirect)
			System.out.println(outputStr);
		redirection((outputStr.concat("\n")), strSign, fileName);
		argIndex = 0; // reset the argument index back to 0  
		outputStr = ""; // empty the output string
	}

	/**
	 * prints command in one line and args in the next
	 */
	public void printOutput(){
		String s ="";
		System.out.print(command+" ");
		for (int i = 0; i < argIndex; i++){
			s = s + arguments[i] + " ";
		}

		System.out.println(s);
	}


	/***************************************
	 * commandMatcher Method 			  * /
	 ***************************************/

	/**
	 * Use the right command
	 * @param input
	 * @param command
	 * @param arguments
	 * @param argIndex
	 */

	public void commandMatcher(String[] input, String command,
			String[] arguments){                                            	   
		if (command.equals("mkdir"))
			mkdir(arguments);
		else if (command.equals("cd")) 
			cd(arguments);
		else if (command.equals("ls"))
			ls(arguments);
		else if (command.equals("pwd"))
			outputStr = pwd();
		else if (command.equals("mv")||command.equals("cp"))
			mvOrcp();
		else if (command.equals("cat")) 
			cat(arguments);  
		else if (command.equals("get"))
			getUrl(arguments[0]);
		else if (command.equals("echo"))
			toOutfile(input);
		else if (command.equals("rm"))
			rm();
		else if (command.equals("find"))
			find(arguments);
		else if (command.equals("grep"))
			grep();
		else if (command.equals("man"))
			man(arguments);
		else 
			System.out.println("Invalid command input!");
	}

	/***************************************
	 * mkdir Method 					  * /
	 ***************************************/
	/**
	 * Make directory inside the current directory or a given full path
	 * @param filePathArray
	 * @exception NullPointerException
	 */

	public void mkdir(String[] arguments){
		FileDir temp = home;
		// make new directories relative to current directory
		// if the given output is a path	
		if (arguments[0].substring(0,1).equals("/")){
			String[] filePathArray = arguments[0].split("/");
			mkdirByPath(temp, filePathArray);
		}
		else {
			for (int i = 0; i < argIndex; i++){
				if (currDir.searchByName(arguments[i]) == null)
					currDir.mkdir(arguments[i]);  
				else
					System.out.println("Directory " + arguments[i] + 
					" already exits!");
			}      
		}
	}

	/**
	 * Make directory by given path
	 * @param temp
	 * @param filePathArray
	 * @exception NullPointerException
	 */

	public void mkdirByPath(FileDir temp, String[] filePathArray){
		try {
			// get the correct location to add new directory
			//	assumption the given path must relative to currDir
			for(int j = 0; j < filePathArray.length; j++){
				if(filePathArray[j].length() != 0){
					if (j != filePathArray.length - 1){
						temp = temp.searchByName(filePathArray[j]);
					} else{
						if (temp.searchByName(filePathArray[j])
								!= null)
							System.out.println("Directory " +
							"already exits!");
						else
							((Directory)temp).mkdir(filePathArray[j]);
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Invalid path");
		}
	}

	/***************************************
	 * cd Method	 					  * /
	 ***************************************/

	/**
	 * Change the current directory
	 * @param arguments
	 */

	public void cd(String[] arguments){
		// get its parent directory or home directory
		if (arguments[0].equals(".."))
			currDir = currDir.getParent(home);

		// do nothing, since its already at the current directory
		else if (arguments[0].equals("."));

		else if (arguments[0].equals("/"))
			currDir = home;
		else
			cdByPath(arguments);
	}

	/**
	 * Change the current directory to the specified path
	 * @param path
	 * @exception ClassCastException
	 */


	public void cdByPath(String[] path){
		// the given path is inside the current directory
		String[] filePathArrays = currDir.pathToArray(path[0]);

		// Assumption: if a full path is given, the first element of the
		//  filePathArrays must be " "
		if (filePathArrays[0].length() == 0){
			FileDir temp = searchByPath(filePathArrays, home);
			if (temp == null || temp instanceof File)
				System.out.println("Directory not found!!!");
			else
				currDir = (Directory)temp;
		}
		else {
			// keep track of the first working directory
			Directory beginDir = currDir;
			for(int j = 0; j < filePathArrays.length; j++){
				Directory tempDir;
				for (int i = 0; i < currDir.contentIndex; i++){
					try {
						tempDir = (Directory) currDir.content[i];
						if (tempDir.name.equals(filePathArrays[j]))
							currDir = tempDir;  
					} catch (ClassCastException e){ 
					}
				}
			}

			// if there is no change in the current directory,
			//   it means that the directory file does not exist
			if (currDir == beginDir){
				System.out.println("The directory file does not exist");
			}
		}
	}


	/***************************************
	 * ls Method 						  * /
	 ***************************************/

	/**
	 *  list the content of the directory
	 *  @param filePath
	 */

	public void ls(String[] arguments){
		// if no argument given, list all the content of the
		// 	current directory
		if (argIndex == 0)
			outputStr = currDir.ls();

		else if (arguments[0].equals("-R")){
			// there is no given path
			if (argIndex == 1)
				lsRecursive(currDir.path, currDir);

			// the path is given
			else 
				lsRecursive(arguments[argIndex - 1], home);
		}
		else 
			outputStr = lsByPath(arguments[0]);
	}


	/**
	 *  list the content of the directory by the given path
	 *  @param filePath
	 *  @return String
	 */ 

	public String lsByPath(String filePath) {
		// convert the given path as an array
		String[] filePathArray = currDir.pathToArray(filePath);
		FileDir temp = searchByPath(filePathArray, home);

		if (temp instanceof Directory) {
			return "." + filePath + ":\n"+ ((Directory)temp).ls();
		}
		else
			return ((File)temp).ls();
	}

	/**
	 * Handles the ls method for recursion
	 * @param filePath
	 * @param dir
	 * @exception ClassCastException
	 */

	public void lsRecursive(String filePath, Directory dir){
		if (filePath.equals(dir.path)){
			outputStr = outputStr + lsByPath(filePath).concat("\n");
			for (int i = 0; i < dir.contentIndex; i++){
				try {
					// base case: if the file path is a directory
					//  without any directory in its content, do nothing
					if (dir.content[i].contentIndex == 0){
						outputStr = outputStr + lsByPath(dir.content[i].
								path).concat("\n");
					}
					// recursive case: subdirectories
					else {
						filePath = (dir.content[i]).path;	
						lsRecursive(filePath, (Directory)dir.content[i]);
					}
				} catch (ClassCastException e) {
					// if the content of the directory is a file
					((File) dir.content[i]).ls();
				}
			}
		}
		else {
			dir = (Directory) searchByPath(currDir.pathToArray(filePath),
					dir);
			lsRecursive(filePath, dir);
		}
	}



	/***************************************
	 * pwd Method 						  * /
	 ***************************************/


	/**
	 * print the working directory
	 * @return String
	 */

	public String pwd(){
		return currDir.path;
	}

	/***************************************
	 * mv or cp Method	 				  * /
	 ***************************************/

	/**
	 * Move the files or copy the files depend on user's input
	 */

	public void mvOrcp(){
		String [] oldPath = arguments[0].split("/");
		String [] newPath = arguments[1].split("/");
		FileDir oldfile;
		FileDir newfile;

		if (arguments[0].substring(0, 1).equals("/"))
			oldfile = searchByPath(oldPath, home);
		else
			oldfile = searchByPath(oldPath, currDir);

		if (arguments[1].substring(0, 1).equals("/"))
			newfile = searchByPath(newPath, home);
		else{
			newfile = searchByPath(newPath, currDir);
		}

		if (oldfile == null)
			System.out.println(arguments[0] + " doesn't exist.");
		else if (newfile == null)
			System.out.println(arguments[1] + " doesn't exist.");
		else{
			if (command.equals("mv"))
				currDir.mv(oldfile, newfile);
			else
				currDir.cp(oldfile, newfile);
		}
	}

	/***************************************
	 * cat Method 						  * /
	 ***************************************/


	/**
	 * Display the content of the given path
	 * @param arguments
	 */

	public void cat(String[] arguments){
		File outFile = (File) searchInAll(arguments[0]);
		outputStr = outFile.cat();
	}

	/***************************************
	 * get Method 						  * /
	 ***************************************/

	/**
	 * get a file from the url given
	 * @param userUrl
	 * @exception MalformedURLException
	 * @exception IOException
	 */

	public void getUrl(String userUrl){
		try {
			//get url content
			URL url = new URL(userUrl);
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							conn.getInputStream()));
			String urlString = "";
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				urlString = urlString + inputLine + "\n";
			}
			br.close();
			String [] fileName = userUrl.split("/");
			File urlContent = new File(
					fileName[fileName.length - 1], ((FileDir)currDir), 
					urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}       


	/***************************************
	 * echo Method 						  * /
	 ***************************************/


	/**
	 * 1. replace the content of a file with an input string;
	 * 2. append an input string to the end of the content of a file;
	 * 3. if the file doesn't exist, create a new file with
	 * 		 the input string.     
	 * @param strChar
	 * @param strSign
	 * @param fileName
	 * @exception NullPointerException
	 */

	public void echo(String strChar, String strSign, String fileName){
		File outFile = (File) searchInAll(fileName);
		// if the file is already there
		try {      
			if (strSign.equals(">")){
				outFile.replace(strChar);
			}
			else if (strSign.equals(">>")){
				outFile.append(strChar);
			}
		} 
		// the file is not there
		catch (NullPointerException e) {
			File newFile = new File(fileName, currDir, strChar);    		
		}
	}

	/**
	 * Do necessary action for echo, either create a new file, overwrite
	 *  old file or append to old file.
	 * @param input
	 * @exception ArrayIndexOutOfBoundsException
	 */
	public void toOutfile(String[] input){
		// print the command in the first line 
		// and the argument in the second
		String strInput = ""; // make a string for the argument "STRING"
		// change the whole argument into string
		for (int i = 1; i < input.length; i++)
			strInput = strInput + input[i] + " ";
		try {
			String [] str = strInput.split("\"");
			String strChar = str[1] + "\n"  ;
			// only input string is given, print the string out
			if (str.length < 4 && str[2].equals(" ")){
				outputStr = strChar;
			}
			// given filename and a string
			else {
				String[] inputFile = str[2].split(" ");
				// get the appropriate sign
				String strSign = inputFile[1];   
				String fileName = inputFile[2];
				echo(strChar, strSign, fileName);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid input!!");
		}
	}

	/***************************************
	 * rm Method 						  * /
	 ***************************************/

	/**
	 * remove the file by the path that's given from user,
	 * either with confirmation or not, depend on user's input
	 */

	public void rm(){
		String [] pathArray;
		boolean withConfirm;
		if (arguments[0].equals("-f")){ // don't confirm
			pathArray = arguments[1].split("/");
			withConfirm = false;
		}
		else{
			pathArray = arguments[0].split("/");
			withConfirm = true;
		}
		// check if the path argument is relate to current directory or full
		FileDir searchFrom;
		if (arguments[0].substring(0, 1).equals("/"))
			searchFrom = home;
		else
			searchFrom = currDir;

		FileDir removeFile;
		for (int i = pathArray.length - 1; i >= 0; i--){	
			removeFile = searchByPath(pathArray, searchFrom);
			if (removeFile == null){
				System.out.println("Path not found!");
				return;
			}
			if (currDir == removeFile)
				currDir = ((Directory)removeFile.parent);
			if (removeFile != home)
				removeFile.remove(withConfirm);
			pathArray[i] = "";
		}
	}

	/***************************************
	 * find Method 						  * /
	 ***************************************/

	/**
	 * returns FileDir object depending whether 
	 * the PATH was relative or full
	 * @param path
	 * @return FileDir
	 */

	public FileDir fileDirByPathType(String path){
		String[] s;
		FileDir f;
		if (path.contains("/")){ // >>>>> given a path

			if (path.charAt(0)=='/'){ // a full path
				s = path.split("/"); 
				// search from the root directory
				f = searchByPath(s, home); 
			}
			else{ // a relative path
				s = path.split("/"); 
				f = searchByPath(s, currDir);
			}
		}
		else{
			String[] m = {path};
			f = searchByPath(m, currDir);
		}
		if (f==null)
			System.out.println("the path given does not exist!");
		return f;
	}

	/**
	 * Search fileDir containing regular expression pattern
	 * @param args
	 * @exception NullPointerException
	 */

	public void find(String[] args){
		String regex = args[0];
		String path = args[1];
		FileDir f;
		try{

			if (regex.contains("\"")) //remove quotation marks
				regex = regex.substring(1, regex.length()-1);

			f = fileDirByPathType(path);

			if(f==null){
				return;
			}

			if ( (f instanceof File)){// >>> implement find
				outputStr = outputStr + ((File)f).find(regex);
			}
			else if ( (f instanceof Directory)){
				outputStr = outputStr + ((Directory)f).find(regex);
			}

		}catch(NullPointerException e){
			System.out.println("the path given does not exist!");
		}
	}

	/***************************************
	 * grep Method 						  * /
	 ***************************************/

	/**
	 * helper method for grep
	 * implements grep method on the FileDir object
	 * @param f
	 * @param regex
	 * @param arguments
	 */


	public void grepHelper(FileDir f, String regex, String[] arguments){

		if (arguments[0].equals("-R")){//>>>>recursive implementation
			if ( (f instanceof File)){
				outputStr = outputStr + ((File)f).grep(regex,
				"recursive");
			}
			else if ( (f instanceof Directory)){
				outputStr = outputStr + ((Directory)f).grep(regex,
				"recursive");
			}
		}
		else{//>>>>non recursive implementation

			if ( (f instanceof File)){
				outputStr = outputStr + ((File)f).grep(regex,
				"non recursive");
			}
			else if ( (f instanceof Directory)){
				outputStr = outputStr + ((Directory)f).grep(regex, 
				"non recursive");
			}
		}
	}

	/**
	 * Get the filename and regular expression pattern
	 * @param regex
	 * @param recurs
	 * @exception NullPointerException
	 */

	public void grep(){
		String regex, path;
		FileDir f;
		try{
			if (argIndex==3 &&arguments[0].equals("-R")){
				//***********recursive
				regex = arguments[1];
				path = arguments[2];
			}
			else if (argIndex==2 && !arguments[0].equals("-R")){
				regex = arguments[0];
				path = arguments[1];
			}
			else{
				System.out.println("invalid input!");
				return;
			}

			if (regex.contains("\"")) 
				//remove quotation marks
				regex = regex.substring(1, regex.length()-1);

			f = fileDirByPathType(path);
			if(f==null){
				return;
			}
			grepHelper(f, regex, arguments);
		}
		catch(NullPointerException e){
			System.out.println("the path given does not exist!");
		}
	}

	/***************************************
	 * man Method 						  * /
	 ***************************************/

	/**
	 * Print the documentation for the given command
	 * @param arguments
	 */

	public void man(String[] arguments){
		try{
			CommandDocs userCommand = new CommandDocs(arguments[0]);
			outputStr = userCommand.printDocumentation();
		} catch (NullPointerException e) {
			arguments[0] = "";
			CommandDocs userCommand = new CommandDocs(arguments[0]);
			outputStr = userCommand.printDocumentation();
		}
	}


	/***************************************
	 * Search Methods 					  * /
	 ***************************************/ 

	/**
	 * Given a path array, search by the path starting from the given
	 * FileDir return the FileDir that being found or null if not found.
	 * @param path - a array indicate the path
	 * @param current - FileDir indicates where to start searching
	 */
	public FileDir searchByPath(String [] path, FileDir current){
		for (String file: path){
			if(file.length() != 0)
				current = current.searchByName(file);
		}
		return current;
	}

	/**
	 * Search the file by given name in the whole File system
	 * @param filename
	 */
	public FileDir searchInAll(String fileName){
		return currDir.searchAll(fileName, home);
	}

	/**
	 * get the current directory
	 */

	public Directory getCurrDir(){
		return currDir;
	}
}

