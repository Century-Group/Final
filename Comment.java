package century.edu.class_project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Comment {
	private String userName;
	private static int commentID = 5000;
	private String text;
	private String[] commentElements = new String[10];
	private LanguageScanner safeText = new LanguageScanner();
	private boolean isReply;
	int uniqueID;

	//Default Constructor
	public Comment() {

	}

	/*
	 * Constructor: has logic in place to identify replies from new comments and formats them accordingly.
	 * It will access the LanguageScanner as well to check for profanity.
	 * Precondition: Takes the users userName and the comment body as arguments.
	 * PostCondition: New Comment created.
	 * Throws: 
	 */
	public Comment(String name, String text) {
		//If reply: generate new reply
		//parse text for @userName: discern whether reply or new comment
		String[] splitText = text.split(" ");
		String[] checkForReply = splitText[0].split("");
		String replyText = "";
		if (checkForReply[0].equals("@")) {
			for (int i = 1; i < splitText.length; i++) {
				replyText = replyText + splitText[i] + " ";
			}
			if (safeText.scanMessage(text) == false) {
				System.out.println("\"" + text + "\"" + " contains inappropriate words and is not accepted.");
				//loop back into the case menu
			}else {
				setText(replyText);
				commentElements[0] = "Date: " + commentTimeStamp();
				commentElements[1] = "ID: #" + commentID;
				commentElements[3] = splitText[0];
				this.userName = name;
				commentElements[2] = "Name: " + userName;
				setText(replyText);
				commentElements[4] = getText();
				isReply = true;
				uniqueID = commentID;
				commentID += 10;
			}

		}
		//if not reply: generate new comment
		else {
			if (safeText.scanMessage(text) == false) {
				System.out.println("\"" + text + "\"" + " contains inappropriate words and is not accepted.");
			}else {
				setText(text);
				commentElements[0] = "Date: " + commentTimeStamp();
				commentElements[1] = "ID: #" + (commentID);
				this.userName = name;
				commentElements[2] = "Name: " + userName;
				commentElements[3] = getText();
				isReply = false;
				uniqueID = commentID;
				commentID += 10;
			}
		}
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public int getID() {
		return uniqueID;
	}

	public String getUserName() {
		return userName;
	}

	/*
	 * Modify the existing comment body text.
	 * Precondition: Takes the new text as an argument
	 * PostCondition: 
	 * Throws: 
	 */
	public void modifyText(String text) {
		//check User access level: Admin or standard User: waiting on User class at the moment
		if (safeText.scanMessage(text) == false) {
			System.out.println("\"" + text + "\"" + " contains inappropriate words and is not accepted.");
		}else {
			setText(text);
		}
	}

	/*
	 * Creates a Date object wit the current timestamp formatted like ("yyyy-MM-dd hh:mm:ss")
	 * Precondition: No real precondition, just check for proper imports before using
	 * PostCondition: Returns the formatted timestamp as a String
	 * Throws: 
	 */
	public String commentTimeStamp() {
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		String strDate = dateFormat.format(date); 
		return strDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(commentElements);
		result = prime * result + (isReply ? 1231 : 1237);
		result = prime * result + ((safeText == null) ? 0 : safeText.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + uniqueID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (!Arrays.equals(commentElements, other.commentElements))
			return false;
		if (isReply != other.isReply)
			return false;
		if (safeText == null) {
			if (other.safeText != null)
				return false;
		} else if (!safeText.equals(other.safeText))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (uniqueID != other.uniqueID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		String output = strBuilder.toString();
		if (isReply) {
			for (int i = 0; i < 5; i++) {
				strBuilder.append(commentElements[i]);
				strBuilder.append("\n");
			}
		}
		else {
			for (int i = 0; i < 4; i++) {
				strBuilder.append(commentElements[i]);
				strBuilder.append("\n");
			}
		}
		output = strBuilder.toString();
		return output;
	}
	
	public static void main(String[] args) {
		//Comment issue = new Comment("bob", "hello people");
		//System.err.println(issue.toString());
	}

}
