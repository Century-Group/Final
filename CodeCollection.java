package edu.century.finalProject;
//Gabriel Blott

import java.util.ArrayList;

public class CodeCollection {

	//Instance Variables
	private ArrayList<CodeFile> files;
	
	//Constructor 
	public CodeCollection() {
		files = new ArrayList<CodeFile>();
	}
	
	/**
	 * Description: Print out a list of all files inside a code collection	
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: Print out list of all files
	 * Throws: n/a
	 **/
	public void listCollection() {
		for (int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i));
		}
	}
	
	/**
	 * Description: Display contents of a file.
	 * Parameters: String fileName
	 * Precondition: n/a
	 * Postcondition: return a string of the file contents or null of nothing.
	 * Throws: 
	 **/
	public String displayFile(String fileName) {
		String fileContents = null;
		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).getFileName().equals(fileName)) {
				fileContents = files.get(i).getWholeFile();
			}
		}
		return fileContents;
	}
	
	/**
	 * Description: Getter for ArrayList<CodeFile> field variable
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return files
	 * Throws: n/a
	 **/
	public ArrayList<CodeFile> getFiles() {
		return files;
	}

	/**
	 * Description: Setter for ArrayList<CodeFile> field variable
	 * Parameters: ArrayList<CodeFile> files
	 * Precondition: n/a
	 * Postcondition: set the files
	 * Throws: n/a
	 **/
	public void setFiles(ArrayList<CodeFile> files) {
		this.files = files;
	}

	/**
	 * Description: Add a file to the CodeFile object
	 * Parameters: CodeFile codeFile
	 * Precondition: verify file doesn't exist already (hasFile())
	 * Postcondition: Add the file and give message
	 * Throws: n/a
	 **/
	public void addFile(CodeFile codeFile) {
		boolean fileCheck = hasFile(codeFile);
		if (fileCheck == true) {
			System.out.println("FAILURE: File already exists");
		} else {
			files.add(codeFile);
			System.out.println("SUCCESS: File added");
		}
	}
	
	/**
	 * Description: Remove a file 
	 * Parameters: String fileName
	 * Precondition: Verify file exists
	 * Postcondition: Remove file, or give message it didn't exist
	 * Throws: n/a
	 **/
	public void removeFile(String fileName) {
		boolean exists = false;
		for (int i=0; i < files.size(); i++) {
			if (files.get(i).getFileName().equals(fileName)) {  
				files.remove(i);   
				System.out.println("SUCCESS: File: " + fileName + " has been removed.");
				exists = true;
			} 
		} 
		if (!exists)
			System.out.println("FAILURE: File: " + fileName + " does not exist");
	}
	
	/**
	 * Description: Compare the new file to all existing files in the collection
	 * Parameters: CodeFile file
	 * Precondition: If file exists
	 * Postcondition: return if file exists or not.
	 * Throws: n/a
	 **/
	public boolean hasFile(CodeFile file) {
		boolean exists = false;
		for (int i=0; i < files.size(); i++) {
			if (files.get(i).getWholeFile().equals(file.getWholeFile())) {
				exists = true;
			}
		}
		return exists;
	}
}