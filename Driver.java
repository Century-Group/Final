package edu.century.finalProject;

//import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException {

		//Scanner input = new Scanner(System.in);
       // System.out.print("Enter file name and path");
       // String fileName = input.nextLine();
		String fileName = "/bin/foo.java";
		//CodeFile.openFile(fileName);
		//CodeFile.checkEmpty(fileName);
		//CodeFile.displayFile();
		
		CodeCollection collectionJava = new CodeCollection(fileName); 
		CodeFile codeJava = new CodeFile();
		codeJava.openFile(fileName);
		codeJava.setFileText(codeJava.displayFile());
		collectionJava.addFile(codeJava);

		String fileName2 = "/bin/foo2.java";
		CodeFile codeJava2 = new CodeFile();
		codeJava2.openFile(fileName2);
		codeJava2.setFileText(codeJava2.displayFile());
		collectionJava.addFile(codeJava2);
		
		
		//check to see if equal based on text of file. 
		if (codeJava.displayFile() == codeJava2.displayFile()) {
			System.out.println("Equal ");
		} else {
			System.out.println("Not Equal");
		}
		
		System.out.println(codeJava.displayFile());
		
		//open file in notepad
		/*
		if (Desktop.isDesktopSupported()) {
		    File file = new File(fileName);
			Desktop.getDesktop().edit(file);
		} else {
		    System.out.println("Please enter valid file path and name");
		}
		*/
	}

}
