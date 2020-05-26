package laplanh2;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameScreen extends JFrame {

    GameScreen gameScreen;
    public static final int row = 4;
    public static final int column = 4;
    public static int elements = row * column / 2 + 1;
    public static int[][] arr;
    

    public FrameScreen() {
        gameScreen = new GameScreen();
        add(gameScreen);
        creatAndShow();

    }

    static int[][] arrayRandom() {
        int[][] arr = new int[row][column];
        Random rd = new Random();
        int num = 1;
        boolean flag = true;
        while (flag) {
            int m = rd.nextInt(row);
            int n = rd.nextInt(column);
            if (arr[m][n] == 0) {
                arr[m][n] = num;
                num++;
                if (num == elements) {
                    num = 1;
                }
            }
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (arr[i][j] == 0) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                flag = false;
            }
        }
        return arr;
    }

    public void creatAndShow() {
        setTitle("Atom");
        setSize(1200, 800);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameScreen();
        arr = arrayRandom();
    }

}
