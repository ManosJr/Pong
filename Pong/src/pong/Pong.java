package pong;
/*
 * copyright 2013 James Moore
 * rev 0.3 131008
 */

import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong extends JComponent implements KeyListener, ActionListener
{
    JFrame pongWindow;//fields
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int ballWidth = 100;
    int ballHeight = 100;
    Timer paintTicker;
    Paddle paddle;
    Ball ball;
    URL pongSoundAddress = getClass().getResource("PongSound.aif");
    AudioClip pongSoundFile = JApplet.newAudioClip(pongSoundAddress);
    int score;
    URL pongLoseAddress = getClass().getResource("PongLoseNew.aif");
    AudioClip pongLoseFile = JApplet.newAudioClip(pongLoseAddress);
    boolean gameOver = false;

    public static void main(String[] args)
    {
        new Pong().getGoing();
    }

    private void getGoing()
    {
        ball = new Ball(500, 500);
        paddle = new Paddle(0, height / 2);
        paintTicker = new Timer(20, this);//action performed
        paintTicker.start();
        pongWindow = new JFrame();
        pongWindow.setVisible(true);
        pongWindow.setSize(width, height);
        pongWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pongWindow.add(this);//adds painter
        pongWindow.addKeyListener(this);
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        ball.paintSelf(g2);
        paddle.paintSelf(g2);
        g2.setFont(new Font("Bank Gothic", Font.BOLD, 99));
        g2.drawString(score + "", (int) (.8 * width), (int) (.2 * height));

        if (ball.getBally() > (height - (2 * ballHeight)))
        {
            ball.setBallYspeed(-ball.getBallYspeed());
        }
        if (ball.getBally() < 0)
        {
            ball.setBallYspeed(-ball.getBallYspeed());
        }
        if (ball.getBallx() > (width - ballWidth / 2))
        {
            ball.setBallXspeed(-ball.getBallXspeed());
        }
        if (ball.getBallShape().intersects(paddle.getPaddleShape()))
        {
            score++;
            pongSoundFile.play();
            ball.setBallXspeed(-ball.getBallXspeed());
        }
        if (ball.getBallx() < 0)
        {
            pongLoseFile.play();
            try
            {
                Thread.sleep(8000);
            } catch (InterruptedException ex)
            {
            }
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == 40)//down
        {
            paddle.setPaddleYpos(paddle.getPaddleY() + 25);
        }
        if (e.getKeyCode() == 38)//up
        {
            paddle.setPaddleYpos(paddle.getPaddleY() - 25);
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
