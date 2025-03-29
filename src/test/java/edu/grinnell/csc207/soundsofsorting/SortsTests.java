package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
                3, 7, 9, 1, 2,
                18, 16, 15, 19, 8,
                14, 12, 5, 13, 4,
                6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
        Integer[] arr1 = { 5, 2, 9, 1, 5, 6 };
        List<SortEvent<Integer>> events1 = Sorts.bubbleSort(arr1);
        assertArrayEquals(new Integer[] { 1, 2, 5, 5, 6, 9 }, arr1);

        Integer[] arr2 = { 3, 3, 3, 3 };
        List<SortEvent<Integer>> events2 = Sorts.bubbleSort(arr2);
        assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, arr2);

        Integer[] arr3 = { 1, 2, 3, 4, 5 };
        List<SortEvent<Integer>> events3 = Sorts.bubbleSort(arr3);
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr3);

        Integer[] arr4 = {};
        List<SortEvent<Integer>> events4 = Sorts.bubbleSort(arr4);
        assertArrayEquals(new Integer[] {}, arr4);

        Integer[] arr5 = { 100 };
        List<SortEvent<Integer>> events5 = Sorts.bubbleSort(arr5);
        assertArrayEquals(new Integer[] { 100 }, arr5);
    }

    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
        Integer[] arr1 = { 5, 2, 9, 1, 5, 6 };
        List<SortEvent<Integer>> events1 = Sorts.insertionSort(arr1);
        assertArrayEquals(new Integer[] { 1, 2, 5, 5, 6, 9 }, arr1);

        Integer[] arr2 = { 3, 3, 3, 3 };
        List<SortEvent<Integer>> events2 = Sorts.insertionSort(arr2);
        assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, arr2);

        Integer[] arr3 = { 1, 2, 3, 4, 5 };
        List<SortEvent<Integer>> events3 = Sorts.insertionSort(arr3);
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr3);

        Integer[] arr4 = {};
        List<SortEvent<Integer>> events4 = Sorts.insertionSort(arr4);
        assertArrayEquals(new Integer[] {}, arr4);

        Integer[] arr5 = { 100 };
        List<SortEvent<Integer>> events5 = Sorts.insertionSort(arr5);
        assertArrayEquals(new Integer[] { 100 }, arr5);

    }

    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
        Integer[] arr1 = { 5, 2, 9, 1, 5, 6 };
        List<SortEvent<Integer>> events1 = Sorts.selectionSort(arr1);
        assertArrayEquals(new Integer[] { 1, 2, 5, 5, 6, 9 }, arr1);

        Integer[] arr2 = { 3, 3, 3, 3 };
        List<SortEvent<Integer>> events2 = Sorts.selectionSort(arr2);
        assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, arr2);

        Integer[] arr3 = { 1, 2, 3, 4, 5 };
        List<SortEvent<Integer>> events3 = Sorts.selectionSort(arr3);
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr3);

        Integer[] arr4 = {};
        List<SortEvent<Integer>> events4 = Sorts.selectionSort(arr4);
        assertArrayEquals(new Integer[] {}, arr4);

        Integer[] arr5 = { 100 };
        List<SortEvent<Integer>> events5 = Sorts.selectionSort(arr5);
        assertArrayEquals(new Integer[] { 100 }, arr5);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
        Integer[] arr1 = { 5, 2, 9, 1, 5, 6 };
        List<SortEvent<Integer>> events1 = Sorts.mergeSort(arr1);
        assertArrayEquals(new Integer[] { 1, 2, 5, 5, 6, 9 }, arr1);

        Integer[] arr2 = { 3, 3, 3, 3 };
        List<SortEvent<Integer>> events2 = Sorts.mergeSort(arr2);
        assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, arr2);

        Integer[] arr3 = { 1, 2, 3, 4, 5 };
        List<SortEvent<Integer>> events3 = Sorts.mergeSort(arr3);
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr3);

        Integer[] arr4 = {};
        List<SortEvent<Integer>> events4 = Sorts.mergeSort(arr4);
        assertArrayEquals(new Integer[] {}, arr4);

        Integer[] arr5 = { 100 };
        List<SortEvent<Integer>> events5 = Sorts.mergeSort(arr5);
        assertArrayEquals(new Integer[] { 100 }, arr5);
    }

    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
        Integer[] arr1 = { 5, 2, 9, 1, 5, 6 };
        List<SortEvent<Integer>> events1 = Sorts.quickSort(arr1);
        assertArrayEquals(new Integer[] { 1, 2, 5, 5, 6, 9 }, arr1);

        Integer[] arr2 = { 3, 3, 3, 3 };
        List<SortEvent<Integer>> events2 = Sorts.quickSort(arr2);
        assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, arr2);

        Integer[] arr3 = { 1, 2, 3, 4, 5 };
        List<SortEvent<Integer>> events3 = Sorts.quickSort(arr3);
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, arr3);

        Integer[] arr4 = {};
        List<SortEvent<Integer>> events4 = Sorts.quickSort(arr4);
        assertArrayEquals(new Integer[] {}, arr4);

        Integer[] arr5 = { 100 };
        List<SortEvent<Integer>> events5 = Sorts.quickSort(arr5);
        assertArrayEquals(new Integer[] { 100 }, arr5);
    }
}