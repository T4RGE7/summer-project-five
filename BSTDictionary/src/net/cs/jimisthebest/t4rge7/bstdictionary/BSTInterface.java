package net.cs.jimisthebest.t4rge7.bstdictionary;
/**
 * 
 * @author James Roberts jpr242
 *
 */
public interface BSTInterface<T extends Comparable<T>> {

	void add(T data);
	boolean contains(T data);
	void remove(T data) throws EmptyTreeException;
	int size();
	boolean isEmpty();
	String inOrder();
	String preOrder();
	String postOrder();	
}
