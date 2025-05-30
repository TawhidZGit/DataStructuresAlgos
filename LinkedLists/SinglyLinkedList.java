package LinkedLists;

public class SinglyLinkedList<E> {

    @SuppressWarnings("hiding")
    public class Node<E> {

        Node<E> next;
        E data;

        Node(E data, Node<E> next) {

            this.data = data;
            this.next = next;

        }

        Node(E data) {

            this.data = data;
            this.next = null;
        }

    }

    Node<E> head;
    Node<E> tail;
    int size = 0;

    public boolean isEmpty() {

        return head == null;

    }

    public void insertAtEnd(E data) {

        Node<E> newNode = new Node<>(data);

        if (isEmpty()) {

            head = newNode;
            tail = newNode;

        } else {

            tail.next = newNode;
            tail = newNode;

        }

        size++;
    }

    public void insertAtBeg(E data) {

        Node<E> newNode = new Node<>(data);

        if (isEmpty()) {

            head = newNode;
            tail = newNode;

        } else {

            newNode.next = head;
            head = newNode;
        }

        size++;

    }

    public void insertAfterData(E dataToInsert, E dataInList) {

        Node<E> newNode = new Node<>(dataToInsert);
        if (isEmpty()) {

            System.out.println("Data is not present within list.");
            return;
        }

        if (tail.data == dataInList) {

            tail.next = newNode;
            tail = newNode;

        } else {

            Node<E> curr = head;
            while (curr != null && curr.data != dataInList) {

                curr = curr.next;

            }

            if (curr != null) {

                newNode.next = curr.next;
                curr.next = newNode;

            } else {

                System.out.println("Data is not present within list.");
                return;

            }

        }

        size++;

    }

    public void insertBeforeData(E dataToInsert, E dataInList) {

        if (isEmpty()) {

            System.out.println("Data is not present within list.");

            return;

        }

        Node<E> newNode = new Node<>(dataToInsert);
        if (head.data == dataInList) {

            newNode.next = head;
            head = newNode;

        } else {
            Node<E> curr = head;
            while (curr.next != null && curr.next.data != dataInList) {

                curr = curr.next;

            }

            if (curr.next != null) {

                newNode.next = curr.next;
                curr.next = newNode;

            } else {

                System.out.println("Data is not present within list.");
                return;

            }
        }

        size++;

    }

    // Inserts node after a given index within the list
    // Index starts at 0
    public void insertAfterIndex(E data, int index) {

        // Checks to see if index is within range of the amount of nodes within list
        // If it isn't, it prompts the user it is not and then returns
        if (index > size - 1 || index <= -1) {

            System.out.println("Index is out of bounds.");
            return;
        }

        // Initialize the new Node
        Node<E> newNode = new Node<>(data);

        // This tests to check if the index is the tails index, and inserts the node
        // after it if it is
        if (index == size - 1) {

            tail.next = newNode;
            tail = newNode;

        } else {

            // Traverse the list using "i" as the tracking index comparing it to the desired
            // index
            Node<E> curr = head;
            for (int i = 0; i < size; i++) {

                if (i == index) {

                    break;
                }

                curr = curr.next;

            }

            // Inserts the new node without disrupting the SinlgyLinkedList
            newNode.next = curr.next;
            curr.next = newNode;

        }

        size++;

    }

    public void insertBeforeIndex(E data, int index) {

        if (index > size - 1 || index <= -1) {

            System.out.println("Index is out of bounds.");
            return;
        }

        Node<E> newNode = new Node<>(data);

        if (index == 0) {

            newNode.next = head;
            head = newNode;
        } else {

            Node<E> curr = head;
            Node<E> prev = curr;
            for (int i = 0; i < size; i++) {

                if (i == index) {

                    break;

                }

                prev = curr;
                curr = curr.next;

            }

            newNode.next = curr;
            prev.next = newNode;

        }

        size++;
    }

    public void deleteFirst() {

        if (isEmpty()) {
            System.out.println("List is empty. No node to delete.");
            return;
        }

        if (size == 1) {

            head = head.next;
            tail = head;
        }

        head = head.next;

        size--;

    }

    public void deleteLast() {

        if (isEmpty()) {
            System.out.println("List is empty. No node to delete.");
            return;
        }

        if (size == 1) {

            head = null;
            tail = head;

        } else {

            Node<E> curr = head;

            while (curr.next.next != null) {

                curr = curr.next;

            }

            curr.next = curr.next.next;
            tail = curr;
        }

        size--;

    }

    public void deleteNodeFromGivenData(E data) {

        if (isEmpty()) {
            System.out.println("List is empty. No node to delete.");
            return;
        }

        if (head.data == data) {

            if (size == 1) {
                head = null;
                tail = head;

            } else {

                Node<E> curr = head;
                head = head.next;
                curr.next = null;

            }
        } else {

            Node<E> curr = head;
            while (curr.next != null && curr.next.data != data) {

                curr = curr.next;

            }

            if (curr.next != null) {

                // this is to handle the case that the data is the tail, I didnt do a check to
                // match up the tails data with
                // the given data in case there is duplicates
                if (curr.next.next == null) {

                    curr.next = curr.next.next;
                    tail = curr;

                } else {

                    curr.next = curr.next.next;

                }

            } else {

                System.out.println("Data to delete does not exist within the list.");
                return;
            }

        }

        size--;
    }

    public void deleteIndex(int index) {

        if (index > size - 1 || index < 0 || isEmpty()) {

            System.out.println("Index out of bounds.");
            return;
        }

        if (size == 1) {

            head = null;
            tail = head;

        } else if (index == 0) {

            Node<E> curr = head;
            head = head.next;
            curr.next = null;

        } else {

            Node<E> curr = head;
            Node<E> prev = curr;

            for (int i = 0; i < size - 1; i++) {

                if (index == i) {

                    break;
                }

                prev = curr;
                curr = curr.next;
                

            }

            if(index == size - 1){

                prev.next = curr.next;
                curr.next = null;
                tail = prev;

            }
            prev.next = curr.next;
            curr.next = null;

        }

        size--;

    }

    public void printSinglyLinkedList() {

        Node<E> curr = head;
        while (curr != null) {

            System.out.print(curr.data + " - > ");
            curr = curr.next;
        }
        System.out.println("null");

    }

    public void getSize() {

        System.out.println(size);

    }

    public void printtail() {

        System.out.println(tail.data);

    }

    public void printhead() {

        System.out.println(head.data);
    }

}