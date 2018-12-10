package edu.century.finalProject;

import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class CodeFile {

	private static Scanner x;
	private String wholeFile = "";
	private String fileName;

	public CodeFile() {
	}
	
	public static void fileNotepad(String fileLocationName) throws IOException{
		if (Desktop.isDesktopSupported()) {
		    File file = new File(fileLocationName);
			Desktop.getDesktop().edit(file);
		} else {
		    System.out.println("FAILURE: Please enter valid file path and name");
		}
	}
	
	public static void exportFile(String fileText, String locationName) throws IOException{
		String fileLocationName = locationName;
		FileWriter fwriter = new FileWriter(fileLocationName, true);
		PrintWriter outputfile = new PrintWriter(fwriter);
		outputfile.print(fileText);
		outputfile.close();
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
	 * Description: Open the file
	 * Parameters: String filename
	 * Precondition: file exists
	 * Postcondition: open file
	 * Throws: FileNotFoundException
	 **/
	public String openFile(String fileName) {
		Scanner scanner = null;
		String fileText = "";
		try {
			scanner = new Scanner(new File(fileName));
			fileText = setWholeFile(scanner);
		} catch (Exception FileNotFoundException) {
			System.out.println("FAILURE: File does not exist " + fileName);
		}
		wholeFile = fileText; 
		return fileText;
	}

	/**
	 * Description: Display the file 
	 * Parameters: none
	 * Precondition: file is available 
	 * Postcondition: return file line by line
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
	 * Description: Check if file is empty	
	 * Parameters: String fileName
	 * Precondition: n/a
	 * Postcondition: return if empty
	 * Throws: n/a
	 **/
	//Borrowed from: https://stackoverflow.com/questions/31800816/how-to-check-if-file-content-is-empty
	public static void checkEmpty(String fileName) {
		File file = new File(fileName);
		if (file.isFile()) {
			long size = file.length();
			if (size != 0) {
			}
			else {
				System.out.println("FAILURE: This file is empty " + fileName);
			}
		}
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

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}


/**
 * Description: 
 * Parameters: 
 * Precondition: 
 * Postcondition: 
 * Throws: 
 **/