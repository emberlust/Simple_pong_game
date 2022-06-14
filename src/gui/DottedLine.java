package gui;

import java.awt.Component;

import java.awt.Color;
import java.awt.Graphics;

public class DottedLine extends Component {
    
    public DottedLine()
    {

    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        for(int i = 0; i <= 600; i+= 600/ 10)
        {
            g.fillRect(397, i, 6, 60);
            i += 20;
        }
    }
}
