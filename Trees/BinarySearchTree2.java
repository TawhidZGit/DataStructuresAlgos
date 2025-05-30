package Trees;

public class BinarySearchTree2<T extends Comparable<T>>{

	public static class BSTNode<T extends Comparable<T>>{

		T data;
		BSTNode<T> left, right;

		public BSTNode(T data){
			this.data = data;
		}
	}
	
	private BSTNode<T> root;

	public void insert(T data){

		root = insertRec(root, data);
	}

	private BSTNode<T> insertRec(BSTNode<T> root, T data){

		if(root == null)return new BSTNode<T>(data);

		if(data.compareTo(root.data) < 0){
			root.left = insertRec(root.left, data);
		} else if(data.compareTo(root.data) > 0){
			root.right = insertRec(root.right, data);
		}

		return root;
	}

	public boolean search(T data){

		return searchRec(root, data);
	}

	private boolean searchRec(BSTNode<T> root, T data){

		if(root == null)return false;

		if(data.equals(root.data))return true;

		if(data.compareTo(root.data) < 0){

			return searchRec(root.left, data);
		} else {

			return searchRec(root.right, data);
		}

	}

	public void inorderTraversal(){

		inorderTraversalRec(root);
		System.out.println();

	}

	private void  inorderTraversalRec(BSTNode<T> root){

		if(root != null){

			inorderTraversalRec(root.left);
			System.out.print(root.data + " ");
			inorderTraversalRec(root.right);
		}

	}

	public void delete(T data){

		root = deleteRec(root, data);
	}

	private BSTNode<T> deleteRec(BSTNode<T> root, T data){

		if(root == null)return null;

		int cmp = data.compareTo(root.data);

		if(cmp < 0){

			root.left = deleteRec(root.left, data);
		} else if (cmp > 0){

			root.right = deleteRec(root.right, data);
		} else{

			if(root.left == null)return root.right;
			if(root.right == null)return root.left;

			BSTNode<T> succesor = findMin(root.right);
			root.data = succesor.data;
			root.right = deleteRec(root.right, succesor.data);
		}

		return root;
	}


	private BSTNode<T> findMin(BSTNode<T> root){

		while(root.left != null)root = root.left;
		return root;

	}

}
