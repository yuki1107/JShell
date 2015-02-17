
/**
 * @author Huda Mohamad Salleh
 * @author Yue Jun Ding
 * @author Fanling Luo
 * @author Ying Qi He
 */

public class CommandDocs {
	//////////////////////FIELD/////////////////////

	protected String docs;
	protected String method;

	///////////////////CONSTRUCTOR//////////////////

	public CommandDocs(String command){
		method = command;
		docs = "";
	}

	////////////////////METHOD//////////////////////

	/**
	 * Return the documentation for mkdir
	 * @return String
	 */ 

	public String mkdirDocstring(){
		return ("mkdir DIR ...\nCreate a directory DIR, which maybe" +
		" relative to the current directory or may be a full path.");
	}

	/**
	 * Return the documentation for cd
	 * @return String
	 */ 

	public String cdDocstring(){
		return ("cd DIR \nChange directory to DIR, which may be" +
				" relative to the current directory or may be a full" +
				" path. \nAs with Unix, .. means a parent directory and" +
				" a . means the current directory. The directory" +
				" \nseparator must be /, the forward slash. The root of" +
		" the file system is a single slash / .");
	}

	/**
	 * Return the documentation for ls
	 * @return String
	 */ 

	public String lsDocstring(){
		return ("ls [-R] [PATH ...] \nIf -R is present, recursively list" +
				" subdirectories. \nIf no paths are given, print the" +
				" contents (file or directory) of the current directory," +
				" with a \nnew line following each of the content (file or" +
				" directory) \nOtherwise, for each path p, the order" +
				" listed: \n\t If p specifies a file, print p \n\t If p" +
				" specifies a directory, print p, a colon, then \n\t the" +
				" contents of that directory, then an extra line. \n\t If" +
		" p does not exist, print a suitable message.");
	}


	/**
	 * Return the documentation for pwd
	 * @return String
	 */ 

	public String pwdDocstring(){
		return ("pwd \nPrint the current working directory, including" +
		" the whole path.");
	}

	/**
	 * Return the documentation for mv
	 * @return String
	 */ 

	public String mvDocstring(){
		return ("mv OLDPATH NEWPATH \nMove item OLDPATH to NEWPATH." +
				" Both OLDPATH and NEWPATH may be relative to the current" +
				"\ndirectory or may be full paths. If NEWPATH is a" +
		" directory, move item into the directory.");
	}

	/**
	 * Return the documentation for cp
	 * @return String
	 */ 

	public String cpDocstring(){
		return ("cp OLDPATH NEWPATH \nLike mv, but don't remove OLDPATH." +
		" If OLDPATH is a directory, recursively copy the contents.");
	}

	/**
	 * Return the documentation for echo
	 * @return String
	 */ 

	public String echoDocstring(){
		return ("echo STRING [>OUTFILE] \nIf OUTFILE is not provided, print" +
				" STRING on the shell. Otherwise, put STRING into file" +
				" OUTFILE. \nSTRING is a string of characters surrounded" +
				" by quotations marks. This create a new file if OUTFILE" +
				" \ndoes not exists and erases the old content if OUTFILE" +
				" already exists. In either case, the only thing \nin" +
				" OUTFILE should be a string. \necho STRING >> OUTFILE" +
				" \nLike the previous command, but appends instead of" +
		" overwrites");
	}

	/**
	 * Return the documentation for rm
	 * @return String
	 */ 

	public String rmDocstring(){
		return ("rm [-f] PATH ... \nConfirm with the user that they want to" +
				" delete PATH, and if so, remove it from the system. If PATH" +
				" \nis a directory, recursively remove all files and" +
				" directories in it, prompting for \nconfirmation for each" +
		" one.\nIf -f is supplied, do not confirm: just remove.");
	}

	/**
	 * Return the documentation for find 
	 * @return String
	 */ 

	public String findDocstring(){
		return ("find REGEX PATH ... \nRecursively search PATH for file" +
				" names containing REGEX and print them (including the" +
		" path), \none per line.");   
	}

	/**
	 * Return the documentation for grep
	 * @return String
	 */ 

	public String grepDocstring(){
		return ("grep [-R] REGEX PATH \nIf -R is not supplied, print" +
				" any lines containing REGEX in PATH, which must be a" +
				" file. \nIf -R is supplied, and PATH is a directory," +
				" recursively traverse the directory and, for all lines" +
				" \nin all files that contain REGEX, print the path to" +
				" the file (including the file name), then a colon, " +
		" \nthen the line that contained REGEX.");
	}

	/**
	 * Return the documentation for man
	 * @return String
	 */ 

	public String manDocstring(){
		return "man \nDisplay a short documentation for the Command.";
	}

	/**
	 * Return the documentation for exit
	 * @return String
	 */ 

	public String exitDocstring(){
		return "exit \nQuit the program.";
	}

	/**
	 * Return the documentation for the appropriate command input
	 * @return String
	 */

	public String printDocumentation(){
		if (method.equals("mkdir"))
			docs = mkdirDocstring();
		else if (method.equals("cd"))
			docs = cdDocstring();
		else if (method.equals("ls"))
			docs = lsDocstring();
		else if (method.equals("pwd"))
			docs = pwdDocstring();
		else if (method.equals("mv"))
			docs = mvDocstring();
		else if (method.equals("cp"))
			docs =  cpDocstring();
		else if (method.equals("echo"))
			docs = echoDocstring();
		else if (method.equals("rm"))
			docs = rmDocstring();
		else if (method.equals("find"))
			docs = findDocstring();
		else if (method.equals("grep"))
			docs = grepDocstring();
		else if(method.equals("man"))
			docs = manDocstring();
		else if(method.equals("exit"))
			docs = exitDocstring();
		else
			docs = "Invalid command input!";
		return docs;
	}
}

