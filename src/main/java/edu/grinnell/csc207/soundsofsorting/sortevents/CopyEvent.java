package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;
import java.util.ArrayList;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private final T value;
    private final int index1;

  
    /**
     * Constructs a <code>CopyEvent</code> with the given value and index.
     * 
     * @param value  the value to copy
     * @param index1 the index to copy the value into
     */
    public CopyEvent(T value, int index1) {
        this.value = value;
        this.index1 = index1;
    }
    /**
     * Applies the copy event to the given array.
     * 
     * @param arr the array to modify
     */
    public void apply(T[] arr) {
        arr[index1] = this.value;
    }
    /**
     * Gets the affected indices of the copy event.
     * 
     * @return list of the affected indices
     */
    public List<Integer> getAffectedIndices() {
        List<Integer> affectedIndices = new ArrayList<>();
        affectedIndices.add(index1);
        return affectedIndices;
    }
    /**
     * Returns true if this event should be emphasized by the visualizer/audibilizer.
     * 
     * @return true if this event should be emphasized by the visualizer/audibilizer.
     */
    public boolean isEmphasized() {
        return true;
    }
}