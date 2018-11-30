package century.edu.class_project;

import java.util.ArrayList;
import java.util.List;

import century.edu.class_project.Comment.Node;

public class CommentSection extends Comment{
	
	
	public CommentSection() {
		super();
		List<Comment> chat = new ArrayList<>();
		
	}

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
	
	public void addComment(String name) {
		public Node name;
	}
	

}
