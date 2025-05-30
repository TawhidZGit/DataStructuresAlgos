package LinkedLists;

public class SinglyLinkedList2<T> {
    public static void main(String[] args) {
        // Example usage of the SinglyLinkedList class
        SinglyLinkedList2<Integer> list = new SinglyLinkedList2<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.prepend(0);
        list.display(); // Output: Head --> 0 --> 1 --> 2 --> 3  --> null
        list.remove(2);
        list.display(); // Output: Head --> 0 --> 1 --> 3  --> null
        list.removeByIndex(1);
        list.display(); // Output: Head --> 0 --> 3  --> null

        
    }

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {

            this.data = data;

        }

    }

    private Node<T> head;
    private int size;

    public void append(T data) {

        Node<T> newNode = new Node<T>(data);
        if (head == null) {

            head = newNode;

        } else {

            Node<T> curr = head;
            while (curr.next != null) {

                curr = curr.next;

            }
            curr.next = newNode;

        }
        size++;

    }

    public void prepend(T data) {

        Node<T> newNode = new Node<T>(data);
        if (head == null) {

            head = newNode;

        } else {

            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    public void remove(T data) {

        if (head == null) {

            return;

        } else if (head.data.equals(data)) {

            head = head.next;
            size--;
            return;

        }

        Node<T> curr = head;
        while (curr.next != null && !curr.next.data.equals(data)) {

            curr = curr.next;

        }

        if (curr.next != null) {

            curr.next = curr.next.next;
            size--;

        }

    }

    public T removeByIndex(int index) {

        if (index < 0 || index >= size)
            return null;

        T toReturn;

        if (head != null && index == 0) {

            toReturn = head.data;
            head = head.next;

        } else {

            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {

                curr = curr.next;

            }

            toReturn = curr.next.data;
            curr.next = curr.next.next;

        }
        size--;
        return toReturn;

    }

    public boolean search(T data) {

        Node<T> curr = head;

        while (curr != null) {

            if (curr.data.equals(data)) {
                return true;
            }

            curr = curr.next;

        }

        return false;

    }

    // There is a recursive version I should look in to understanding it because
    // I do not think I am getting it
    public void reverse() {

        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        head = prev;

    }

    public void display(){

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node<T> curr = head;

        System.out.print("Head --> ");

        while(curr != null){

            System.out.print(curr.data);
            if(curr.next != null){

                System.out.print(" --> ");

            }

            curr = curr.next;

        }

        System.out.println("  --> null");





    }

}