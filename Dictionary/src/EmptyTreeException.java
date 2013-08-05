/**
 * 
 * @author James Roberts jpr242
 *
 */
public class EmptyTreeException extends Exception {

	private static final long serialVersionUID = 1021823497464654601L;

	public EmptyTreeException(String message) {
		super(message);
	}
	
	public EmptyTreeException() {
		super("Error: Tree is Empty");
	}
	
}
