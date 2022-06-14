package gui;

import java.awt.Color;

import javax.swing.JPanel;

public class Ball extends JPanel{
    
    public Ball()
    {
        this.init();
    }

    private void init()
    {
        this.setSize(20,20);
        this.setBackground(Color.white);
        this.setLocation(1, 1);
    }
}
