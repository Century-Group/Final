package edu.century.finalProject;

import java.util.ArrayList;

public class CodeCollection {

	private static ArrayList<CodeFile> files;
	private static String fileName;

	public CodeCollection(String name) {
		files = new ArrayList<CodeFile>();
		fileName = name;
	}
	
	
	public static ArrayList<CodeFile> getFiles() {
		return files;
	}


	public static void setFiles(ArrayList<CodeFile> files) {
		CodeCollection.files = files;
	}


	public static void addFile(CodeFile codeFile) {
		//use equals method to see if equal to existing files in arrayList
		files.add(codeFile);
	}
	
	public static void removeFile(CodeFile codeFile) {
		//check if exists
		files.remove(codeFile);
	}
	
	//work on
	public static String serachFiles(String keyword) {
		return keyword;
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