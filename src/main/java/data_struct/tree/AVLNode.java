package data_struct.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lyy
 */
public class AVLNode {

	public AVLNode parent;
	public AVLNode leftChild, rightChild;
	public int data;

	public AVLNode(AVLNode parent, AVLNode leftChild, AVLNode rightChild, int data) {
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.data = data;
	}

	public AVLNode(int data) {
		this(null, null, null, data);
	}

	public AVLNode(AVLNode parent, int data) {
		this.parent = parent;
		this.data = data;
	}
}