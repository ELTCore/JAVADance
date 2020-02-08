package ecoresnake;

import javax.swing.JFrame;

public class ESnake {

    public static void main(String[] args) {
        JFrame frame = new JFrame("ESnake   by HaikiYuuki");

        frame.setBounds(10, 10, 900, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EPanel());

        frame.setVisible(true);
    }
}