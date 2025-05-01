package edu.grinnell.csc207.soundsofsorting;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    public NoteIndices notes;

    /**
     * Create a new ArrayPanel with the given notes and dimensions.
     * 
     * @param notes  the note indices
     * @param width  the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * paintComponent is called whenever the panel needs to be redrawn.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        Integer[] indices = this.notes.getNotes();
        int width = getWidth() / indices.length;
        int height = getHeight() / indices.length;
        for (int i = 0; i < indices.length; i++) {
            g.setColor(notes.getColor(i));
            g.fillRect(i * width,
                    getHeight() - notes.getNote(i) * height, width, notes.getNote(i) * height);
        }
    }
}