package edu.century.finalProject;

import java.util.ArrayList;

public class CodeCollection {

	private ArrayList<CodeFile> files;
	
	public CodeCollection() {
		files = new ArrayList<CodeFile>();
	}
	
	public ArrayList<CodeFile> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<CodeFile> files) {
		this.files = files;
	}

	public void addFile(CodeFile codeFile) {
		boolean fileCheck = hasFile(codeFile);
		if (fileCheck == true) {
			System.out.println("FAILURE: File already exists");
		} else {
			files.add(codeFile);
			System.out.println("SUCCESS: File added");
		}
	}
	
	//remove if not used
	public void removeFile(CodeFile codeFile) {
		//check if file exists, give message if doesn't, give message if successful 
		files.remove(codeFile);
	}
	
	public void removeFile(String fileName) {
		boolean exists = false;
		for (int i=0; i < files.size(); i++) {
			if (files.get(i).getFileName().equals(fileName)) {  //problem
				files.remove(i);   
				System.out.println("SUCCESS: File: " + fileName + " has been removed.");
				exists = true;
			} 
		} 
		if (!exists)
			System.out.println("FAILURE: File: " + fileName + " does not exist");
	}
		
	public boolean hasFile(CodeFile file) {
		boolean exists = false;
		for (int i=0; i < files.size(); i++) {
			if (files.get(i).getWholeFile().equals(file.getWholeFile())) {
				exists = true;
			}
		}
		return exists;
	}

	/*
	public static boolean checkEquals(String codeFile1, String codeFile2) {
		boolean check = codeFile1.equals(codeFile2);
		if (check) {
			return true;
		} else {
			return false;
		}
	}
	*/
	
}


/**
 * Description: 
 * Parameters: 
 * Precondition: 
 * Postcondition: 
 * Throws: 
 **/