package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {



	public static class TreeNode<T>{

		T data;
		TreeNode<T> left, right;

		public TreeNode(T data){

			this.data = data;

		}
	}

	public void preorder(TreeNode<T> root){

		if(root == null)return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public void inorder(TreeNode<T> root){

		if(root == null)return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public void postorder(TreeNode<T> root){

		if(root ==  null)return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");		
	}

	public void levelOrder(TreeNode<T> root){

		if(root == null)return;
		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()){
			TreeNode<T> curr = queue.poll();
			System.out.print(curr.data + " ");

			if(curr.left != null)queue.offer(curr.left);
			if(curr.right != null)queue.offer(curr.right);
		}
	}

	public void levelOrderByLevelSize(TreeNode<T> root){

		if(root == null)return;

		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()){

			int levelSize = queue.size();

			for(int i = 0; i < levelSize; i++){

				TreeNode<T> curr = queue.poll();
				System.out.print(curr.data + " ");
				if(curr.left != null)queue.offer(curr.left);
				if(curr.right != null)queue.offer(curr.right);
			}
			System.out.println();
		}

	}

	public void iterativePreorder(TreeNode<T> root){

		if(root == null)return;

		Stack<TreeNode<T>> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){

			TreeNode<T> curr = stack.pop();
			System.out.print(curr.data + " ");

			if(curr.right != null)stack.push(curr.right);
			if(curr.left != null)stack.push(curr.left);
		}
	}

	public void iterativeInorder(TreeNode<T> root){

		if(root == null)return;

		Stack<TreeNode<T>> stack = new Stack<>();
		TreeNode<T> curr = root;

		while(curr != null || !stack.isEmpty()){

			while(curr != null){

				stack.push(curr);
				curr=  curr.left;
			}


			curr = stack.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

    
}
