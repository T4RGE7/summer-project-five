/**
 * 
 * @author James Roberts jpr242
 *
 */
public class TestDriver {

	public static void main(String[] args) {
		BST<String> test = new BST<String>();
		test.add("2");
		test.add("1");
		test.add("3");
		System.out.println(test.inOrder());
		System.out.println(test.preOrder());
		System.out.println(test.postOrder());
		System.out.println(test.contains("4"));
		try {
			test.remove("2");
		} catch (EmptyTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(test.toString());
	}
	
}
