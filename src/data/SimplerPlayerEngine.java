package data;

import java.util.Random;
import java.time.Instant;
import java.time.Duration;

public class SimplerPlayerEngine {
    
    private int cY;
    private Random rd;
    private Instant start;

    public SimplerPlayerEngine()
    {
        rd = new Random();
        start = Instant.now();
    }

    public void set_cY(int y)
    {
        this.cY = y;
    }

    public void go_to(int y)
    {
        Instant end = Instant.now();

        if(Duration.between(this.start, end).toMillis() < 7)
        {
            return;
        }

        if(this.cY < y && this.cY + 120 < 600)
        {
            if(this.cY > 0 && rd.nextInt(1,100) > 70)
            {
                this.cY--;
                return;
            }
            
            this.cY++;
        }

        if(this.cY > y && this.cY > 0)
        {
            if(this.cY + 120 < 600 && rd.nextInt(1,100) > 70)
            {
                this.cY++;
                return;
            }
            
            this.cY--;
        }
    }

    public int get_cY()
    {
        return this.cY;
    }

}
