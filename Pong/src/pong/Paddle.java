package pong;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Paddle
{
    private Rectangle2D.Double paddleShape;

    public Paddle(int paddleXpositionInitial, int paddleYpositionInitial)
    {
        paddleShape = new Rectangle2D.Double(paddleXpositionInitial, paddleYpositionInitial, 20, 100);
    }

    public void paintSelf(Graphics2D g2)
    {
        g2.setStroke(new BasicStroke(6f));
        g2.draw(getPaddleShape());
    }

    public Rectangle2D.Double getPaddleShape()
    {
        return paddleShape;
    }

    public double getPaddleY()
    {
        return paddleShape.y;
    }
    
    public void setPaddleYpos(double paddleYpos)
    {
        paddleShape.y = paddleYpos;
    }
            
}
