package Heaps;

public class MinHeapPriorityQueue<T extends Comparable<T>> implements HeapInterface<T> {

    private T[] heap;
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MinHeapPriorityQueue(int capacity) {

        heap = (T[]) new Comparable[capacity];
        currentSize = 0;

    }

    public MinHeapPriorityQueue() {

        this(DEFAULT_CAPACITY);

    }

    public MinHeapPriorityQueue(T[] elements) {


      heapify(elements);


    }

    @SuppressWarnings("unchecked")
    public T[] heapify(T[] elements) {

        currentSize = elements.length;
        heap = (T[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];
        System.arraycopy(elements, 0, heap, 1, currentSize);

        // int j = 1;
        // for( T item : elements )
        //     heap[ j++ ] = item;
        for (int i = currentSize / 2; i > 0; i--) {

            percolateDown(i);

        }

        return heap;
    }

    @Override
    public void insert(T data) {

        if (isFull()) {

            enlargeArray(heap.length * 2);
        }

        int hole = currentSize + 1;
        heap[hole] = data;
        percolateUp(hole);
        currentSize++;

    }

    @Override
    public T poll() {

        if (isEmpty()) {

            System.out.println("Unable to poll. Heap is Empty");
            return null;
        }

        T toReturn = heap[1];
        int hole = currentSize;
        heap[1] = heap[hole];
        heap[hole] = null;
        percolateDown(1);
        currentSize--;

        return toReturn;

    }

    @Override
    public T peek() {

        return heap[1];

    }

    @Override
    public int size() {

        return currentSize;

    }

    @Override
    public boolean isEmpty() {

        return currentSize == 0;

    }

    public boolean isFull() {

        return heap.length == currentSize + 1;

    }

    public void display() {

        for (int i = 1; i <= currentSize; i++) {

            System.out.print(heap[i] + " ");

        }

        System.out.println();

    }

    public void changeValue(int index, T newValue) {

        if (index > currentSize || index < 1) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T temp = heap[index];
        heap[index] = newValue;
        if (temp.compareTo(heap[index]) < 0) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
    }

    public void increaseKey(int index, int delta) {

        if (index > currentSize || index < 1)
            return;
        if (!(heap[index] instanceof Integer)) {
            throw new IllegalArgumentException("IncreaseKey with delta only works for Integer types");
        }
        @SuppressWarnings("unchecked")
        T newValue = (T) (Integer) (((Integer) heap[index]) + delta);
        if (!(newValue.compareTo(heap[index]) > 0)) {

            throw new IllegalArgumentException("New value must be greater than the current value");
        }
        heap[index] = newValue;
        percolateDown(index);

    }

    public void decreaseKey(int index, int delta) {

        if (index > currentSize || index < 1)
            return;
        if (!(heap[index] instanceof Integer)) {
            throw new IllegalArgumentException("DecreaseKey with delta only works for Integer types");
        }
        @SuppressWarnings("unchecked")
        T newValue = (T) (Integer) (((Integer) heap[index]) - delta);
        if (!(newValue.compareTo(heap[index]) < 0)) {

            throw new IllegalArgumentException("New value must be less than the current value");
        }
        heap[index] = newValue;
        percolateUp(index);

    }

    public void clearHeap() {
        currentSize = 0;
    }

    @SuppressWarnings("unchecked")
    private void enlargeArray(int newCapacity) {

        T[] newHeap = (T[]) new Comparable[newCapacity];
        System.arraycopy(heap, 1, newHeap, 1, currentSize);
        heap = newHeap;

    }

    @SuppressWarnings({ "unchecked", "unused" })
    private void enlargeArrayV2(int newCapacity) {

        T[] copyHeap = heap;
        heap = (T[]) new Comparable[newCapacity];
        for (int i = 0; i <= currentSize; i++) {

            heap[i] = copyHeap[i];

        }

    }

    private void percolateUp(int hole) {

        while (true) {

            if (hole > 1 && heap[hole / 2].compareTo(heap[hole]) > 0) {

                swap(heap, hole, hole / 2);
                hole /= 2;

            } else {

                break;
            }

        }

    }

    private void percolateDown(int index) {

        int smallest = index;
        while (true) {

            int leftChild = smallest * 2;
            int rightChild = smallest * 2 + 1;

            if (rightChild <= currentSize  && heap[rightChild].compareTo(heap[smallest]) < 0 && heap[rightChild].compareTo(heap[leftChild]) < 0) {

                swap(heap, smallest, rightChild);
                smallest = rightChild;

            } else if (leftChild <= currentSize && heap[leftChild].compareTo(heap[smallest]) < 0) {

                swap(heap, smallest, leftChild);
                smallest = leftChild;

            } else {

                break;
            }

        }

        // while (true) {
        //     int leftChild = index * 2;
        //     int rightChild = index * 2 + 1;
        //     int smallest = index;
    
        //     // Check bounds and compare left child
        //     if (leftChild <= currentSize && heap[leftChild].compareTo(heap[smallest]) < 0) {
        //         smallest = leftChild;
        //     }
    
        //     // Check bounds and compare right child
        //     if (rightChild <= currentSize && heap[rightChild].compareTo(heap[smallest]) < 0) {
        //         smallest = rightChild;
        //     }
    
        //     // If the smallest is still the current node, stop
        //     if (smallest == index) {
        //         break;
        //     }
    
        //     // Swap the smallest child with the current node
        //     swap(heap, index, smallest);
        //     index = smallest; // Update index to continue down the tree
        // }

    }

    private void swap(T[] array, int i, int j) {

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}
