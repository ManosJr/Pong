package pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Pong extends JComponent implements KeyListener
{
    JFrame pongWindow;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int xBall = 0;
    int yBall = 0;
    int ballWidth = 100;
    int ballHeight = 100;
    int ballXspeed = 5;
    int ballYspeed = 5;
    int paddleYpos = height/3;
    
    public static void main(String[] args)
    {
        new Pong().getGoing();
    }

    private void getGoing()
    {
      pongWindow = new JFrame();
      pongWindow.setVisible(true);
      pongWindow.setSize(width, height);
      pongWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pongWindow.add(this);
      pongWindow.addKeyListener(this);
    }
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(6f));
        g2.drawRect(0, paddleYpos, 20, 100);
        g2.drawOval(xBall, yBall, ballWidth, ballHeight);
        g2.setColor(Color.CYAN);
        g2.fillOval(xBall, yBall, ballWidth, ballHeight);
        xBall += ballXspeed;
        yBall += ballYspeed;
        if (yBall > (height - (2 * ballHeight)))
        {
           ballYspeed = -ballYspeed; 
        }
        if (yBall < 0)
        {
            ballYspeed = -ballYspeed;
        }
        if (xBall > (width - ballWidth))
        {
            ballXspeed = -ballXspeed;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == 40)
        {
            paddleYpos += 25;
        }
        if (e.getKeyCode() == 38)
        {
            paddleYpos -= 25;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
