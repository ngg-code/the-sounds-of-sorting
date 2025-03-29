package edu.grinnell.csc207.soundsofsorting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private List<Integer> indices;
    private boolean[] highlighted;

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

        indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        // Shuffle the indices to start with a random order
        Collections.shuffle(indices, new Random());
        highlighted = new boolean[n];
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {
        return indices.toArray(new Integer[0]);
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

    public Color getColor(int index) {
        if (isHighlighted(index)) {
            // If the note is highlighted, return a different color
            return Color.red; // Highlighted color
        } else {
            // Otherwise, return a default color
            return Color.blue; // Default color for notes
        }
    }
}
