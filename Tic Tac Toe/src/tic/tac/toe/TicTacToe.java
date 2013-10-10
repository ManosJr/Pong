package tic.tac.toe;

/*
 * copyright 2013 James Moore
 * rev 0.2 131010
 */
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe implements ActionListener
{
    JFrame boardWindow;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int playCount;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;

    public static void main(String[] args)
    {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.getGoing();
    }

    public void getGoing()
    {
        boardWindow = new JFrame();
        boardWindow.setLayout(new GridLayout(3, 3));
        boardWindow.setVisible(true);
        boardWindow.setSize(width / 2, height / 2);
        boardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("1");
        boardWindow.add(button1);
        button1.addActionListener(this);
        button2 = new JButton("2");
        boardWindow.add(button2);
        button2.addActionListener(this);
        button3 = new JButton("3");
        boardWindow.add(button3);
        button3.addActionListener(this);
        button4 = new JButton("4");
        boardWindow.add(button4);
        button4.addActionListener(this);
        button5 = new JButton("5");
        boardWindow.add(button5);
        button5.addActionListener(this);
        button6 = new JButton("6");
        boardWindow.add(button6);
        button6.addActionListener(this);
        button7 = new JButton("7");
        boardWindow.add(button7);
        button7.addActionListener(this);
        button8 = new JButton("8");
        boardWindow.add(button8);
        button8.addActionListener(this);
        button9 = new JButton("9");
        boardWindow.add(button9);
        button9.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent joe)
    {
        JButton clickedButton = (JButton) joe.getSource();
        clickedButton.setFont(new Font("Bank Gothic", Font.BOLD, 99));
        playCount++;
        if (clickedButton.getText().equals("o") || clickedButton.getText().equals("x"))
        {
            JOptionPane.showMessageDialog(null, "I'll have none of that.  Lose a turn");
            playCount++;
        } else
        {
            if (playCount % 2 == 0)
            {
                clickedButton.setText("x");
            } else
            {
                clickedButton.setText("o");
            }
        }

        if (button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()))
        {
            gameOver(button1.getText(), false);
        }
        if (button1.getText().equals(button4.getText()) && button1.getText().equals(button7.getText()))
        {
            gameOver(button1.getText(), false);
        }
        if (button1.getText().equals(button5.getText()) && button1.getText().equals(button9.getText()))
        {
            gameOver(button1.getText(), false);
        }
        if (button2.getText().equals(button5.getText()) && button2.getText().equals(button8.getText()))
        {
            gameOver(button2.getText(), false);
        }
        if (button3.getText().equals(button6.getText()) && button3.getText().equals(button9.getText()))
        {
            gameOver(button3.getText(), false);
        }
        if (button3.getText().equals(button5.getText()) && button3.getText().equals(button7.getText()))
        {
            gameOver(button3.getText(), false);
        }
        if (button4.getText().equals(button5.getText()) && button4.getText().equals(button6.getText()))
        {
            gameOver(button4.getText(), false);
        }
        if (button7.getText().equals(button8.getText()) && button7.getText().equals(button9.getText()))
        {
            gameOver(button7.getText(), false);
        }
        if (playCount == 9)
        {
            gameOver("Boring", true);
        }
    }

    public void gameOver(String winnerSymbol, boolean catsGame)
    {
        if (!catsGame)
        {
            JOptionPane.showMessageDialog(null, " Congrats, " + winnerSymbol + " you win!");
        } else
        {
            JOptionPane.showMessageDialog(null, "Cat's Game!");
        }
        System.exit(0);
    }
}
