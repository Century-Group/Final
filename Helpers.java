package edu.century.finalProject;
//Gabriel Blott

import java.io.IOException;
import java.util.Scanner;

public class Helpers {
	
	//Instance Variables
	CodeCollection collectionJava = new CodeCollection();
	CodeCollection collectionPython = new CodeCollection();
	CodeCollection collectionPowerShell = new CodeCollection();
	CommentInterface comment = new CommentInterface();

	//Constructor 
	public Helpers() {
	}
	
	/**
	 * Description: Interface for file manipulation
	 * Parameters: none	
	 * Precondition: Enter a valid integer 1-7
	 * Postcondition: Various depending on options selected	
	 * Throws: n/a (various checks prevent errors from thrown)
	 **/
	public void fileInterface() throws IOException {
		int choice = 0;
		
		while (choice <= 6 && choice >= 0 ) {
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter 1 to: Upload new file");
			System.out.println("Enter 2 to: Remove a file");
			System.out.println("Enter 3 to: Export a file");
			System.out.println("Enter 4 to: Display file's code");
			System.out.println("Enter 5 to: List all files and comments");
			System.out.println("Enter 6 to: Go to Comments");
			System.out.println("Enter 7 to: Exit the program ");
			try {
				choice = input.nextInt();
			}
			catch(Exception e) {
				choice = 0;
			}
			switch(choice) {
			case 1:
				while (choice <=3 && choice > 0) {
					input = new Scanner(System.in);
					System.out.println();
					System.out.println("Enter 1 to: Upload to Java Collection");
					System.out.println("Enter 2 to: Upload to Python Collection");
					System.out.println("Enter 3 to: Upload to PowerShell Collection");
					System.out.println("Enter 4 to: Return to Main Menu");
					try {
						choice = input.nextInt();
					}
					catch(Exception e) {
						choice = 0;
					}
								
					switch(choice) {
					case 1:  
						System.out.println("Enter the location (e.g. /bin/)");
						String advance11 = input.nextLine();
						String fileLocation11 = input.nextLine();
						System.out.println("Enter file name with file extention (e.g. foo.java)");
						String fileName11 = input.nextLine();
						String fileNameLocation11 = fileLocation11 + fileName11;
						CodeFile codeFileJava = new CodeFile(); 
						boolean exists = codeFileJava.openFile(fileLocation11, fileName11);
						if (exists) {
							collectionJava.addFile(codeFileJava);
							codeFileJava.closeFile();
						}
						break;
					case 2: 
						System.out.println("Enter the location (e.g. /bin/)");
						String advance12 = input.nextLine();
						String fileLocation12 = input.nextLine();
						System.out.println("Enter file name with file extention (e.g. foo.py)");
						String fileName12 = input.nextLine();
						String fileNameLocation12 = fileLocation12 + fileName12;
						CodeFile codeFilePython = new CodeFile();  
						boolean exists2 = codeFilePython.openFile(fileLocation12, fileName12);
						if (exists2) {
							collectionPython.addFile(codeFilePython);
							codeFilePython.closeFile();
						}
						break;
					case 3: 
						System.out.println("Enter the location (e.g. /bin/)");
						String advance13 = input.nextLine();
						String fileLocation13 = input.nextLine();
						System.out.println("Enter file name with file extention (e.g. foo.ps1)");
						String fileName13 = input.nextLine();
						String fileNameLocation13 = fileLocation13 + fileName13;
						CodeFile codeFilePowerShell = new CodeFile();  
						boolean exists3 = codeFilePowerShell.openFile(fileLocation13, fileName13);
						if (exists3) {
							collectionPowerShell.addFile(codeFilePowerShell);
							codeFilePowerShell.closeFile();
						}
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (e.g. 1-4)");
						System.out.println();
						choice = 2;
						break;
					}
				}
				break;
			case 2: 
				while (choice <=3 && choice > 0) {
					input = new Scanner(System.in);
					System.out.println();
					System.out.println("Enter 1 to: Remove from Java Collection");
					System.out.println("Enter 2 to: Remove from Python Collection");
					System.out.println("Enter 3 to: Remove from PowerShell Collection");
					System.out.println("Enter 4 to: Return to Main Menu");
					try {
						choice = input.nextInt();
					}
					catch(Exception e) {
						choice = 0;
					}								
					switch(choice) {
					case 1: 
						System.out.println("Enter the file name (e.g. foo.java)");
						String advance21 = input.nextLine();
						String fileName21 = input.nextLine();
						collectionJava.removeFile(fileName21);
						break;
					case 2: 
						System.out.println("Enter the file name (e.g. foo.py)");
						String advance22 = input.nextLine();
						String fileName22 = input.nextLine();
						collectionPython.removeFile(fileName22);
						break;
					case 3: 
						System.out.println("Enter the file name (e.g. foo.ps1)");
						String advance23 = input.nextLine();
						String fileName23 = input.nextLine();
						collectionPowerShell.removeFile(fileName23);
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (e.g. 1-4)");
						System.out.println();
						choice = 2;
						break;
					}
				}
				break;
			case 3:
				while (choice <=3 && choice > 0) {
					input = new Scanner(System.in);
					System.out.println();
					System.out.println("Enter 1 to: Export from Java Collection");
					System.out.println("Enter 2 to: Export from Python Collection");
					System.out.println("Enter 3 to: Export from PowerShell Collection");
					System.out.println("Enter 4 to: Return to Main Menu");
					try {
						choice = input.nextInt();
					}
					catch(Exception e) {
						choice = 0;
					}								
					switch(choice) {
					case 1:
						System.out.println("Enter the file name to export (e.g. foo.java)");
						String advance31 = input.nextLine();
						String fileName31 = input.nextLine();
						System.out.println("Enter location to store file (e.g. /bin/exports/");
						String fileLocation31 = input.nextLine();
						String fileLocationName31 =  fileLocation31  + fileName31;
						String fileContents31 = collectionJava.displayFile(fileName31);
						if (fileContents31 != null)
							CodeFile.exportFile(fileContents31, fileLocationName31);
						else
							System.out.println("FAILURE: File " + fileName31 + " does not exist.");
						break;
					case 2: 
						System.out.println("Enter the file name to export (e.g. foo.py)");
						String advance32 = input.nextLine();
						String fileName32 = input.nextLine();
						System.out.println("Enter location to store file (e.g. /bin/exports/");
						String fileLocation32 = input.nextLine();
						String fileLocationName32 =  fileLocation32  + fileName32;
						String fileContents32 = collectionPython.displayFile(fileName32);
						if (fileContents32 != null)
							CodeFile.exportFile(fileContents32, fileLocationName32);
						else
							System.out.println("FAILURE: File " + fileName32 + " does not exist.");
						break;
					case 3: 
						System.out.println("Enter the file name to export(e.g. foo.ps1)");
						String advance33 = input.nextLine();
						String fileName33 = input.nextLine();
						System.out.println("Enter location to store file (e.g. /bin/exports/");
						String fileLocation33 = input.nextLine();
						String fileLocationName33 =  fileLocation33  + fileName33;
						String fileContents33 = collectionPowerShell.displayFile(fileName33);
						if (fileContents33 != null)
							CodeFile.exportFile(fileContents33, fileLocationName33);
						else
							System.out.println("FAILURE: File " + fileName33 + " does not exist.");
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (e.g. 1-4)");
						System.out.println();
						choice = 2;
						break;
					}
				}
				break;
			case 4: 
				choice = 1;
				while (choice <=3 && choice > 0) {
					input = new Scanner(System.in);
					System.out.println();
					System.out.println("Enter 1 to: Display a file from Java Collection");
					System.out.println("Enter 2 to: Display a file from Python Collection");
					System.out.println("Enter 3 to: Display a file from PowerShell Collection");
					System.out.println("Enter 4 to: Return to Main Menu");
					try {
						choice = input.nextInt();
					}
					catch(Exception e) {
						choice = 0;
					}								
					switch(choice) {
					case 1: 
						System.out.println("Enter the file name");
						String advance51 = input.nextLine();
						String fileName51 = input.nextLine();
						if (collectionJava.displayFile(fileName51) != null)
							System.out.println(collectionJava.displayFile(fileName51));
						else
							System.out.println("FAILURE " + fileName51 + " does not exist");
						break;
					case 2: 
						System.out.println("Enter the file name");
						String advance52 = input.nextLine();
						String fileName52 = input.nextLine();
						if (collectionPython.displayFile(fileName52) != null)
							System.out.println(collectionPython.displayFile(fileName52));
						else
							System.out.println("FAILURE " + fileName52 + " does not exist");
						break;
					case 3: 
						System.out.println("Enter the file name");
						String advance53 = input.nextLine();
						String fileName53 = input.nextLine();
						if (collectionPowerShell.displayFile(fileName53) != null)
							System.out.println(collectionPowerShell.displayFile(fileName53));
						else
							System.out.println("FAILURE " + fileName53 + " does not exist");
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (e.g. 1-4)");
						System.out.println();
						choice = 1;
						break;
					}
				}
				break;
			case 5: 
				System.out.println("--Java Collection Files--");
				collectionJava.listCollection();
				System.out.println();
				System.out.println("--Python Collection Files--");
				collectionPython.listCollection();
				System.out.println();
				System.out.println("--PowerShell Collection Files--");
				collectionPowerShell.listCollection();
				break;
			case 6:
				choice = 1;
				while (choice <=3 && choice > 0) {
					input = new Scanner(System.in);
					System.out.println();
					System.out.println("Enter 1 to: Comment a file from Java Collection");
					System.out.println("Enter 2 to: Comment a file from Python Collection");
					System.out.println("Enter 3 to: Comment a file from PowerShell Collection");
					System.out.println("Enter 4 to: Return to Main Menu");
					try {
						choice = input.nextInt();
					}
					catch(Exception e) {
						choice = 0;
					}								
					switch(choice) {
					case 1: 
						System.out.println("Enter the file name");
						String advance61 = input.nextLine();
						String fileName61 = input.nextLine();
						
						CodeFile cf = collectionJava.getFile(fileName61);
						if (cf == null)
							System.out.println(fileName61 + " does not exist");
						else {
							CommentSection cs = comment.commentMenu(cf.getComments());
							cf.setComments(cs);
							collectionJava.removeFile(fileName61, false);
							collectionJava.addFile(cf, false);
						}
						break;
					case 2: 
						System.out.println("Enter the file name");
						String advance62 = input.nextLine();
						String fileName62 = input.nextLine();
						
						CodeFile cf2 = collectionPython.getFile(fileName62);
						if (cf2 == null)
							System.out.println(fileName62 + " does not exist");
						else {
							CommentSection cs = comment.commentMenu(cf2.getComments());
							cf2.setComments(cs);
							collectionPython.removeFile(fileName62, false);
							collectionPython.addFile(cf2, false);
						}
						break;
					case 3: 
						System.out.println("Enter the file name");
						String advance63 = input.nextLine();
						String fileName63 = input.nextLine();
						
						CodeFile cf3 = collectionPowerShell.getFile(fileName63);
						if (cf3 == null)
							System.out.println(fileName63 + " does not exist");
						else {
							CommentSection cs = comment.commentMenu(cf3.getComments());
							cf3.setComments(cs);
							collectionPowerShell.removeFile(fileName63, false);
							collectionPowerShell.addFile(cf3, false);
						}
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (e.g. 1-4)");
						System.out.println();
						choice = 1;
						break;
					}
				}
				break;
			case 7: 
				break;
			default:
				System.out.println("Enter a valid integer (e.g. 1-7)");
				choice = 0;
				break;
			}
		}
		System.out.println("Goodbye!");
	}
}
