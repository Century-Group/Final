package edu.century.finalProject;

import java.io.IOException;
import java.util.Scanner;

public class Helpers {
	
	//Start with three Code Collections
	CodeCollection collectionJava = new CodeCollection();
	CodeCollection collectionPython = new CodeCollection();
	CodeCollection collectionPowerShell = new CodeCollection();

	public Helpers() {
	}
	
	public void fileInterface() throws IOException {
		int choice = 0;
		
		while (choice <= 4 && choice >= 0 ) {
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter 1 to: Upload new file");
			System.out.println("Enter 2 to: Remove a file");
			System.out.println("Enter 3 to: Export a file");
			System.out.println("Enter 4 to: Open a file");
			System.out.println("Enter 5 to: Exit the program ");
			try {
				choice = input.nextInt();
			}
			catch(Exception e) {
				choice = 0;
			}
			
			switch(choice) {
			case 1:
				while (choice <=3 && choice > 0) {
					System.out.println();
					System.out.println("Enter 1 to: Upload to Java Collection");
					System.out.println("Enter 2 to: Upload to Python Collection");
					System.out.println("Enter 3 to: Upload to PowerShell Collection");
					System.out.println("Enter 4 to: Return from Main Menu");
					choice = input.nextInt();
								
					switch(choice) {
					case 1:  //use this as template for case 2/3
						/*
						System.out.println("Enter the location (e.g. /bin/example)");
						String advance11 = input.nextLine();
						String fileLocation11 = input.nextLine();
						System.out.println("Enter file name with file extention (e.g. foo.java)");
						String fileName11 = input.nextLine();
						String fileNameLocation11 = fileLocation11 + fileName11;
						String[] split = fileName11.split(".");
						String file = split[0];
						String codeFileName = "codeJava" + file;
						*/
						//CodeFile codeFileName = new CodeFile();  HOW??
						CodeFile codeJavaFoo = new CodeFile();
						codeJavaFoo.openFile("/bin/foo.java");
						collectionJava.addFile(codeJavaFoo);
						codeJavaFoo.closeFile();
						break;
					case 2: 
						System.out.println("Enter the location and file name of the file");
						String advance12 = input.nextLine();
						String fileName12 = input.nextLine();
						String fullName12 = "codePython" + fileName12;
						//collectionPython.removeFile(fullName22);
						break;
					case 3: 
						System.out.println("Enter the location and file name of the file");
						String advance13 = input.nextLine();
						String fileName13 = input.nextLine();
						String fullName13 = "codePowerShell" + fileName13;
						//collectionPowerShell.removeFile(fullName23);
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (1-4) please");
						System.out.println();
						choice = 2;
						break;
					}
				}
				break;
			case 2: 
				while (choice <=3 && choice > 0) {
					System.out.println();
					System.out.println("Enter 1 to: Remove from Java Collection");
					System.out.println("Enter 2 to: Remove from Python Collection");
					System.out.println("Enter 3 to: Remove from PowerShell Collection");
					System.out.println("Enter 4 to: Return from Main Menu");
					choice = input.nextInt();
								
					switch(choice) {
					case 1:
						System.out.println("Enter the file name");
						String advance21 = input.nextLine();
						String fileName21 = input.nextLine();
						String fullName21 = "codeJava" + fileName21;
						collectionJava.removeFile(fullName21);
						break;
					case 2: 
						System.out.println("Enter the file name");
						String advance22 = input.nextLine();
						String fileName22 = input.nextLine();
						String fullName22 = "codePython" + fileName22;
						collectionPython.removeFile(fullName22);
						break;
					case 3: 
						System.out.println("Enter the file name");
						String advance23 = input.nextLine();
						String fileName23 = input.nextLine();
						String fullName23 = "codePowerShell" + fileName23;
						collectionPowerShell.removeFile(fullName23);
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (1-4) please");
						System.out.println();
						choice = 2;
						break;
					}
				}
				break;
			case 3:
				while (choice <=3 && choice > 0) {
					System.out.println();
					System.out.println("Enter 1 to: Export from Java Collection");
					System.out.println("Enter 2 to: Export from Python Collection");
					System.out.println("Enter 3 to: Export from PowerShell Collection");
					System.out.println("Enter 4 to: Export from Main Menu");
					choice = input.nextInt();
								
					switch(choice) {
					case 1:
						System.out.println("Enter the file name");
						String advance31 = input.nextLine();
						String fileName31 = input.nextLine();
						String fullName31 = "codeJava" + fileName31;
						//codeJavaFoo.exportFile(fullName31);
						break;
					case 2: 
						System.out.println("Enter the file name");
						String advance32 = input.nextLine();
						String fileName32 = input.nextLine();
						String fullName32 = "codePython" + fileName32;
						collectionPython.removeFile(fullName32);
						break;
					case 3: 
						System.out.println("Enter the file name");
						String advance33 = input.nextLine();
						String fileName33 = input.nextLine();
						String fullName33 = "codePowerShell" + fileName33;
						collectionPowerShell.removeFile(fullName33);
						break;
					case 4:
						break;
					default:
						System.out.println("Enter a valid option (1-4) please");
						System.out.println();
						choice = 2;
						break;
					}
				}
				break;
			case 4: 
				System.out.println("Enter the location and file name of the file");
				String advance4 = input.nextLine();
				String fileNameLocation4 = input.nextLine();
				CodeFile.fileNotepad(fileNameLocation4);
				break;
			case 5: 
				break;
			default:
				System.out.println("Enter a valid integer (1-5) please");
				choice = 0;
				break;
			}
		}
		System.out.println("Goodbye!");
	}
}
