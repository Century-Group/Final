package century.edu.class_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CommentSection {

	private List<Comment> chat;	//Holds all Comment objects
	private List<String> userNames;	//Holds the userNames for reference when adding replies

	/*
	 * Generate a new CommentSection that will store all of the related comments within it.
	 * Simply creates two ArrayLists for adding Comments to.
	 */
	public CommentSection() {
		chat =  new ArrayList<>();
		userNames = new ArrayList<>();
	}

	/*
	 * Create a new Comment and add it to the CommentSection.
	 * Precondition: Takes a userName and the comment text as arguments
	 * PostCondition: 
	 * Throws: 
	 */
	public void addComment(String name, String text) {
		int targetIndex;
		String searchName = "";
		//If new comment, add normally
		if (checkIfReply(text) == false) {
			chat.add(new Comment(name, text));
			userNames.add(name);
		}
		//If reply, add reply Comment behind the last occurrence of the given userName.
		else {
			String[] splitText = text.split(" ");
			String[] checkForReply = splitText[0].split("");
			for( int i = 1; i < checkForReply.length; i++)
				searchName = searchName + checkForReply[i];
			targetIndex = userNames.lastIndexOf(searchName);
			chat.add(targetIndex + 1, new Comment(name, text));
			userNames.add(targetIndex + 1, name);
		}
	}

	/*
	 * Verifies whether or not the Comment will be a reply or a new Comment.
	 * Precondition: Takes the Comments message body as input.
	 * PostCondition: 
	 * Throws: 
	 */
	public boolean checkIfReply(String text) {
		//parse text for @userName: discern whether reply or new comment
		String[] splitText = text.split(" ");
		String[] checkForReply = splitText[0].split("");
		if (checkForReply[0].equals("@")) {
			return true;
		}
		else
			return false;
	}

	/*
	 * Deletes an existing comment based on the comment ID.
	 * Precondition: Takes an int as an argument that signifies the unique comment ID of the target you want to remove.
	 * PostCondition: Removes the selected target and removes excess null space in the ArrayList.
	 * Throws: 
	 */
	public void delete(int ID) {
		for (int i = 0; i < chat.size(); i++) {
			if (ID == chat.get(i).getID()) {
				chat.remove(i);
				userNames.remove(i);
			}
			/*remove null spaces in the List after remove takes place. ArrayList may have this by default
			chat.removeIf(Objects::isNull);
			userNames.removeIf(Objects::isNull);
			*/
		}
	}

	/*
	 * Allows the user to charge the existing text body of a comment.
	 * Precondition: Takes a int for the target comment identification and 
	 * takes a String for the new text to be used.
	 * PostCondition: Prints out all of the posts made by that specific user.
	 * Throws: 
	 */
	public void changeText(int ID, String text) {
		//check User access level: Admin or standard User: waiting on User class at the moment
		for (int i = 0; i < chat.size(); i++) {
			if (ID == chat.get(i).getID()) {
				chat.get(i).modifyText(text);
			}
		}
	}
	/*
	 * Allows the user to search for a comment my userName.
	 * Precondition: Takes a String for the userName of the search target.
	 * PostCondition: Prints out all of the posts made by that specific user.
	 * Throws: 
	 */
	public void search(String userName) {
		int test = 0;
		//search for posts by userName
		for (Comment comment: chat) {
			if (comment.getUserName().equals(userName)) {
				//display all posts made by the user
				System.out.println(comment.toString());
				System.out.println("\n");
				System.out.println("---------------------------------------" 
						+ "---------------------------------------");
				System.out.println("\n");
				test += 1;
			}

		}
		if (test == 0) {
			System.out.println("Username \"" + userName + "\" doesn't exist.");
		}
	}



	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		String output = "";//strBuilder.toString();
		for (Comment comment: chat) {
			strBuilder.append(comment.toString());
			strBuilder.append("\n");
			strBuilder.append("---------------------------------------------" 
			+ "---------------------------------");
			strBuilder.append("\n");
		}
		output = strBuilder.toString();
		return output;
	}


}
