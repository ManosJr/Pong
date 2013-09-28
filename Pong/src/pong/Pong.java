package pong;
/*
 * copyright 2013 James Moore
 * rev 0.1 130928
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong extends JComponent implements KeyListener, ActionListener
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
    int paddleYpos = height / 3;
    Timer paintTicker;
    Ball ball;

    public static void main(String[] args)
    {
        new Pong().getGoing();
    }

    private void getGoing()
    {
        ball = new Ball(500, 500);
        paintTicker = new Timer(20, this);
        paintTicker.start();
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
        Graphics2D g2 = (Graphics2D) g;
        ball.paintSelf(g2);
        g2.setStroke(new BasicStroke(6f));
        g2.drawRect(0, paddleYpos, 20, 100);
        
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

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
    }
}
