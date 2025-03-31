package edu.grinnell.csc207.soundsofsorting.sortevents;
import java.util.List;
import java.util.ArrayList;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    private final int index1;
    private final int index2;
    public T[] arr;

    public CopyEvent(int idx1, int idx2) {
        this.index1 = idx1;
        this.index2 = idx2;
    }


    public void apply(T[] arr) {
        arr[index1] =  arr[index2];
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> affectedIndices = new ArrayList<>();
        affectedIndices.add(index1);
        affectedIndices.add(index2);
        return affectedIndices;
    }

    public boolean isEmphasized() {
        return true;
    }
}
