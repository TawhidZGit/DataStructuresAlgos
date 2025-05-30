package Stacks;

public class LinkedListStack<E> {

    public class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {

            this.data = data;
            this.next = null;
        }

        public Node(E data, Node<E> next) {

            this.data = data;
            this.next = next;
        }

    }

    private Node<E> top;

    public LinkedListStack() {

        this.top = null;

    }

    public boolean isEmpty() {

        return top == null;

    }

    public void push(E data) {

        Node<E> curr = top;

        top = new Node<>(data, curr);

    }

    public E pop() {

        if (isEmpty()) {

            System.out.println("Stack Underflow Error.");
            return null;
        }

        E toReturn = top.data;

        top = top.next;

        return toReturn;

    }

    public E peek() {

        if (isEmpty()) {

            System.out.println("Stack is empty.");

            return null;

        }

        return top.data;

    }

    public void displayLinkedListStack() {

        if (isEmpty()) {

            System.out.println("Stack is empty. Nothing to print.");
            return;

        }

        Node<E> curr = top;

        System.out.print("LinkedListStack: Top -> ");

        while (curr != null) {

            System.out.print(curr.data + " ");
            curr = curr.next;

        }

        System.out.println("-> Bottom");

    }

}
