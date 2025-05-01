package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;
import java.util.ArrayList;

/**
 * A CompareEvent logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private final int index1;
    private final int index2;

    public CompareEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    /**
     * Applies the compare event to the given array
     *
     * @param arr the array to compare
     */
    public void apply(T[] arr) {
    }

    /**
     * Get affected indices of the compare event
     *
     * @return list of the affected indices
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> affectedIndices = new ArrayList<>();
        affectedIndices.add(index1);
        affectedIndices.add(index2);
        return affectedIndices;
    }

    /**
     * Return true if this event should be emphasized by the visualizer/audibilizer.
     *
     * @return true if this event should be emphasized by the
     *         visualizer/audibilizer.
     */
    public boolean isEmphasized() {
        return false;
    }
}