package data;

import java.util.Random;

public class BallEngine{

    private float xVelocity;
    private float yVelocity;

    private float cX;
    private float cY;

    //private int height = 20;
    private int width = 20;

    public BallEngine()
    {

    }

    public void move()
    {
        this.cX += this.xVelocity;
        this.cY += this.yVelocity;
    }

    public void check_p1(int x,int y, int h,int w)
    {
        if(this.cX <= x + this.width && this.cY >= y && this.cY <= y + h)
        {
            this.xVelocity = -this.xVelocity;
            this.move();
            this.xVelocity = new Random().nextInt(1,3) * Integer.signum((int)this.xVelocity);
        }
    }

    public void check_p2(int x,int y, int h,int w)
    {
        if(this.cX + this.width >= x && this.cY >= y && this.cY <= y + h)
        {
            this.xVelocity = -this.xVelocity;
            this.move();
            this.xVelocity = new Random().nextInt(1,3) * Integer.signum((int)this.xVelocity);
        }
    }

    public void check_bounds()
    {
        if(this.cY <= 0 || this.cY + 20 >= 560)
        {
            this.yVelocity = - this.yVelocity;
        }

    }

    public int point(int x1, int x2)
    {

        if(this.cX < x1)
        {
            return -1;
        }
        if(this.cX + this.width > x2 )
        {
            return 1;
        }

        return 0;
    }

    public void set_initial(float vx,float vy,int x, int y)
    {
        this.cX = x;
        this.cY = y;
        this.xVelocity = vx;
        this.yVelocity = vy;
    }

    public float get_cX()
    {
        return this.cX;
    }

    public float get_cY()
    {
        return this.cY;
    }

    public float get_vX()
    {
        return this.xVelocity;
    }
}