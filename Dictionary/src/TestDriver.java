/**
 * 
 * @author James Roberts jpr242
 *
 */
public class TestDriver {

	public static void main(String[] args) {
		BST<String> test = new BST<String>();
		test.add("d");
		test.add("a");
		test.add("b");
		test.add("c");
		test.add("f");
		test.add("e");
		
		System.out.println(test.inOrder());
		System.out.println(test.preOrder());
		System.out.println(test.postOrder());
		System.out.println(test.contains("f"));
		try {
			test.remove("f");
		} catch (EmptyTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(test.toString());
	}
	
}
