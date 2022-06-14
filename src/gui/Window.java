package gui;

import java.awt.Dimension;
import java.time.Instant;
import java.time.Duration;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import data.BallEngine;
import data.SimplerPlayerEngine;

import java.awt.Color;

public class Window {
    private JFrame main_window;
    private Player p1;
    private Player p2;
    private Ball ball;
    private BallEngine be;

    private Instant start;

    private static final Dimension w_size = new Dimension(800,600);

    public Window()
    {
        this.init();
    }

    private void init()
    {
        this.main_window = new JFrame();
        this.main_window.setLayout(null);
        this.main_window.setMinimumSize(w_size);
        this.main_window.setTitle("Pong Game");
        this.main_window.getContentPane().setBackground(Color.black);
        this.main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.main_window.setVisible(true);

        this.p1 = new Player();
        this.p1.setLocation(130,220);
        this.p2 = new Player();
        this.p2.setLocation(800-130, 220);
        this.ball = new Ball();
        this.ball.setLocation(380, 280);

        this.main_window.add(this.ball,0);
        this.main_window.add(this.p1,0);
        this.main_window.add(this.p2,0);

        DottedLine dt = new DottedLine();
        dt.setSize(800,600);
        dt.setLocation(0,0);

        this.main_window.add(dt,0);

        this.main_window.repaint();


    }

    public void start()
    {
        this.ball.setLocation(380, 280);
        this.p1.setLocation(130,220);
        this.p2.setLocation(800-130, 220);
        be = new BallEngine();

        SimplerPlayerEngine pe = new SimplerPlayerEngine();
        pe.set_cY(p2.getLocation().y);

        be.set_initial(2, 1, this.ball.getLocation().x, this.ball.getLocation().y);
        start = Instant.now();

        this.main_window.addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if(keyCode == KeyEvent.VK_UP && p1.getLocation().y > 0)
                {
                    p1.setLocation(p1.getLocation().x, p1.getLocation().y - 5);
                }
                if(keyCode == KeyEvent.VK_DOWN && p1.getLocation().y + 120 < 600)
                {
                    p1.setLocation(p1.getLocation().x, p1.getLocation().y + 5);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });

        while(true)
        {
            this.game_step();
            pe.go_to(this.ball.getLocation().y - 20);
            this.p2.setLocation(this.p2.getLocation().x, pe.get_cY());
        }
    }

    public void game_step()
    {
        Instant end = Instant.now();
        if(Duration.between(start, end).toMillis() < 7) {
            return;
        }

        start = end;
        this.be.move();
        this.be.check_p1(this.p1.getLocation().x, this.p1.getLocation().y, 80, 20);
        this.be.check_p2(this.p2.getLocation().x, this.p2.getLocation().y, 80, 20);
        this.be.check_bounds();

        if(this.be.point(this.p1.getLocation().x, this.p2.getLocation().x) != 0)
        {
            this.start();
        }

        this.ball.setLocation((int)be.get_cX(),(int)be.get_cY());
    }

}
