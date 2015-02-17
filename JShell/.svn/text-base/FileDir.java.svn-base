import java.lang.String;
import java.util.Scanner;

/**
 * @author Huda Mohamad Salleh
 * @author Yue Jun Ding
 * @author Fanling Luo
 * @author Ying Qi He
 */


public class FileDir {

	//////////////////////FIELD//////////////////////////////////
	protected String name; //file name or directory(folder) name
	protected FileDir [] content;
	protected String path;
	protected FileDir parent;
	protected int contentIndex;
	protected final static int CONTENT_SIZE = 1000;

	//////////////////////CONSTRUCTOR////////////////////////////

	/**
	 * Construct a new FileDir
	 * @param fileName - name of the FileDir
	 */

	public FileDir(String fileName){
		name = fileName;
		content = new FileDir[CONTENT_SIZE];
		path =  fileName + "/" ;
		contentIndex = 0;
	}

	/**
	 * Construct a new FileDir
	 * @param fileName - name of the FileDir
	 * @param parentDir - the parent FileDir
	 */

	public FileDir(String fileName, FileDir parentDir){
		name = fileName;
		content = new FileDir[CONTENT_SIZE];
		parent = parentDir;
		path = parent.path  + fileName + "/"; 
		parentDir.content[parentDir.contentIndex] = this;
		parentDir.contentIndex++;
		contentIndex = 0;
	}

	//////////////////////METHODS/////////////////////////////////

	/**
	 * Change the path of all FileDir starting from this FileDir
	 */

	public void changePath(){
		path = parent.path + name + "/";
		for (int i = 0; i < contentIndex; i++){
			content[i].changePath();
		}
	}

	/**
	 * Given a file name, search it in the the content of this FileDir
	 * return the FileDir with the given name or null if not found
	 * @param name - file name
	 * @return FileDir - the FileDir with the given name or null
	 */

	public FileDir searchByName(String name){
		for (FileDir file: this.content){
			if (file != null && file.name.equals(name)){
				return file;
			}
		}
		return null;
	}

	/**
	 * Return a string array, given a path string
	 * @param s - path string
	 * @return String[] - string array indicates the path
	 */

	public String[] pathToArray(String s){
		return s.split("/");
	}

	/**
	 * Convert the content of the file to string
	 * @return String - the string indicates the contents of this FileDir
	 */

	public String contentToString(){
		String contentList = "";
		for (int i = 0; i<contentIndex; i++){
			contentList = contentList + content[i].name +" ";
		}
		return contentList;
	}


	/**
	 * Given a file name, search it start from the given FileDir,
	 * return the FileDir with the given name or null if not found
	 * @param filename - name of the file need to be search
	 * @param currDir - where to start searching
	 * @return FileDir - the FileDir with given name
	 */

	public FileDir searchAll(String filename, FileDir currDir){
		FileDir temp=null;
		if (filename.equals(currDir.name))
			// if the file and directory have the same name, then
			// 	return the directory
			temp = currDir; 

		else
			for(int i = 0; i < currDir.contentIndex && temp==null; i++){ 
				temp = searchAll(filename, currDir.content[i]);
			} 
		return temp;
	}

	/**
	 * Remove this FileDir(directory or file)
	 * @param withConfirmation
	 * 		   a boolean indicate whether the user want confirmation before
	 * 		   removing a file or folder
	 */

	public void remove(boolean withConfirmation){
		String input = "";
		// keep prompting the user to enter "y" or "n" if the user entered
		// string other than that
		if (!withConfirmation)
			input = "y";
		while (!input.equals("y") && !input.equals("n")){
			System.out.println("Certain you would like to to remove " 
					+ name+" ? (y/n)");
			Scanner in = new Scanner(System.in);
			input = in.nextLine();
		}
		if (input.equals("n"))
			return;
		FileDir[] newContent = new FileDir[CONTENT_SIZE];
		int i = 0;
		for(int j = 0; j < parent.contentIndex; j++){
			if (parent.content[j] != this){
				newContent[i] = parent.content[j];
				i++;
			}
		}
		parent.content = newContent;
		parent.contentIndex--;
		System.out.println("--> removed: " + name);
	}
}


