package edu.century.finalProject;
//Gabriel Blott

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class CodeFile {

	//Instance Variables
	private static Scanner x;
	private String wholeFile = "";
	private String fileName;
	private CommentSection comments;


	//Constructor 
	public CodeFile() {
	}
	
	/**
	 * Description: Override toString 
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the fileName
	 * Throws: n/a
	 **/
	@Override
	public String toString() {
		return fileName;
	}
	
	/**
	 * Description: Export a file from the collection to local computer
	 * Parameters: String fileText, String locationName
	 * Precondition: n/a
	 * Postcondition: Export file
	 * Throws: IOException
	 **/
	public static void exportFile(String fileText, String locationName) throws IOException{
		FileWriter fwriter = new FileWriter(locationName, true);
		PrintWriter outputfile = new PrintWriter(fwriter);
		outputfile.print(fileText);
		outputfile.close();
		System.out.println("File successfully exported");
	}
	
	/**
	 * Description: Open the file
	 * Parameters: String location, String fileName
	 * Precondition: file exists
	 * Postcondition: open file
	 * Throws: FileNotFoundException
	 **/
	public boolean openFile(String location, String fileName) {
		String locationFileName = location + fileName;
		Scanner scanner = null;
		String fileText = "";
		boolean exists = false;
		try {
			scanner = new Scanner(new File(locationFileName));
			fileText = setWholeFile(scanner);
			exists = true;
		} catch (Exception FileNotFoundException) {
			System.out.println("FAILURE: File does not exist " + locationFileName);
		}
		wholeFile = fileText; 
		this.fileName = fileName;
		return exists;
	}
	
	/**
	 * Description: Close file
	 * Parameters: none
	 * Precondition: verify file exists
	 * Postcondition: close file
	 * Throws: NullPointerException
	 **/
	public static void closeFile() {
		try {
			x.close();
		} catch (Exception NullPointerException) {
		}	
	}

	/**
	 * Description: Setter for wholeFile field variable
	 * Parameters: Scanner scanner
	 * Precondition: none
	 * Postcondition: return entire file
	 * Throws: IOException
	 **/
	public String setWholeFile(Scanner scanner) throws IOException{
		String whole = "";
		wholeFile = "";
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			wholeFile += line + "\n";
			whole += line + "\n";
		}
		return whole;
	}
	
	/**
	 * Description: Getter for wholeFile field variable
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the wholeFile
	 * Throws: n/a
	 **/
	public String getWholeFile() {
		return wholeFile;
	}
	
	/**
	 * Description: Getter for the fileName
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the fileName
	 * Throws: n/a
	 **/
	public String getFileName() {
		return fileName;
	}

	/**
	 * Description: Setter for fileName
	 * Parameters: String fileName
	 * Precondition: n/a
	 * Postcondition: set fileName
	 * Throws: n/a
	 **/
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Description: Getter for comments field variable
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return comments
	 * Throws: n/a
	 **/
	public CommentSection getComments() {
		return comments;
	}

	/**
	 * Description: Setter for comments field variable
	 * Parameters: CommentSection comments
	 * Precondition: n/a
	 * Postcondition: set comments
	 * Throws: n/a
	 **/
	public void setComments(CommentSection comments) {
		this.comments = comments;
	}
	
}