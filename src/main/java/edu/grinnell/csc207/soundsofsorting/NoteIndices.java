package edu.grinnell.csc207.soundsofsorting;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private Integer[] indices;
    private boolean[] highlighted;
    private int size;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * 
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        this.indices = new Integer[n];
        this.highlighted = new boolean[n];
        this.size = n;
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        ArrayList<Integer> indicesList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            indicesList.add(i);
        }
        // Shuffle the indices to start with a random order
        Collections.shuffle(indicesList, new Random());
        for (int i = 0; i < n; i++) {
            indices[i] = indicesList.get(i);
        }
        for (int i = 0; i < highlighted.length; i++) {
            highlighted[i] = false;
        }
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {
        Integer[] notes1 = new Integer[size];
        for (int i = 0; i < size; i++) {
            notes1[i] = indices[i];
        }
        return notes1;
    }

    public int getNote(int index) {
        if (index >= 0 && index < size) {
            return indices[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Sets the value at the specified index
     * 
     * @param index the index to update
     * @param value the new value to set
     */
    public void setNote(int index, int value) {
        if (index >= 0 && index < size) {
            indices[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Highlights the given index of the note array
     * 
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        if (index >= 0 && index < highlighted.length) {
            highlighted[index] = true;
        }
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return index >= 0 && index < highlighted.length && highlighted[index];
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i = 0; i < highlighted.length; i++) {
            highlighted[i] = false;
        }
    }

    public int getMaxValue() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (indices[i] > max) {
                max = indices[i];
            }
        }
        return max;
    }

    public Color getColor(int index) {
        if (isHighlighted(index)) {
            // If the note is highlighted, return a different color
            return Color.red; // Highlighted color
        } else {
            int value = indices[index];
            int max = getMaxValue();

            // Normalize to [0, 1]
            float ratio = (float) value / max;

            // Interpolate from green (low) to blue (high)
            int red = 0;
            int green = (int) ((1 - ratio) * 180); // Bright green when small
            int blue = (int) (ratio * 255); // Bright blue when large

            return new Color(red, green, blue);
        }
    }

    public int size() {
        return size;
    }

}