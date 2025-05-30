package Queues;

public class ArrayQueue<E> {

    private static final int CAPACITY = 1000;
    private E[] arrayQueue;
    private int front;
    private int size;

    public ArrayQueue(int capacity) {

        arrayQueue = (E[]) new Object[capacity];

    }

    public ArrayQueue() {

        this(CAPACITY);

    }

    public int size() {

        return size;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public boolean isFull() {

        return size == arrayQueue.length;

    }

    public void enqueue(E item) {

        if (isFull()) {

            System.out.println("Queue is full. Cannot enqueue.");
            return;

        }
        int avail = (front + size) % arrayQueue.length;
        arrayQueue[avail] = item;
        size++;

    }

    public E dequeue() {

        if (isEmpty()) {

            System.out.println("Queue is empty. Nothing to dequeue.");
            return null;

        }

        E toReturn = arrayQueue[front];
        arrayQueue[front] = null;
        front = (front + 1) % arrayQueue.length;
        size--;

        return toReturn;

    }

    public E first() {

        if (isEmpty()) {

            System.out.println("Queue is empty. No first element.");
            return null;

        }
        return arrayQueue[front];

    }

    public void displayQueue(){

        if(isEmpty()){

            System.out.println("ArrayQueue is empty. Nothing to display.");
            return;

        }

        System.out.print("ArrayQueue: Front -> ");

    
        if(size == 1){

            System.out.print(arrayQueue[front] + " ");
            System.out.println("<- Back");
            return;
        
        }

        int rear = ((front + (size - 1)) % arrayQueue.length);
        if(front < rear){

            for(int i = front; i <= rear; i++){

                System.out.print(arrayQueue[i] + " ");



            }

        } else{

            for(int i = front; i < arrayQueue.length; i++){

                System.out.print(arrayQueue[i] + " ");



            }

            for(int i = 0; i <= rear; i++){


                System.out.print(arrayQueue[i] + " ");
            



            }


        }

        System.out.println("<- Back");


    }






}