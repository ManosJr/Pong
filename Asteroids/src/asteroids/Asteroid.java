package asteroids;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class Asteroid extends JComponent
{
    private Ellipse2D.Double asteroidShape;
    
    
    public Asteroid()
    {
        asteroidShape = new Ellipse2D.Double(0, 0, 75, 75);
    }

    @Override
    public void paint(Graphics body)
    {
        Graphics2D body2 = (Graphics2D) body;
        
        body2.translate(700, 700);
        
        body2.draw(asteroidShape);

        repaint();
    }
}
