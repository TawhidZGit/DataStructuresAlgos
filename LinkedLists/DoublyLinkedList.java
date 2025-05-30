package LinkedLists;

public class DoublyLinkedList<T> {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.prepend(0);
        list.display();
        // Output: Head <-> 0 <-> 1 <-> 2 <-> 3 <-> Tail
        list.insertAfterData(1, 0);
        list.insertBeforeData(-1, 0);
        list.display();
        // Output: Head <-> -1 <-> 0 <-> 1 <->  1 <-> 2 <-> 3 <-> Tail
        list.remove(2);
        list.removeByIndex(1);
        list.display();
        // Output: Head <-> -1 <-> 1 <->  1 <-> 3 <-> Tail
        list.reverse();
        list.display();
        // Output: Head <-> 3 <-> 1 <-> 1 <-> -1 <-> Tail


    }

    private static class Node<T>{

        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data){

            this.data = data;

        }

    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void append(T data) {

        Node<T> newNode = new Node<T>(data);
        if (head == null) {

            head = tail = newNode;

        } else {

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }

        size++;
    }

    public void prepend(T data) {

        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAfterData(T dataToInsert, T dataToInsertAfter) {

        Node<T> curr = head;
        while (curr != null) {

            if (curr.data.equals(dataToInsertAfter)) {

                Node<T> newNode = new Node<T>(dataToInsert);
                newNode.prev = curr;
                newNode.next = curr.next;
                if (curr.next != null) {

                    curr.next.prev = newNode;
                } else {

                    tail = curr;
                }

                curr.next = newNode;
                size++;
                return;

            }
            curr = curr.next;
        }

        System.out.println("Data not present within List.");

    }

    public void insertBeforeData(T dataToInsert, T dataToInsertBefore){

       
        Node<T> curr = head;
        while(curr != null){

            if(curr.data.equals(dataToInsertBefore)){

                Node<T> newNode = new Node<T>(dataToInsert);
                newNode.prev = curr.prev;
                newNode.next = curr;

                if(curr.prev != null){

                    curr.prev.next = newNode;

                } else{

                    head = newNode;

                }
                curr.prev = newNode;
                size++;
                return;

            }
            curr = curr.next;
        }

        System.out.println("Data not present within List.");

    }

    public void remove(T data) {

        if (head == null)
            return;

        Node<T> curr = head;

        while (curr != null) {

            if (curr.data.equals(data)) {

                if (curr == head) {

                    head = curr.next;
                    if (head != null)
                        head.prev = null;
                    else
                        tail = null;

                } else if (curr == tail) {

                    tail = curr.prev;
                    tail.next = null;

                } else {

                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;

                }

                size--;
                return;
            }

            curr = curr.next;

        }

        
    }

    // We can also  make this code better by optimizing the travesal bby making it so that
    //If index is closer to tail, traverse from tail backwards.
    //If index is closer to head, traverse from head forwards.
    public void removeByIndex(int index){

           
            if(index < 0 || index >= size ){

                return;

            } 

            if(index == 0 ){

                head = head.next;
                if(head != null){

                    head.prev = null;
                } else {

                    tail = null;
                }

            } else if(index == size - 1){

                tail = tail.prev;
                if(tail != null){
                    tail.next = null;
                }

            } else {

                Node<T> curr = head;
                for(int i = 0; i < index;  i++){

                    curr = curr.next;

                }


                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            size--;


    }

    public void reverse() {

        if (head == null)
            return;

        Node<T> curr = head;
        Node<T> temp = null;

        while (curr != null) {

            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;

        }

        if (temp != null) {

            tail = head;
            head = temp.prev;
        }

    }

    public void display(){

        if(head == null)return;


        Node<T> curr = head;
        System.out.print("Head <-> ");
        while(curr != null){

            System.out.print(curr.data);
            
            if(curr.next != null){

                System.out.print(" <-> ");

            }

            curr = curr.next;
        }

        System.out.println(" <-> Tail");

    }

}
