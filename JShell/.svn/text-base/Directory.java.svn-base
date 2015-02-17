
/**
 * @author Huda Mohamad Salleh
 * @author Yue Jun Ding
 * @author Fanling Luo
 * @author Ying Qi He
 */

public class Directory extends FileDir{

	//////////////////CONSTRUCTOR//////////////////////////////


	/**
	 * Construct a new Directory
	 * @param directoryName
	 */

	public Directory(String directoryName){
		super(directoryName);          
	}

	/**
	 * Construct a new Directory
	 * @param directoryName
	 * @param parent
	 */
	public Directory(String directoryName, FileDir parent){
		super(directoryName, parent);
	}

	//////////////////METHOD//////////////////////////////////

	/**
	 * Make a new directory inside this Directory
	 * @param newDirName
	 */

	public void mkdir(String newDirName){

		// the current directory will be the parent for the new one
		this.content[contentIndex] = new Directory(newDirName, this);
	}

	/**
	 *  List the content in this directory
	 *  @return String - file names that this Directory contains
	 */

	public String ls(){
		Directory tempDir;
		File tempFile;
		String s = "";
		for (int i = 0; i < contentIndex; i++){

			try {
				tempDir = (Directory) content[i];
				s = s + tempDir.name + "\n";
			}
			catch (ClassCastException e){
				tempFile = (File) content[i];
				s = s + tempFile.name + "\n";
			}
		}    
		return s.trim();
	}

	/**
	 *  List the content in the given directory
	 *  @param dir - Directory that need to be listed
	 */

	public String ls(Directory dir){
		return dir.ls();
	}

	/**
	 * Return the parent directory for current directory.
	 * If it does not have any parent directory, return the home directory.
	 * @param home
	 * @return Directory
	 */

	public Directory getParent(Directory home){
		try { 
			Directory parentDir = (Directory) this.parent; 
			return parentDir;
		}
		catch (NullPointerException e) {
			return home;
		}
	}

	/**
	 * Move item OLDPATH to NEWPATH if NEWPATH is a directory. Remove
	 * the OLDPATH. 
	 * @param oldPath - FileDir that need to be moved
	 * @param newPath - FileDir where the oldPath need to be moved to
	 */

	public void mv(FileDir oldPath, FileDir newPath){
		if (newPath instanceof File){
			System.out.println("Cannot move item into a File.");
			return;
		}
		// add oldPath to newPath\
		newPath.content[newPath.contentIndex] = oldPath;
		newPath.contentIndex++;

		// then remove the oldPath from parent content
		FileDir [] newContent = new FileDir [1000];
		int i = 0;
		for(int j = 0; j < oldPath.parent.contentIndex; j++){
			if (oldPath.parent.content[j] != oldPath){
				newContent[i] = oldPath.parent.content[j];
				i++;
			}
		}
		oldPath.parent.content = newContent;
		oldPath.parent.contentIndex--;
		oldPath.parent = newPath;
		oldPath.changePath();
	}

	/**
	 * Return a new copy of this Directory(recursively copy the content in 
	 * it as well) and links it to the given parent FileDir
	 * @param parent - where the new copy need to be place, FileDir
	 * @return Directory - new copy of this Directory
	 */

	public Directory copy(FileDir parent){
		Directory newCopy = new Directory(name);
		for(int i = 0; i < contentIndex; i++){
			if (content[i] instanceof Directory)
				newCopy.content[i] = ((Directory)content[i]).copy(newCopy);
			else if (content[i] instanceof File)
				newCopy.content[i] = ((File)content[i]).copy(newCopy);
			newCopy.content[i].parent = newCopy;
			newCopy.contentIndex++;
		}
		return newCopy;
	}

	/**
	 * Add a copy of OLDPATH to NEWPATH if NEWPATH is a directory. 
	 * @param oldPath
	 * @param newPath 
	 * @return FileDir[]
	 */
	public void cp(FileDir oldPath, FileDir newPath){
		if (oldPath instanceof Directory)
			newPath.content[newPath.contentIndex] = 
				((Directory)oldPath).copy(newPath);
		else if (oldPath instanceof File)
			newPath.content[newPath.contentIndex] = 
				((File)oldPath).copy(newPath);
		newPath.content[newPath.contentIndex].parent = newPath;
		newPath.content[newPath.contentIndex].changePath();
		newPath.contentIndex++;
	}

	/**
	 * Search file containing regular expression pattern inside
	 * 	directory
	 * @param regex
	 */

	public String find(String regex){
		String str = "";
		if (contentIndex!=0){
			for (int i = 0; i < contentIndex; i++){
				if (content[i] instanceof Directory){
					str = str + ((Directory)content[i]).find(regex);
				}
				else if (content[i] instanceof File){
					str = str + ((File)content[i]).find(regex);
				}
			}
		}
		return str;
	}

	/**
	 * Print the filename and regular expression pattern
	 * @param regex
	 * @param recurs
	 */

	public String grep(String regex, String recurs){
		String str = "";
		if (contentIndex!=0){
			for (int i = 0; i < contentIndex; i++){
				if ((content[i] instanceof Directory) && 
						recurs.equals("recursive") ){
					str = str + ((Directory)content[i]).grep(regex, recurs);
				}
				else if (content[i] instanceof File){
					str = str + ((File)content[i]).grep(regex, recurs);
				}
			}
		}
		return str;
	}


}


