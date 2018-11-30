package century.edu.class_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Comment {
	private String userName;
	private int commentID;
	private String text;
	private String title;
	private List<String> userNames = new ArrayList<>();    //only add new comment names
	private String[] commentElements = new String[10];

	public class Node<T> {

		private T data = null;

		private List<Node<T>> children = new ArrayList<>();

		private Node<T> parent = null;

		public Node(T data) {
			this.data = data;
		}

		public Node<T> addChild(Node<T> child) {
			child.setParent(this);
			this.children.add(child);
			return child;
		}


		public List<Node<T>> getChildren() {
			return children;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		private void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public Node<T> getParent() {
			return parent;
		}

	}

	public Comment() {
		
	}
	
	
	public Comment(String name, String text) {
		//parse text for @userName: discern whether reply or new comment
		String[] splitText = text.split(" ");
		String[] checkForReply = splitText[0].split("");
		String userName = "";
		//if reply: loop through list of users and comment as a 'child' of that users last comment
		if (checkForReply[0].equals("@")) {
			for (int i = 1; i <= checkForReply.length - 1; i++) {
				userName = userName + checkForReply[i];
			}
		}
		//if not reply: generate new comment
		else {
			setText(text);
			userNames.add(name);
			commentElements[0] = name;
			commentElements[1] = getText();
		}
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void delete() {
		//check user access level: admin or standard user
		//set spot on arrayList to null
	}

	public void modifyText(String text) {
		//check user access level: admin or standard user
		setText(text);
	}

	public boolean search(String target) {
		//search for posts by userName
		//display all posts made by the user
	}

	public Date commentTimeStamp() {
		Date date = new Date();
		return date;

	}

	/*public String replyTo(String name, String text) {	//may not implement
		//check name against array of userNames
		//create the reply comment as a child of the original comment
	}*/

}
