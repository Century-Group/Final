package edu.century.finalProject;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class CodeFile {

	private static Scanner x;
	private static String wholeFile = "";
	
	private static String timeStamp;
	private static String tag;
	private static String fileText;

	public CodeFile() {
		
	}
	
	/**
	 * Description: Getter for wholeFile field variable
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the wholeFile
	 * Throws: n/a
	 **/
	public static String getWholeFile() {
		return wholeFile;
	}

	/**
	 * Description: Open the file
	 * Parameters: String filename
	 * Precondition: file exists
	 * Postcondition: open file
	 * Throws: FileNotFoundException
	 **/
	public static void openFile(String fileName) {
		try {
			x = new Scanner(new File(fileName));
		} catch (Exception FileNotFoundException) {
			System.out.println("File does not exist " + fileName);
		}
	}

	/**
	 * Description: Display the file 
	 * Parameters: none
	 * Precondition: file is available 
	 * Postcondition: return file line by line
	 * Throws: IOException
	 **/
	public static void displayFile() throws IOException{
		while (x.hasNext()) {
			String line = x.nextLine();
			System.out.println(line);
			wholeFile += line + "\n";
		}
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
				System.out.println("This file is empty " + fileName);
			}
		}

	}

	/**
	 * Description: Getter for the timeStamp 
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the timeStamp
	 * Throws: n/a
	 **/
	public static String getTimeStamp() {
		return timeStamp;
	}

	public static void setTimeStamp(String timeStamp) {
		CodeFile.timeStamp = timeStamp;
	}

	/**
	 * Description: Getter for the tag
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the tag
	 * Throws: n/a
	 **/
	public static String getTag() {
		return tag;
	}

	public static void setTag(String tag) {
		CodeFile.tag = tag;
	}

	/**
	 * Description: Getter for the fileText
	 * Parameters: none
	 * Precondition: n/a
	 * Postcondition: return the fileText
	 * Throws: n/a
	 **/
	public static String getFileText() {
		return fileText;
	}

	public static void setFileText(String fileText) {
		CodeFile.fileText = fileText;
	}

	@Override
	public String toString() {
		return "CodeFile [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}


/**
 * Description: 
 * Parameters: 
 * Precondition: 
 * Postcondition: 
 * Throws: 
 **/