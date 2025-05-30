package Trees;

public class AVLTree2<T extends Comparable<T>> {

    private static class AVLNode<T extends Comparable<T>> {

        T data;
        AVLNode<T> left, right;
        int height;

        AVLNode(T data) {

            this.data = data;
            this.height = 1;
        }

    }

    private AVLNode<T> root;

    public void insert(T data) {

        root = insertRec(root, data);
    }

    private AVLNode<T> insertRec(AVLNode<T> node, T data) {

        if (node == null)
            return new AVLNode<T>(data);

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {

            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {

            node.right = insertRec(node.right, data);

        } else {

            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && data.compareTo(node.left.data) < 0) {

            return rotateRight(node);
        }

        // RR
        if (balance < -1 && data.compareTo(node.left.data) > 0) {

            return rotateLeft(node);

        }

        // LR
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = rotateRight(node.left);
            return rotateLeft(node);

        }

        // RL
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rotateLeft(node.left);
            return rotateRight(node);
        }

        return node;

    }

    public void delete(T data) {

        root = deleteRec(root, data);
    }

    private AVLNode<T> deleteRec(AVLNode<T> node, T data) {

        if (node == null)
            return null;

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {

            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {

            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else

            {
                AVLNode<T> successor = getMinValue(node.right);
                node.data = successor.data;
                node.right = deleteRec(node.right, successor.data);
            }
        }

        if (node == null)
            return null;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = height(node.left) - height(node.right);

        // LL
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // LR
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

    public void inorderTraversal() {

        inorderTraversalRec(root);
        System.out.println();
    }

    private void inorderTraversalRec(AVLNode<T> node) {

        AVLNode<T> curr = node;
        while (curr != null) {
            inorderTraversalRec(curr.left);
            System.out.print(curr.data + " ");
            inorderTraversalRec(curr.right);
        }
    }

    private int height(AVLNode<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(AVLNode<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode<T> rotateRight(AVLNode<T> y) {

        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> x) {

        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.left)) + 1;

        return y;
    }

    private AVLNode<T> getMinValue(AVLNode<T> node) {

        AVLNode<T> curr = node;
        while (curr.left != null) {

            curr = curr.left;
        }

        return curr;
    }

}
