package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;
import java.util.ArrayList;

/**
 * A CopyEvent logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private final int index1;
    private final int index2;

    /**
     * Constructs a CopyEvent with the given indices
     * 
     * @param idx1 the index to copy into
     * @param idx2 the index to copy from
     */
    public CopyEvent(int idx1, int idx2) {
        this.index1 = idx1;
        this.index2 = idx2;
    }

    /**
     * Applies the copy event to the given array
     * 
     * @param arr the array to copy into
     */
    public void apply(T[] arr) {
        arr[index1] = arr[index2];
    }

    /**
     * Get affected indices of the copy event
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
        return true;
    }
}