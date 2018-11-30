package century.edu.class_project;

import java.util.Arrays;

public class LanguageScanner {
	
	private String[] badWords = {"butt"};
	
	
	public LanguageScanner() {
		
	}
	
	/*
	 * Replaces all the letters of any word listed in the badWords array with "*".
	 * Precondition: Takes a String as an argument.
	 * Postcondition: Returns the new version of the string with profanity censored by "*".
	 */
	public String cleanText(String text) {
		String[] commentText = text.split(" ");
		String cleanString = "";
		//iterate 
		for (String word: commentText) {
			for (String bannedWord: badWords) {
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
	
	public static void main(String[] args) {
		LanguageScanner pc = new LanguageScanner();
		
		System.out.println(pc.cleanText("you are a butt"));
	}
}
