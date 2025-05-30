package SortingAlgorithms;

public class SortingAlgos {

    public static <T extends Comparable<T>> void bubbleSortAsc(T[] array) {

        if (!(array.length > 1)) {

            return;
        }

        int n = array.length;
        boolean anySwaps;
        do {
            anySwaps = false;
            for (int i = 1; i < n; i++) {

                int j = i - 1;

                if (array[j].compareTo(array[i]) > 0) {

                    swap(array, j, i);
                    anySwaps = true;

                }
            }
            n--;
        } while (anySwaps);

    }

    public static <T extends Comparable<T>> void bubbleSortDesc(T[] array) {

        if (!(array.length > 1)) {

            return;
        }

        int n = array.length;
        boolean anySwaps;
        do {
            anySwaps = false;
            for (int i = 1; i < n; i++) {

                int j = i - 1;

                if (array[j].compareTo(array[i]) < 0) {

                    swap(array, j, i);
                    anySwaps = true;

                }
            }
            n--;
        } while (anySwaps);

    }

    public static <T extends Comparable<T>> void insertionSortAsc(T[] array) {

        for (int i = 1; i < array.length; i++) {
            T currentValue = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(currentValue) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentValue;
        }
    }

    // I made this, but was confused at first how the insertionSort algo worked
    // This is not really following the isnertionSort Algorithm logic because it is
    // making constant swaps between the elemtns
    // and in insertionSort your supposed to keep shifting the element that is less
    // (or greater) than the value you are comparing with
    public static <T extends Comparable<T>> void insertionSortAscV2(T[] array) {

        for (int i = 1; i < array.length; i++) {

            for (int j = i; j > 0; j--) {

                int k = j - 1;
                if (array[k].compareTo(array[j]) > 0) {

                    swap(array, k, j);

                } else {

                    break;
                }

            }

        }

    }

    public static <T extends Comparable<T>> void selectionSort(T[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int smallestIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[smallestIndex].compareTo(array[j]) > 0) {

                    smallestIndex = j;

                }

            }

            swap(array, i, smallestIndex);

        }

    }

    public static <T extends Comparable<T>> void mergeSort(T[] array) {

        int arrayLength = array.length;
        if (arrayLength < 2) {

            return;
        }

        int midIndex = arrayLength / 2;

        T[] leftHalf = (T[]) new Comparable[midIndex];

        T[] rightHalf = (T[]) new Comparable[arrayLength - midIndex];

        // for(int i = 0; i < midIndex; i++){

        // leftHalf[i] = array[i];
        // rightHalf[i] = array[i + (arrayLength - midIndex)];

        // }

        for (int i = 0; i < midIndex; i++) {

            leftHalf[i] = array[i];

        }
        for (int i = midIndex; i < arrayLength; i++) {

            rightHalf[i - midIndex] = array[i];

        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(array, leftHalf, rightHalf);

    }

    // conventional code
    private static <T extends Comparable<T>> void merge(T[] array, T[] leftHalf, T[] rightHalf) {

        int i = 0, l = 0, r = 0;

        while (l < leftHalf.length && r < rightHalf.length) {

            if (leftHalf[l].compareTo(rightHalf[r]) < 0) {

                array[i++] = leftHalf[l++];

            } else {

                array[i++] = rightHalf[r++];

            }

        }

        while (l < leftHalf.length) {

            array[i++] = leftHalf[l++];

        }

        while (r < rightHalf.length) {

            array[i++] = rightHalf[r++];

        }

    }

    // my code i wrote, i think its not workin at the moment
    private static <T extends Comparable<T>> void mergeV2(T[] array, T[] leftHalf, T[] rightHalf) {

        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;
        int l = 0;
        int r = 0;

        for (int i = 0; i < array.length; i++) {

            if (l == leftLength) {
                array[i] = rightHalf[r];
                break;

            } else if (r == rightLength) {
                array[i] = leftHalf[l];
                break;

            }

            if (leftHalf[l].compareTo(rightHalf[r]) < 0) {

                array[i] = leftHalf[l];
                l++;

            } else {

                array[i] = rightHalf[r];
                r++;

            }

        }

    }

    public static <T extends Comparable<T>> void quickSort(T[] array) {

        quickSort(array, 0, array.length - 1);

    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex, high);
        }

    }

    public static <T extends Comparable<T>> int partition(T[] array, int low, int high) {

        int pivotIndex = high;
        T pivot = array[pivotIndex];

        int i = 0;
        while (i < high && low < high) {

            if (array[i].compareTo(pivot) > 0) {

                swap(array, i, high--);
                if (array[i].equals(pivot)) {

                    i++;
                    continue;
                } else if (array[i].compareTo(pivot) > 0) {
                    continue;

                } else if (array[i].compareTo(pivot) < 0) {

                    swap(array, i++, low++);

                }

            } else if (array[i].compareTo(pivot) < 0) {

                swap(array, i++, low++);

            } else {

                i++;
            }

        }

        pivotIndex = i - 1;
        return pivotIndex;

    }

    private static <T> void swap(T[] array, int i, int j) {

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static <T> void display(T[] array) {

        for (T element : array) {

            System.out.print(element + " ");
        }
        System.out.println();

    }

}