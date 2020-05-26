package laplanh2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import static laplanh2.FrameScreen.column;
import static laplanh2.FrameScreen.row;
import static laplanh2.FrameScreen.arr;

public class GameScreen extends JPanel implements ActionListener {

    public static int countY = 0;
    public static int countX = 0;
    public static int count3 = 0;
    public static int countEnd = 0;
    public static int x = 0;
    public static int x1, x2, y1, y2;
    public static int i1, j1, i2, j2;

    JButton button;
    JButton[][] jButton = new JButton[row][column];
    JLabel jLable, jLableEnd;

    public GameScreen() {

        createButton();
        createLable();

    }

    public void createButton() {
        for (int i = 0; i < row; i++) {
            x = i + countY;
            for (int j = 0; j < column; j++) {
                setLayout(null);
                //new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\LapLanh\\image\\hoicham.jpg")
                jButton[i][j] = new JButton();
                add(jButton[i][j]);
                jButton[i][j].setBackground(Color(51, 51, 51));
                jButton[i][j].setBounds(j + countX + 377, x + 150, 110, 110);
                jButton[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                jButton[i][j].setActionCommand(Integer.toString(i) + "" + Integer.toString(j));
                jButton[i][j].addActionListener(this);
                countX += 112;
            }
            countY += 112;
            countX = 0;
        }
    }

    public void create2() {

        JButton button = new JButton(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\LapLanh\\image\\cho1.jpg"));
        add(button);
        setLayout(null);
        button.setBounds(10, 40, 50, 50);

    }

    public void createLable() {
        jLable = new JLabel("Game A");
        jLableEnd = new JLabel("Victory!!!");
        add(jLable);
        jLable.setBounds(468, 15, 300, 100);
        jLable.setFont(new Font("Arial", Font.BOLD, 70));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((Integer.toString(i) + "" + Integer.toString(j)).equals(ae.getActionCommand())) {
                    jButton[i][j].setText(Integer.toString(arr[i][j]));
                    jButton[i][j].setEnabled(false);
                    count3++;
                    if (count3 == 1) {
                        i1 = i;
                        j1 = j;
                    }
                    if (count3 == 2) {
                        i2 = i;
                        j2 = j;
                        if (countEnd == 7) {
                            jButton[i1][j1].setSize(0, 0);
                            jButton[i2][j2].setSize(0, 0);
                            add(jLableEnd);
                            jLableEnd.setBounds(400, 200, 600, 200);
                            jLableEnd.setFont(new Font("Arial", Font.BOLD, 100));
                            jLable.setText("");
                            jLable.setSize(0, 0);
                        }
                    }
                    if (count3 == 3) {
                        boolean result = check(arr[i1][j1], arr[i2][j2]);
                        if (result == false) {
                            jButton[i1][j1].setEnabled(true);
                            jButton[i2][j2].setEnabled(true);
                            jButton[i2][j2].setEnabled(true);
                            jButton[i1][j1].setText("");
                            jButton[i2][j2].setText("");
                        } else {
                            jButton[i1][j1].setSize(0, 0);
                            jButton[i2][j2].setSize(0, 0);
                            countEnd++;
                            System.out.println("countEnd = " + countEnd);
                        }
                        i1 = i;
                        j1 = j;
                        count3 = 1;
                    }
                }
            }
        }
    }

    static boolean check(int a, int b) {
        boolean result;
        if (a == b) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    private Color Color(int a1, int a2, int a3) {
        Color a = new Color(a1, a2, a3);
        return a;
    }
}
