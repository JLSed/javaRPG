package ui;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameButton  extends JPanel {

    private JButton[][] buttons;

    public GameButton(int row, int col, String labels[][], KeyListener buttonAction) {
        super(new GridLayout(row, col, 20, 20));
        setBackground(Color.BLACK);
        buttons = new JButton[row][col];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                final int curRow = i;
                final int curCol = j;
                buttons[i][j] = new JButton(labels[i][j]);
                buttons[i][j].setBackground(Color.BLACK);
                buttons[i][j].setForeground(Color.GREEN);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
                buttons[i][j].addKeyListener(buttonAction);
                buttons[i][j].addFocusListener(CurrentFocus);
                buttons[i][j].addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (curRow > 0)
                            buttons[curRow - 1][curCol].requestFocus();
                        break;
                    case KeyEvent.VK_DOWN:
                        if (curRow < buttons.length - 1)
                            buttons[curRow + 1][curCol].requestFocus();
                        break;
                    case KeyEvent.VK_LEFT:
                        if (curCol > 0)
                            buttons[curRow][curCol - 1].requestFocus();
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (curCol < buttons[curRow].length - 1)
                            buttons[curRow][curCol + 1].requestFocus();
                        break;
                    default:
                        break;
                    }
                }
                });
                add(buttons[i][j]);
            }
        }
    }

    private FocusListener CurrentFocus = new FocusListener() {
        @Override
                public void focusGained(FocusEvent e) {
                    ((JButton) e.getComponent()).setBackground(Color.GREEN);
                    ((JButton) e.getComponent()).setForeground(Color.BLACK);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    ((JButton) e.getComponent()).setBackground(Color.BLACK);
                    ((JButton) e.getComponent()).setForeground(Color.GREEN);
                }
    };
}
