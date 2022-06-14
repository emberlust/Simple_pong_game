package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class Player extends JPanel{
    private final Dimension size = new Dimension(20,80);

    public Player()
    {
        this.init();
    }

    private void init()
    {
        this.setBackground(Color.white);
        this.setSize(size);
        this.setLocation(1,1);
    }
}