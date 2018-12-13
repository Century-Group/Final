package century.edu.class_project;

import java.util.Arrays;

public class LanguageScanner {
	
	private String[] badWords = {"shit", "damn", "ass", "bitch", "basturd", "fuck"};
	
	
	public LanguageScanner() {
		
	}
	
	/*
	 * Replaces all the letters of any word listed in the badWords array with "*".
	 * Precondition: Takes a String as an argument.
	 * Postcondition: Returns the new version of the string with profanity censored by "*".
	 */
	public String cleanText(String text) {	//test again later
		String[] commentText = text.split(" ");
		String cleanString = "";
		//iterate 
		for (String bannedWord: badWords) {
			//iterate the whole string instead of using split to compare arrays
			for (String word: commentText) {
				if (word.equals(bannedWord)) {
					word = word.replaceAll("[a-zA-Z]", "*");
				}
			}
		}
		for (int i = 0; i < commentText.length; i++) {
			cleanString = cleanString + commentText[i] + " ";
		}
		return cleanString;
	}
	
	public Boolean scanMessage(String message) {
		boolean containsBadWord = false;
		for(String badWord : badWords){
		    if (message.toLowerCase().contains(badWord)) {
		        containsBadWord = true;
		        break;
		    }
		}
		if(containsBadWord){
		    return false;
		}
		else {
		    return true;
		}
	}


	public static void main(String[] args) {
		LanguageScanner pc = new LanguageScanner();
		
		System.out.println(pc.scanMessage("you are a butt"));
	}
}
