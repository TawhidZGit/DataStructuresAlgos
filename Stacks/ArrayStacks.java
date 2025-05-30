package Stacks;

public class ArrayStacks<E> {

    public final static int CAPACITY = 1000;
    public E[] arrayStack;
    public int top = -1;

    public ArrayStacks(int capacity) {

        arrayStack = (E[]) new Object[capacity];

    }

    public ArrayStacks() {

        this(CAPACITY);

    }

    public int size() {

        return top + 1;
    }

    public boolean isEmpty() {

        return top == -1;

    }

    public boolean isFull() {

        return size() == arrayStack.length;
    }

    public void push(E item) {

        if (isFull()) {

            System.out.println("Stack Overflow Error.");
            return;

        }

        arrayStack[++top] = item;

    }

    public E pop() {

        if (isEmpty()) {

            System.out.println("Stack Underflow Error.");
            return null;
        }

        E toReturn = arrayStack[top];
        arrayStack[top--] = null;

        return toReturn;

    }

    public E peek() {

        if (isEmpty()) {

            System.out.println("Stack is empty.");
            return null;
        }

        return arrayStack[top];

    }

    public void displayArrayStack() {

        if (isEmpty()) {

            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Bottom -> ");
        for (int i = 0; i < size(); i++) {
            
            System.out.print(arrayStack[i] + " ");
        }

        System.out.println("-> top");

    }

}