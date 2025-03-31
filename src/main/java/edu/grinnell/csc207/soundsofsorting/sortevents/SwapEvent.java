package edu.grinnell.csc207.soundsofsorting.sortevents;
import java.util.List;
import java.util.ArrayList;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{
  private final int index1;
  private final int index2;

  /**
   * constructs a <code> swap event</code> with the given indices
   * 
   * @param index1 the first index to swap
   * @param index2 the second index to swap
   */

  public SwapEvent(int index1, int index2) {
    this.index1 = index1;
    this.index2 = index2;
  }

  /**
   * apply the swap event to the given array
   * 
   * @param arr the array to swap
   * @Overide
   */

  public void apply(T[] arr) {
    T temporary = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temporary;
  }

  /*
   * get afffected indices of the swap event
   * 
   * @return list of the affected indices
   * 
   * @Override
   */

  public List<Integer> getAffectedIndices() {
    List<Integer> affectedIndices = new ArrayList<>();
    affectedIndices.add(index1);
    affectedIndices.add(index2);
    return affectedIndices;
  }

  /**
   * return true if this event should be emphasized by the visualizer/audibilizer.
   * 
   * @return true if this event should be emphasized by the
   *         visualizer/audibilizer.
   * @overide
   */

  public boolean isEmphasized() {
    return true;
  }

}
