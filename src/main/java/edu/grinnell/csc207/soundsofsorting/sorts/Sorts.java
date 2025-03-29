package edu.grinnell.csc207.soundsofsorting.sorts;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Array;


import edu.grinnell.csc207.soundsofsorting.sortevents.CompareEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.CopyEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SwapEvent;

/**
 * A collection of sorting algorithms.
 */
public class Sorts {
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i   the first index to swap
     * @param j   the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * 
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> bubbleSort(T[] arr) {
        int i;
        int j;
        List<SortEvent<Integer>> events = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                events.add(new CompareEvent(j, j + 1));
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    events.add(new SwapEvent(arr, j, j + 1));
                    swap(arr, j, j + 1);
                }
            }
        }
        return events;
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * 
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> selectionSort(
            T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int lowestIdx = i;
            for (int j = i; j < arr.length; j++) {
                events.add(new CompareEvent<>(j, lowestIdx));
                if (arr[j].compareTo(arr[lowestIdx]) < 0) {
                    lowestIdx = j;
                }
            }
            if (lowestInx != i) {
                events.add(new SwapEvent<>(arr, i, LowestIdx));
                swap(arr, i, lowestIdx);
            }
        }
        return events;
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * 
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> insertionSort(
            T[] arr) {
        List<SortEvent<Integer>> events = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                events.add(new compareEvent<>(arr, j, j - 1));
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    events.add(new SwapEvent<>(arr, j, j - 1));
                    swap(arr, j, j - 1);
                }
            }
        }
        return events;
    }
    
    public class MergeSort {
    
        /**
         * Sorts the array according to the merge sort algorithm.
         * 
         * @param <T> the carrier type of the array
         * @param arr the array to sort
         * @param l the left index
         * @param m the middle index
         * @param r the right index
         */
        public static <T extends Comparable<? super T>> void merge(T[] arr, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
    
            // Use Array.newInstance to create generic arrays
            T[] L = (T[]) Array.newInstance(arr.getClass().getComponentType(), n1);
            T[] R = (T[]) Array.newInstance(arr.getClass().getComponentType(), n2);
    
            // Copy data to temp arrays
            for (int i = 0; i < n1; ++i)
            events.add(new copyEvent<>(L, i, arr[l + i]));
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
            events.add(new copyEvent<>(R, j, arr[m + 1 + j]));
                R[j] = arr[m + 1 + j];
    
            // Merge the temp arrays
            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                events.add(new CompareEvent<>(l + i, m + 1 + j));
                if (L[i].compareTo(R[j]) <= 0) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
    
            // Copy remaining elements of L[] if any
            while (i < n1) {
                events.add(new CopyEvent<>(L, i, arr[k]));
                arr[k] = L[i];
                i++;
                k++;
            }
    
            // Copy remaining elements of R[] if any
            while (j < n2) {
                events.add(new CopyEvent<>(R, j, arr[k]));
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    
        /**
         * Merge sort method that sorts the array and returns a list of SortEvents.
         * 
         * @param <T> the type of elements in the array
         * @param arr the array to sort
         * @return the list of sort events
         */
        public static <T extends Comparable<? super T>> List<SortEvent<Integer>> mergeSort(T[] arr) {
            List<SortEvent<Integer>> events = new ArrayList<>();
            sort(arr, 0, arr.length - 1);
            return events;
        }
    
        /**
         * Recursive method that sorts arr[l..r] using merge sort.
         * 
         * @param <T> the type of elements in the array
         * @param arr the array to sort
         * @param l the left index
         * @param r the right index
         */
    public static <T extends Comparable<? super T>> void sort(T[] arr, int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;
                sort(arr, l, m);
                sort(arr, m + 1, r);
    
                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }
    }
    

    /**
     * Sorts the array according to the quick sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<Integer>> quickSort(T[] arr) {
        int l = 0;
        int r = arr.length - 1;
        List<SortEvent<Integer>> events = new ArrayList<>();
        if (l >= r) {
            return events;
            ;
        }
        T pivot = arr[l + (r - l) / 2];
        int i = l, j = r;

        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) {
                i++;
            }
            while (arr[i].compareTo(pivot) < 0) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (l < j) {
            quickSort(arr);
        }

        if (i < r) {
            quickSort(arr);
        }
    }
}
