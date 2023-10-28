package application;

import java.util.Arrays;
import java.util.Comparator;

public class Utility {

    // Bubble sort for arrays of Comparable elements
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        int x = array.length;
        if (x == 0)
            return;

        long start, stop;

        start = System.currentTimeMillis();

        for (int i = 0; i < x - 1; i++) {
            for (int j = 0; j < x - 1 - i; j++) {
                int res = array[j].compareTo(array[i + 1]);
                if (res < 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        stop = System.currentTimeMillis(); 
        System.out.println("Time complexity of bubble sort: " + (stop - start));
    }

    // Bubble sort for arrays with a custom Comparator
    public static <T> void bubbleSort(T[] array, Comparator<? super T> c) {
        int x = array.length;
        long start, stop;

        start = System.currentTimeMillis();
        for (int i = 0; i < x - 1; i++) {
            for (int j = 0; j < x - 1 - i; j++) {
                int res = c.compare(array[j], array[j + 1]);
                if (res < 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        stop = System.currentTimeMillis();
        System.out.println("Time complexity of bubble sort with custom comparator: " + (stop - start));
    }

    // Selection sort for arrays of Comparable elements
    public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
        int n = array.length;
        if (n == 0)
            return;

        long start, stop;

        start = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (array[j].compareTo(array[min_idx]) < 0)
                    min_idx = j;

            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }

        stop = System.currentTimeMillis();
        System.out.println("Time complexity of selection sort: " + (stop - start));
    }

    // Selection sort for arrays with a custom Comparator
    public static <T> void selectionSort(T[] array, Comparator<? super T> c) {
        int n = array.length;
        long start, stop;

        start = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (c.compare(array[j], array[min_idx]) < 0)
                    min_idx = j;

            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }

        stop = System.currentTimeMillis();
        System.out.println("Time complexity of selection sort with custom comparator: " + (stop - start));
    }

    // Insertion sort for arrays of Comparable elements
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    T tempVal;
                    tempVal = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tempVal;
                } else {
                    break;
                }
            }
        }
    }

    // Insertion sort for arrays with a custom Comparator
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr, Comparator<? super T> c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (c.compare(arr[j], arr[j + 1]) < 0) {
                    T tempVal;
                    tempVal = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tempVal;
                } else {
                    break;
                }
            }
        }
    }

    // Heap sort for arrays of Comparable elements
    public static <T extends Comparable<? super T>> void heapSort(T[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // Helper function to maintain the max heap property
    static <T extends Comparable<? super T>> void heapify(T[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T tempVal = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tempVal;

            heapify(arr, n, largest);
        }
    }

    // Heap sort for arrays with a custom Comparator
    public static <T> void heapSort(T[] arr, Comparator<? super T> c) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, c);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, c);
        }
    }

    // Helper function to maintain the max heap property
    static <T> void heapify(T[] arr, int n, int i, Comparator<? super T> c) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && c.compare(arr[left], arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && c.compare(arr[right], arr[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T tempVal = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tempVal;

            heapify(arr, n, largest, c);
        }
    }

    // Merge sort for arrays of Comparable elements
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            mergeSort(arr, firstIndex, mid);
            mergeSort(arr, mid + 1, lastIndex);

            merg(arr, firstIndex, mid, lastIndex);
        }
    }

    // A method to merge two halves of an array
    static <T extends Comparable<? super T>> void merg(T[] arr, int firstIndex, int middle, int lastIndex) {
        // Create left and right temporary arrays
        T[] leftArray = Arrays.copyOfRange(arr, firstIndex, middle + 1);
        T[] rightArray = Arrays.copyOfRange(arr, middle + 1, lastIndex + 1);

        // Merge the left and right arrays
        int i = 0, j = 0, k = firstIndex;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }

    // Merge sort for arrays of elements with a custom Comparator
    public static <T extends Comparable<? super T>> void mergSort(T[] arr, int firstIndex, int lastIndex,
            Comparator<? super T> c) {
        if (firstIndex == lastIndex)
            return;

        if (firstIndex < lastIndex) {
            if (lastIndex - firstIndex < 1) {
                int middle = (firstIndex + lastIndex) / 2;

                mergSort(arr, firstIndex, middle, c);
                mergSort(arr, middle + 1, lastIndex, c);

                merg(arr, firstIndex, middle, lastIndex, c);
            }
        }

    }

    // Merge two halves of an array using a custom Comparator
    static <T> void merg(T[] arr, int firstIndex, int middle, int lastIndex, Comparator<? super T> c) {
        // Create left and right temporary arrays
        T[] leftArray = Arrays.copyOfRange(arr, firstIndex, middle + 1);
        T[] rightArray = Arrays.copyOfRange(arr, middle + 1, lastIndex + 1);

        // Merge the left and right arrays
        int i = 0, j = 0, k = firstIndex;
        while (i < leftArray.length && j < rightArray.length) {
            if (c.compare(leftArray[i], rightArray[j]) <= 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }

    // Quick sort for arrays of Comparable elements
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Recursive quick sort method
    public static <T extends Comparable<? super T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);

            quickSort(arr, low, index - 1);
            quickSort(arr, index + 2, high);
        }
    }

    // Partitioning the array
    public static <T extends Comparable<? super T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) > 0) {
                T tempVal = arr[j];
                arr[j] = arr[i];
                arr[i] = tempVal;
            }
        }

        T tempVal = arr[i];
        arr[i] = arr[high];
        arr[high] = tempVal;

        return i; 
    }

    // Quick sort with a custom Comparator
    public static <T extends Comparable<? super T>> void quicksort(T[] arr, Comparator<? super T> c) {
        quicksort(arr, 0, arr.length - 1, c);
    }

    // Recursive Quick sort method with a custom Comparator
    public static <T extends Comparable<? super T>> void quicksort(T[] arr, int low, int high,
            Comparator<? super T> c) {
        if (low < high) {
            int index = partition(arr, low, high, c);
            quicksort(arr, low, index - 1, c);
            quicksort(arr, index + 1, high, c);
        }
    }

    // Partitioning the array with a custom comparator
    public static <T extends Comparable<? super T>> int partition(T[] arr, int low, int high, Comparator<? super T> c) {
        T pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (c.compare(arr[j], pivot) > 0) {
                T tempValue = arr[j];
                arr[j] = arr[i];
                arr[i] = tempValue;
                i++;
            }
        }
        T tempValue = arr[i];
        arr[i] = arr[high];
        arr[high] = tempValue;
        return i;
    }
}