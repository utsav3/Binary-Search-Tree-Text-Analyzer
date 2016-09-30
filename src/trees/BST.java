//The following code reads a file and store the words in a Binary Search Tree and counts the frequency of words. And displays the least used word.
//CS220 Assignment

package trees;

import java.util.NoSuchElementException;	//Throws element not found exception


public class BST<T extends Comparable<? super T>> {


	private static class node<T extends Comparable<? super T>> {		//Creates the node class for BST
		T data;															//generic data

		public static int numOfNodes;
		node<T> left;													//left node deceleration
		node<T> right;													//left node deceleration
		public int value;


		node(T theElement) {											//Constructor(instance of class)
			data = theElement;											//the parameter inserted is stored in the variable data.
			left = right = null;										//left and right node is set to null
			numOfNodes=0;
		}
	}

	private node<T> root;		//Creates a root of BST

	public BST() {			//Instance of the class BST
		root = null;			//Sets root to null
	}


	public static<T extends Comparable<? super T>> BST<T> BSTree() {
		return new BST<T>();
	}

	public void insert(T value) {			//Calls the insert method in the Class below recursively
		root = insert(value, root);			//Adds the value given to the given node in the insert method below
		//node.numOfNodes++;
	}


	public void remove(T value) {
		root = remove(value, root);
	}

	public boolean contains(T value) {
		return valueOf(find(value, root)) != null;
	}

	private T valueOf(node<T> entry) {
		if(entry == null)
			return null;
		else 
			return entry.data;
	}

	private node<T> insert(T value, node<T> entry) {
		if (entry == null)
			entry = new node<T>(value);
		else if (value.compareTo(entry.data) < 0)
			entry.left = insert(value, entry.left);
		else if (value.compareTo(entry.data) > 0)
			entry.right = insert(value, entry.right);
		else
			throw new RuntimeException("Duplicate Entry : " + value.toString());
		node.numOfNodes++;
		return entry;


	}


	private node<T> remove(T value, node<T> entry) {			//Deletion of the element in the tree. 
		if (entry == null)
			throw new NoSuchElementException("Entry not found : " + value.toString());
		if (value.compareTo(entry.data) < 0)
			entry.left = remove(value, entry.left);
		else if (value.compareTo(entry.data) > 0)
			entry.right = remove(value, entry.right);
		else {
			// Entry found.
			if (entry.left != null && entry.right != null) {

				// Replace with in-order successor (the left-most child of the right subtree)
				entry.data = findMin(entry.right).data;
				entry.right = removeInorderSuccessor(entry.right);

				// Replace with in-order predecessor (the right-most child of the left subtree)
				// entry.element = findMax(entry.left).element;
				// entry.left = removeInorderPredecessor(entry.left);
			} else
				entry = (entry.left != null) ? entry.left : entry.right;
		}

		return entry;
	}


	private node<T> removeInorderSuccessor(node<T> entry) {				//Removes the parent node of the deleted node
		if (entry == null)
			throw new NoSuchElementException();
		else if (entry.left != null) {
			entry.left = removeInorderSuccessor(entry.left);
			return entry;
		} else
			return entry.right;
	}

	private node<T> removeInorderPredecessor(node<T> entry) {			//rearranges the chid of a parent node
		if (entry == null)
			throw new NoSuchElementException();
		else if (entry.right != null) {
			entry.right = removeInorderPredecessor(entry.right);
			return entry;
		} else
			return entry.left;
	}

	private node<T> findMin(node<T> entry) {							//Finds the minimum value in the binary tree
		if (entry != null)
			while (entry.left != null)
				entry = entry.left;

		return entry;
	}

	private node<T> findMax(node<T> entry) {							//Finds the max stored in the tree
		if (entry != null)
			while (entry.right != null)
				entry = entry.right;

		return entry;
	}

	public node<T> find(T value, node<T> entry) {						//Searches any particular value in the tree
		while (entry != null) {											//only executes while tree is not empty 
			if (value.compareTo(entry.data) < 0)						//Decides weather to store in right or left
				entry = entry.left;
			else if (value.compareTo(entry.data) > 0)
				entry = entry.right;
			else
				return entry;
		}

		return null;
	}
	public int count=0;									//Declares a variable called count to store in array
	public static String[] anArray=new String[189509];	//Creates a static array to store all the value of the tree
	private void printInOrder(node<T> entry) {			//Prints the tree value in Order traversal
		if (entry != null) {							//checks the tree is empty or not
			printInOrder(entry.left);					//prints the left value
			System.out.println(entry.data);				
			anArray[count]=(String) entry.data;  		//Stores into an array the elements from the tree
			count++;
			printInOrder(entry.right);					//Prints the right data

		}

	}
	
	public void displayArray(){
		for(int i=0;i<anArray.length;i++){
			System.out.print(" "+anArray[i]);
		}
	}

	

	public void printInOrder() {					//Recursively calls the inOrder method
		printInOrder(root);


	}
	


}