package edu.century.finalProject;

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
		for (String word: commentText) {
			//iterate the whole string instead of using split to compare arrays
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(badWords);
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
		LanguageScanner other = (LanguageScanner) obj;
		if (!Arrays.equals(badWords, other.badWords))
			return false;
		return true;
	}

	public static void main(String[] args) {
		LanguageScanner pc = new LanguageScanner();
		
		System.out.println(pc.scanMessage("you are a butt"));
	}
}
