/**
 * 
 * @author James Roberts jpr242
 *
 */
public class BST<T extends Comparable<T>> implements BSTInterface<T> {
	
	private BSTNode<T> root;
	private int size;

	public BST() {
		this.root = null;
		this.size = 0;
	}
	
	@Override
	public void add(T data) {
		this.root = this.add(new BSTNode<T>(data), this.root);
		this.size++;
	}

	private BSTNode<T> add(BSTNode<T> data, BSTNode<T> current) {
		if(current == null) {
			current = data;
			return current;
		}
		
		if(data.getData().compareTo(current.getData()) <= 0) {
			current.setLeftNode(this.add(data, current.getLeftNode()));
		} else {
			current.setRightNode(this.add(data, current.getRightNode()));
		}
		
		return current;
	}
	
	@Override
	public boolean contains(T data) {
		return contains(data, this.root);
	}
	
	public boolean contains(T data, BSTNode<T> branch) {
		if(branch == null) {
			return false;
		} else if(data.compareTo(branch.getData()) == 0) {
			return true;
		} else if(data.compareTo(branch.getData()) < 0) {
			return contains(data, branch.getLeftNode());
		} else {
			return contains(data, branch.getRightNode());
		}
	}

	@Override
	public void remove(T data) throws EmptyTreeException {
		if(this.isEmpty()) {
			throw new EmptyTreeException();
		}
		if(!this.contains(data)) {
			
		} else {
			this.remove(data, this.root);
			this.size--;
		}
	}
	
	private BSTNode<T> remove(T data, BSTNode<T> branch) {
		
		if(branch == null) {
			return branch;
		} else if(data.compareTo(branch.getData()) == 0) {
			if(branch.getLeftNode() == null) {
				branch = branch.getRightNode();
			} else if(branch.getRightNode() == null) {
				branch = branch.getLeftNode();
			} else {
				BSTNode<T> temp = branch.getLeftNode();
				for(;temp.getRightNode() != null; temp = temp.getRightNode());
				branch.setData(temp.getData());
				remove(branch.getData(), branch.getLeftNode());
			}
		} else if(data.compareTo(branch.getData()) < 0) {
			branch.setLeftNode(this.remove(data, branch.getLeftNode()));
		} else if(data.compareTo(branch.getData()) > 0) {
			branch.setRightNode(this.remove(data, branch.getRightNode()));
		}
		return branch;
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public String inOrder() {
		return inOrder(this.root);
	}
	
	protected String inOrder(BSTNode<T> branch) {
		String toReturn = "";
		if(branch.getLeftNode() != null) {
			toReturn += this.inOrder(branch.getLeftNode());
		}
		toReturn += branch.getData().toString();
		if(branch.getRightNode() != null) {
			toReturn += this.inOrder(branch.getRightNode());
		}
		return toReturn;
	}

	@Override
	public String preOrder() {
		return this.preOrder(this.root);
	}
	
	protected String preOrder(BSTNode<T> branch) {
		String toReturn = "";
		toReturn += branch.getData().toString();
		if(branch.getLeftNode() != null) {
			toReturn += this.preOrder(branch.getLeftNode());
		}
		if(branch.getRightNode() != null) {
			toReturn += this.preOrder(branch.getRightNode());
		}
		return toReturn;
	}

	@Override
	public String postOrder() {
		return this.postOrder(this.root);
	}
	
	protected String postOrder(BSTNode<T> branch) {
		String toReturn = "";
		if(branch.getLeftNode() != null) {
			toReturn += this.postOrder(branch.getLeftNode());
		}
		if(branch.getRightNode() != null) {
			toReturn += this.postOrder(branch.getRightNode());
		}
		toReturn += branch.getData().toString();
		return toReturn;
	}

	public String toString() {
		return this.inOrder();
	}
	
}
