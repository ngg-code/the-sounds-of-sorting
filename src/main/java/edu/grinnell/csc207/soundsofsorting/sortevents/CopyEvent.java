package edu.grinnell.csc207.soundsofsorting.sortevents;
import java.util.List;
import java.util.ArrayList;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> {
    public int index;
    public T value;

    public CopyEvent(int idx, T val) {
        index = idx;
        value = val;
    }

    public void apply(T[] arr) {
        arr[index] = value;
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> affectedIndices = new ArrayList<>();
        affectedIndices.add(index);
        return affectedIndices;
    }

    public boolean isEmphasized() {
        return true;
    }
}
