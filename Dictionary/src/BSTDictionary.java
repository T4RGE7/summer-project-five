/**
 * 
 * @author James Roberts jpr242
 *
 */
public class BSTDictionary extends BST<Word> {

	public BSTDictionary() {
		super();
	}
	
	public String toString() {
		return this.inOrder();
	}
	
}
