

import java.io.Serializable;

/**
 * 
 * @author James Roberts jpr242
 *
 */
public class BSTNode<T extends Comparable<T>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6960284628394295649L;
	private T data;
	private BSTNode<T> leftNode, rightNode;
	
	/**
	 * Creates a new BSTNode with null left and right pointers and the data given
	 * @param data The data to be set
	 */
	public BSTNode(T data) {
		this.data = data;
		this.leftNode = this.rightNode = null;
	}
	
	/**
	 * Creates a new BSTNode with null left and right pointers and data
	 */
	public BSTNode() {
		this.data = null;
		this.leftNode = this.rightNode = null;
	}
	
	/**
	 * Sets the data held to the data given
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Gets the data held by this node
	 * @return the data held
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * Sets the left pointer to the node given
	 * @param leftNode the node to be set
	 */
	public void setLeftNode(BSTNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	
	/**
	 * Gets the left node
	 * @return the left node
	 */
	public BSTNode<T> getLeftNode() {
		return this.leftNode;
	}
	
	/**
	 * Sets the right pointer to the node given
	 * @param rightNode the node to be set
	 */
	public void setRightNode(BSTNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	/**
	 * Gets the right node
	 * @return the right node
	 */
	public BSTNode<T> getRightNode() {
		return this.rightNode;
	}
	
}
