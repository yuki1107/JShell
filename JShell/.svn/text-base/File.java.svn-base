import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Huda Mohamad Salleh
 * @author Yue Jun Ding
 * @author Fanling Luo
 * @author Ying Qi He
 */


public class File extends FileDir{
	///////////////////CONSTRUCTOR///////////////////////////
	protected String contentstr;    // string content inside a file

	/** Construct a new File
	 *   @param filename - file name for the File
	 *   @param parent - where the file need to be created
	 *   @param str - the content string for the File
	 */

	public File(String filename, FileDir parent, String str){
		super(filename, parent);
		contentstr = str;
	}

	/**
	 * Construct a new File
	 * @param filename - file name for the File
	 */
	public File(String filename){
		super(filename);
	}

	//////////////////////////////METHOD////////////////////   

	/**
	 * Return a string that indicates the contents of FILE.
	 * @return String
	 */

	public String cat(){
		return this.contentstr;
	}

	/**
	 * Replace the content of the file with given string
	 * @param str
	 */

	public void replace(String str){
		contentstr = str;
	}

	/**
	 * Append the string to the content of the file
	 * @param str
	 */

	public void append(String str){
		contentstr = contentstr + str;
	}    


	/**
	 * Return the path of the file(String)
	 * @return String
	 */

	public String ls(){
		return path;
	}

	/**
	 * Return a copy of this File and link it to the given parent FileDir
	 * @param parent - where the copy need to be linked
	 * @return File - a copy of this File
	 */

	public File copy(FileDir parent){
		File newCopy = new File(name);
		newCopy.parent = parent;
		newCopy.contentstr = contentstr;
		newCopy.contentIndex = contentIndex;
		return newCopy;
	}

	/**
	 * Search file containing regular expression pattern
	 * @param regex
	 * @return String
	 */

	public String find(String regex){
		String str = "";
		Pattern regexP = Pattern.compile(regex);
		String[] a = contentstr.split("[\n]| "); // a space or a line

		for (int i = 0; i < a.length; i++){ 
			// look through each word in the content
			Matcher m2 = regexP.matcher(a[i]);

			if (m2.matches()){ // if matches
				String[] s = path.split("/");
				for (int j = 0; j < s.length-1; j++){
					str = str + s[j] + "/"; //get the path of the file
				}

				str = str + ", " + s[s.length-1] + "\n";

			}
		}
		return str;
	}

	/**
	 * Print the filename and regular expression pattern
	 * @param regex
	 * @param recurs
	 * @return String
	 */
	public String grep(String regex, String recurs){

		String str = "";
		Pattern regexP = Pattern.compile(regex);
		String[] arg = contentstr.split("\n");
		int lineNum = -1;
		for (int i = 0; i < arg.length; i++){ //look at each line
			String[] words = arg[i].split(" ");

			// look at each word
			for (int j = 0; j < words.length; j++){
				// if the word matches the pattern
				Matcher m2 = regexP.matcher(words[j]);

				if (m2.matches()){ // if matches

					lineNum = i + 1;
					str = (str + path + " " + arg[i] + 
							" | line " + lineNum + "\n");
					break;
				}
			}
		}
		return str;
	}


}

