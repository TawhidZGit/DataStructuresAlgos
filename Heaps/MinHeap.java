package Heaps;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>>{

	private T[] heap;
	private int size;

	public MinHeap(int capacity){

		this.heap = (T[]) new Comparable[capacity];

	}

    public MinHeap(){

        this(10); // Default capacity of 10
    }

    public MinHeap(T[] array){

        heap = Arrays.copyOf(array, array.length * 2);
        size = array.length;
        for(int i = (size - 1) / 2; i >= 0; i--){

            heapifyDown(i);
        }
        
    }

	public boolean isEmpty(){return size == 0;}

	private boolean isFull(){return size == heap.length;}

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

		T min = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heapifyDown(0);
		return min;
	}

	private void heapifyUp(int index){

		int parent = (index - 1) / 2;
		while(index > 0 && heap[index].compareTo(heap[parent]) < 0){

			swap(index, parent);
			index = parent;
 
		}
	}

	private void heapifyDown(int index){


		while(index < size){

			int left = 2 * index + 1;
			int right = 2 * index + 2;
			int smallest = index;

			if( left < size && heap[left].compareTo(heap[smallest]) < 0){

				smallest = left;

			}

			if(right < size && heap[right].compareTo(heap[smallest]) < 0){
				smallest = right;
			}

			if(smallest != index){

				swap(index, smallest);
			} else{
				break;
			}

		}


	}

	private void swap(int i, int j){

		T temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void resize(){

		T[] newHeap = (T[]) new Comparable[heap.length * 2];
		System.arraycopy(heap, 0, newHeap, 0, size);
		heap = newHeap;

	}

	public void printHeap(){

		System.out.println("Heap: ");
		for(int i = 0; i < size; i++){

			System.out.print(heap[i] + " ");
		}

		System.out.println();

	}

}