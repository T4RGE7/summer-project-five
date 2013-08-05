package net.cs.jimisthebest.t4rge7.bstdictionary;

import java.io.Serializable;

/**
 * 
 * @author James Roberts jpr242
 *
 */
public class BSTDictionary extends BST<Word> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8716820717842020814L;

	public BSTDictionary() {
		super();
	}
	
	public Word containsGet(String word) {
		if(this.contains(new Word(word, null, null))) {
			return this.containsGet(new Word(word, null, null), this.root);
		} else {
			return null;
		}
	}
	
	private Word containsGet(Word word, BSTNode<Word> branch) {
		if(word == null) {
			return null;
		} else if(word.compareTo(branch.getData()) == 0) {
			return branch.getData();
		} else if(word.compareTo(branch.getData()) < 0) {
			return this.containsGet(word, branch.getLeftNode());
		} else {
			return this.containsGet(word, branch.getRightNode());
		}
	}
	
	public String toString() {
		return this.inOrder();
	}
	
}
