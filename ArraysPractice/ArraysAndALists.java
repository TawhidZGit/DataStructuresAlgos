package ArraysPractice;

import java.util.Collections;

import java.util.ArrayList;


public class ArraysAndALists {

    public static void main(String[] args) {
        // Example usage of the methods
        // int[] arr = { 1, 2, 3, 4, 5 };
        // System.out.print("Before reverse: ");
        // displayArray(arr);
        // System.out.println("Sum: " + sum(arr));
        // System.out.println("Max: " + max(arr));
        // System.out.println("Min: " + min(arr));
        // System.out.println("Search for 3: " + search(arr, 3));
        // System.out.println("Search for 6: " + search(arr, 6));
        // System.out.print("After reverse: ");
        // reverseArray(arr);
        // displayArray(arr);
        // reverseArray(arr);
        // System.out.println("Shift left by 2: ");
        // shift(arr, -2);
        // displayArray(arr);
        // System.out.println("Shift right by 3: ");
        // shift(arr, 1);
        // displayArray(arr);

        ArrayList<String> aListS = new ArrayList<>();
      //  ArrayList<Integer> aListI = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      //  List<Integer> listI = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));
       // List<Integer> listI2 = Arrays.asList(2, 4, 6, 8);

        aListS.add("Strong");
        aListS.add("Person");
        aListS.add("Baby");
        Collections.addAll(aListS, "OKay", "Cash", "We");
        System.out.println(aListS);
        aListS.remove("OKay");
        aListS.remove(0);
        System.out.println(aListS);
        



    }

    public static void displayArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }

        }

    }

    public static void reverseArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }

    }

    public static int max(int[] arr) {

        int max = arr[0];
        for (int num : arr) {

            if (num > max) {

                max = num;
            }

        }

        return max;

    }

    public static int min(int[] arr) {

        int min = arr[0];
        for (int num : arr) {

            if (num < min) {

                min = num;

            }

        }

        return min;

    }

    public static int sum(int[] arr) {

        int sum = 0;
        for (int num : arr) {

            sum += num;

        }

        return sum;

    }

    /**
     * Searches for key within array and returns index
     **/
    public static int search(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {

                return i;
            }

        }

        return -1;

    }

    // Yeah this dont work
    public static void shift(int[] arr, int shift) {

        int indexToChange = 0; // Index to change
        int changeWith = arr[0]; // Value to change with
        int tempHolding = arr[0]; // Temporary variable to capture the value to be changed with because we will
                                  // lose
        // Everytime we change the value of the index to be changed, we need to store
        // the value TO BE CHANGED,
        // so we can use it to change the value in the next iteration since we are
        // rotating (shifting) the values in the array,
        // but we cant use that same variable to change the value of the index to be
        // changed
        // because we will lose the value of the index to be changed
        // As a result, we need to store the value of the index to be changed in a
        // second temporary variable
        // So we need a variable hold the values that will be changed so we can use it
        // for the next iteration
        // and another varibale to change the value of the index to be changed and this
        // variable will get this value from the holding variable
        for (int i = 0; i < arr.length; i++) {

            changeWith = tempHolding;
            indexToChange = ((indexToChange + shift) % arr.length + arr.length) % arr.length; // Calculate the index to
                                                                                              // change and ensure it's
                                                                                              // within bounds storing
                                                                                              // the value to be changed
            tempHolding = arr[indexToChange]; // Capture the value to be changed
            arr[indexToChange] = changeWith;
            if (i == (arr.length / 2) && arr.length % 2 == 0 && shift % 2 == 0) {
                // So we are basically checking if the array length is even and if the shift is
                // even
                // because if this is the case it means we will enter a loop
                // once we have made half the iterations of the actual lenght of the array we
                // incement the indexToChange by 1 so we can break out of the loop

                indexToChange++;
            }

        }

    }

    /**
     * Rotates the array by the given shift amount. A positive shift rotates to the
     * right, and a negative shift rotates to the left.
     * 
     * We have to reverse the entire array first, then reverse the first k
     * elements, and finally reverse the last n-k elements.
     * This is a more efficient way to rotate the array in O(n) time complexity.
     * 
     * @param arr   The array to rotate.
     * @param shift The amount to shift (positive for right, negative for left).
     */
    public static void rotate(int[] arr, int shift) {

        if (arr == null || arr.length <= 1 || shift == 0)
            return;

        shift = ((shift % arr.length) + arr.length) % arr.length;
        reverseSubsection(arr, 0, arr.length - 1);
        reverseSubsection(arr, 0, shift - 1);
        reverseSubsection(arr, shift, arr.length - 1);

    }

    public static void rotateLeft(int[] arr, int shift) {
        rotate(arr, -shift); // reuse your existing method
    }

    public static void rotateRight(int[] arr, int shift) {
        rotate(arr, shift);
    }

    public static void reverseSubsection(int[] arr, int left, int right) {

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }

    }

    public static int[] merge(int[] arr, int[] arr2) {

        int mergedArrLength = arr.length + arr2.length;
        int mergedArr[] = new int[mergedArrLength];

        if (arr[0] < arr2[0]) {

            for (int i = 0; i < arr.length; i++) {

                mergedArr[i] = arr[i];

            }

            for (int i = 0; i < arr2.length; i++) {

                mergedArr[i + arr.length] = arr2[i];

            }

        } else {

            for (int i = 0; i < arr2.length; i++) {

                mergedArr[i] = arr2[i];

            }

            for (int i = 0; i < arr.length; i++) {

                mergedArr[i + arr2.length] = arr[i];

            }

        }

        return mergedArr;
    }

    public static boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < arr[i - 1]) {

                return false;

            }

        }

        return true;
    }

    public static boolean isSortedAscOrDesc(int[] arr, boolean isAscending) {

        for (int i = 1; i < arr.length; i++) {

            if (isAscending && arr[i] < arr[i - 1])
                return false;
            if (!isAscending && arr[i] > arr[i - 1])
                return false;

        }
        return true;

    }

    /**
     * Removes the first occurrence of the specified key from the array.
     * Shfits the elements to the left and fills the last position with 0.
     * 
     * @param arr The array to modify.
     * @param key The key to remove.
     */
    public static void removeElementFirstOccurence(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {

                for (int j = i; j < arr.length - 1; j++) {

                    arr[j] = arr[j + 1];

                }

                arr[arr.length - 1] = 0;

                return;
            }

        }

    }

    public static int removeElement(int[] arr, int key) {

        int newLen = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != key) {

                arr[newLen++] = arr[i];

            }

        }

        for (int i = newLen; i < arr.length; i++) {

            arr[i] = 0;
        }

        return newLen;

    }

    public static int[] shift2(int[] arr, int shift) {

        int[] shiftedArr = new int[arr.length];
        shift = ((shift % arr.length) + arr.length) % arr.length;
        for (int i = shift; i < arr.length; i++) {

            shiftedArr[i] = arr[arr.length - shift + i];

        }

        for (int i = arr.length - shift; i < shift; i++) {

            shiftedArr[i] = arr[i - shift];

        }

        return shiftedArr;

    }

}
