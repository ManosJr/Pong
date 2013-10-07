package pong;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball
{
    private Ellipse2D.Double ballShape;
    private int ballXspeed = 15;
    private int ballYspeed = 15;

    public Ball(int ballXpositionInitial, int ballYpositionInitial)//constructor
    {
        ballShape = new Ellipse2D.Double(ballXpositionInitial, ballYpositionInitial, 50, 50);
    }

    public void paintSelf(Graphics2D g2)
    {
        g2.setStroke(new BasicStroke(6f));
        g2.draw(getBallShape());
        ballShape.x += getBallXspeed();
        ballShape.y += getBallYspeed();
    }

    public double getBallx()
    {
        return getBallShape().x;
    }

    public double getBally()
    {
        return getBallShape().y;
    }

    public int getBallXspeed()
    {
        return ballXspeed;
    }

    public int getBallYspeed()
    {
        return ballYspeed;
    }

    public void setBallXspeed(int ballXspeed)
    {
        this.ballXspeed = ballXspeed;
    }

    public void setBallYspeed(int ballYspeed)
    {
        this.ballYspeed = ballYspeed;
    }

    public Ellipse2D.Double getBallShape()
    {
        return ballShape;
    }
}
