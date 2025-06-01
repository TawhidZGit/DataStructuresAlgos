package Heaps;

public class MaxHeap<T extends Comparable<T>>{


	private T[] heap;
	private int size;


	public MaxHeap(int capacity){

		this.heap = (T[]) new Comparable[capacity];
	}

    public MaxHeap(){

        this(10); // Default capacity of 10
    }
    public MaxHeap(T[] array){

        heap = (T[]) new Comparable[array.length * 2];
        size = array.length;
        System.arraycopy(array, 0, heap, 0, size);
        for(int i = (size - 1) / 2; i >= 0; i--){

            heapifyDown(i);
        }
    }

	public boolean isEmpty(){

		return size == 0;
	}

	private boolean isFull(){


		return size == heap.length;
	}

	public T peek(){

		if(isEmpty())return null;

		return heap[0];
	}

	public void insert(T data){

		if(isFull()) resize();

		heap[size++] = data;

		heapifyUp(size - 1);

	}


	public T poll(){

		if(isEmpty())return null;

		T max = heap[0];
		heap[0] = heap[--size];

		heapifyDown(0);
		return max;
	}


	private void swap(int i, int j){

		T temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void heapifyUp(int index){

		int parent = ( index - 1 ) / 2;
		while(index > 0 && heap[index].compareTo(heap[parent]) > 0){

			swap(index, parent);
			index = parent;
			parent = ( index - 1 ) / 2;

		}
	}

	private void heapifyDown(int index){

		while(index < size){

			int left = index*2 + 1;
			int right = index*2 + 2;
			int largest = index;

			if(left < size && heap[left].compareTo(heap[largest]) > 0){

				largest = left;
			}

			if( right < size && heap[right].compareTo(heap[largest]) > 0){

				largest = right;
			}

			if(largest != index){

				swap(index, largest);
			}  else{
				break;
			}
		}
	}

	private void resize(){

		T[] newHeap = (T[]) new Comparable[heap.length*2];
		System.arraycopy(heap, 0, newHeap, 0, size);
		heap = newHeap;

	}

	public void printHeap(){

		System.out.print("Heap: ");

		for(int   i =0 ; i < size; i++){

			System.out.print(heap[i] + " ");

		}

		System.out.println();

	}
	    
}
