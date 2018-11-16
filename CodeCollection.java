package edu.century.finalProject;

public class CodeCollection {

	private static CodeFile files[];
	private static String fileName;

	public CodeCollection() {
		
	}
	
	//work on
	public static void addFile() {
		
	}
	
	//work on
	public static void removeFile() {
		
	}
	
	//work on
	public static String serachFiles(String keyword) {
		return keyword;
	}

	/**
	 * Description: Getter for the files
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the files
	 * Throws: n/a
	 **/
	public static CodeFile[] getFiles() {
		return files;
	}

	public static void setFiles(CodeFile[] files) {
		CodeCollection.files = files;
	}

	/**
	 * Description: Getter for the fileName
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the fileName
	 * Throws: n/a
	 **/
	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		CodeCollection.fileName = fileName;
	}

	@Override
	public String toString() {
		return "CodeCollection [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}


/**
 * Description: 
 * Parameters: 
 * Precondition: 
 * Postcondition: 
 * Throws: 
 **/