package edu.century.finalProject;

import java.util.Scanner;

public class CommentInterface {

	CommentSection comments = new CommentSection();
	LanguageScanner parent = new LanguageScanner();
	CommentSection chat = new CommentSection();

	public CommentInterface() {

	}

	public CommentSection commentMenu(CommentSection cs) {
		int choice = 0;

		this.comments = cs;
		
		if (cs == null) {
			comments = new CommentSection();
		}
		

		while (choice <= 5 && choice >= 0 ) {
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter 1 to: Add a comment");
			System.out.println("Enter 2 to: Remove a comment");
			System.out.println("Enter 3 to: Modify A comment");
			System.out.println("Enter 4 to: View all comments");
			System.out.println("Enter 5 to: Search for an specific users comments");
			System.out.println("Enter 6 to: Return from Main Menu");
			try {
				choice = input.nextInt();
			}
			catch(Exception e) {
				choice = 0;
			}

			switch(choice) {
			//case for adding a comment
			case 1:
				System.out.println("Enter your username");
				String name1 = input.nextLine();
				name1 = input.nextLine();
				System.out.println("Enter your message");
				String text1 = input.nextLine();
				//input.nextLine();
				comments.addComment(name1, text1);
				break;

				//case for deleting a comment
			case 2:
				System.out.println("Enter the comment ID number of the comment you would like to remove");
				int ID1 = input.nextInt();
				input.nextLine();
				comments.delete(ID1);
				break;

				//case for modifying a comment
			case 3:
				System.out.println("Enter the comment ID number of the comment you would like to change \n" 
						+ "as well as the new text you would like to replace the old message with.");
				System.out.println("Please press the \"Enter\" key after entering you desired ID number and \n" 
						+ "before entering your new text body.");
				int ID2 = input.nextInt();
				input.nextLine();
				String text2 = input.nextLine();
				comments.modifyText(ID2, text2);
				break;

				//case for viewing all comments
			case 4:
				System.out.println(comments.toString());
				break;

				//case for searching for a specific user and their comments
			case 5:
				System.out.println("Enter the username of the person you would like to search for.");
				String name2 = input.nextLine();
				name2 = input.nextLine();
				comments.search(name2);
				break;

				//case for exiting the menu
			case 6:
				break;
		
				//default case
			default:
				System.out.println("Enter a valid option (1-6) please");
				System.out.println();
				choice = 2;
				break;
			}
		}
		return comments;
	}

}
