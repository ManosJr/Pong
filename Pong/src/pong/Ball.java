package pong;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball
{
    private Ellipse2D.Double ballShape;
    private int ballXposition;
    private int ballYposition;
    private int ballXspeed = 5;
    private int ballYspeed = 5;

    public Ball(int ballXposition, int ballYposition)//constructor
    {
        this.ballXposition = ballXposition;
        this.ballYposition = ballYposition;
        ballShape = new Ellipse2D.Double(ballXposition, ballYposition, 50, 50);
    }

    public void paintSelf(Graphics2D g2)
    {
        g2.setStroke(new BasicStroke(6f));
        g2.draw(ballShape);
        ballShape.x += ballXspeed;
        ballShape.y += ballYspeed;
    }
}
