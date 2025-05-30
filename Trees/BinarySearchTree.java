package Trees;

public class BinarySearchTree<T extends Comparable<T>> implements TreeInterface<T> {

    private class Node {

        private T data;
        private Node rightChild;
        private Node leftChild;

        public Node(T data) {

            this.data = data;

        }

    }

    private Node root;

    @Override
    public boolean isEmpty() {

        return root == null;

    }

    @Override
    public boolean search(T data) {

        return searchRec(root, data) != null;

    }

    private Node searchRec(Node root, T data) {

        if (root == null || root.data.equals(data)) {

            return root;

        } else if (data.compareTo(root.data) < 0) {

            return searchRec(root.leftChild, data);

        } else {

            return searchRec(root.rightChild, data);

        }

    }

    @Override
    public T getMax() {

        if (isEmpty()) {

            return null;

        }

        return getMaxRec(root);

    }

    private T getMaxRec(Node root) {

        if (root.rightChild != null) {

            return getMaxRec(root.rightChild);

        }

        return root.data;

    }

    @Override
    public T getMin() {

        if (isEmpty()) {

            return null;

        }

        return getMinRec(root);

    }

    private T getMinRec(Node root) {

        if (root.leftChild != null) {

            return getMinRec(root.leftChild);

        }

        return root.data;

    }

    /*
     * Inorder Traversal
     */
    @Override
    public void traverse() {

        inorderTraversalRec(root);
        System.out.println();

    }

    private void inorderTraversalRec(Node root) {

        if (root != null) {

            inorderTraversalRec(root.leftChild);
            System.out.print(root.data + " ");
            inorderTraversalRec(root.rightChild);

        }

    }

    public void preorderTraversal() {

        preorderTraversalRec(root);
        System.out.println();

    }

    private void preorderTraversalRec(Node root) {

        if (root != null) {

            System.out.print(root.data + " ");
            preorderTraversalRec(root.leftChild);
            preorderTraversalRec(root.rightChild);

        }

    }

    public void postorderTraversal() {

        postorderTraversalRec(root);
        System.out.println();
    }

    private void postorderTraversalRec(Node root) {

        if (root != null) {

            postorderTraversalRec(root.leftChild);
            postorderTraversalRec(root.rightChild);
            System.out.print(root.data + " ");

        }

    }

    @Override
    public void insert(T data) {

        if (isEmpty()) {

            root = new Node(data);

        } else {

            insertRec(data, root);
        }

    }

    private void insertRec(T data, Node root) {

        if (data.compareTo(root.data) < 0) {

            if (root.leftChild != null) {

                insertRec(data, root.leftChild);

            } else {

                Node newNode = new Node(data);
                root.leftChild = newNode;

            }

        } else if (data.compareTo(root.data) > 0) {

            if (root.rightChild != null) {

                insertRec(data, root.rightChild);

            } else {

                Node newNode = new Node(data);
                root.rightChild = newNode;

            }

        }

    }

    @Override
    public void delete(T data) {

       root = deleteRec(data, root);
        

    }

    private Node deleteRec(T data, Node root){

        if(root == null){

            return null;

        }

        if(data.compareTo(root.data) < 0){

            root.leftChild = deleteRec(data, root.leftChild);

        } else if(data.compareTo(root.data) > 0){

            root.rightChild = deleteRec(data, root.rightChild);

        } else { 

            if(root.leftChild == null){

                return root.rightChild;

            } if(root.rightChild == null){

                return root.leftChild;

            } else{

                T predecessor = getMaxRec(root.leftChild);
                root.data = predecessor;
                root.leftChild = deleteRec(predecessor, root.leftChild);
         

            }

        }

        return root;


    }

    // private void deleteRec(T data, Node root) {
        
    //     if (root == null) {
    //         return;
    //     }

    //     if (data.equals(root.data)) {

    //         if (root.leftChild == null) {
                
    //             root = null;
    //            root.rightChild = null;

    //             if(root != null){

    //                 root.rightChild = null;
                    
    //             }
                
    //             return;
    //         } else {

    //             root = new Node(getMaxRec(root.leftChild));
    //             deleteRec(getMaxRec(root.leftChild), root);

    //         }

    //     } else if (data.compareTo(root.data) < 0) {

    //         deleteRec(data, root.leftChild);

    //     } else if (data.compareTo(root.data) > 0) {

    //         deleteRec(data, root.rightChild);

    //     }

    // }

}
