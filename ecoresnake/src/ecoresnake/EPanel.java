package ecoresnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer; 

import javax.sound.sampled.*;

public class EPanel extends JPanel implements KeyListener, ActionListener {
    ImageIcon title;
    ImageIcon body;
    ImageIcon up;
    ImageIcon down;
    ImageIcon left;
    ImageIcon right;
    ImageIcon food;
    ImageIcon powerfood;
    ImageIcon greenfood;

    int len = 3;
    int score = 0;
    int[] snakex = new int[816];
    int[] snakey = new int[816];
    String direct = "R"; // direction: R, L, U, D
    boolean isStarted = false;
    boolean isFailed = false;
    Timer timer = new Timer(100, this);
    int foodx;
    int foody;
    int powerfoodx;
    int powerfoody;
    int greenfoodx;
    int greenfoody;
    int foodRand;
    Random rand = new Random();

    // Background Music
    Clip bgm;

    public EPanel() {
        loadImages();
        initSnake();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
        loadBGM();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.GRAY);
        title.paintIcon(this, g, 25, 11);
        g.fillRect(25, 75, 850, 600);
        g.setColor(Color.WHITE);
        g.drawString("Len: " + len, 750, 35);
        g.drawString("Score: " + score, 750, 50);

        if (direct == "R") {
            right.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (direct == "L") {
            left.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (direct == "D") {
            down.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (direct == "U") {
            up.paintIcon(this, g, snakex[0], snakey[0]);
        }

        for (int i = 1; i < len; i++) {
            body.paintIcon(this, g, snakex[i], snakey[i]);
        }

        switch (foodRand) {
        case 0:
            food.paintIcon(this, g, foodx, foody);
            break;

        case 1:
            food.paintIcon(this, g, foodx, foody);
            powerfood.paintIcon(this, g, powerfoodx, powerfoody);
            break;
        case 2:
            food.paintIcon(this, g, foodx, foody);
            greenfood.paintIcon(this, g, greenfoodx, greenfoody);
            break;
        case 3:
            food.paintIcon(this, g, foodx, foody);
            powerfood.paintIcon(this, g, powerfoodx, powerfoody);
            greenfood.paintIcon(this, g, greenfoodx, greenfoody);
            break;
        }

        if (isStarted == false) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 40));
            g.drawString("Press Space to Start", 300, 300);
        }
        if (isFailed) {
            g.setColor(Color.RED);
            g.setFont(new Font("arial", Font.BOLD, 40));
            g.drawString("Failed: Press Space to Restart", 200, 300);
        }

    }

    public void initSnake() {
        len = 3;
        snakex[0] = 100;
        snakey[0] = 100;
        snakex[1] = 75;
        snakey[1] = 100;
        snakex[2] = 50;
        snakey[2] = 100;
        foodx = 25 + 25 * rand.nextInt(34);
        foody = 75 + 25 * rand.nextInt(24);
        powerfoodx = 25 + 25 * rand.nextInt(34);
        powerfoody = 75 + 25 * rand.nextInt(24);
        greenfoodx = 25 + 25 * rand.nextInt(34);
        greenfoody = 75 + 25 * rand.nextInt(24);
        foodRand = rand.nextInt(3);

        direct = "R";
        score = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_SPACE) {
            if (isFailed) {
                isFailed = false;
                initSnake();
            } else {
                isStarted = !isStarted;
            }
            repaint();
            if (isStarted) {
                playBGM();
            } else {
                stopBGM();
            }

        } else if (keycode == KeyEvent.VK_LEFT) {
            if (direct != "R") {
                direct = "L";

            }
        } else if (keycode == KeyEvent.VK_RIGHT) {
            if (direct != "L") {
                direct = "R";

            }
        } else if (keycode == KeyEvent.VK_UP) {
            if (direct != "D") {
                direct = "U";

            }
        } else if (keycode == KeyEvent.VK_DOWN) {
            if (direct != "U") {
                direct = "D";

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStarted && !isFailed) {

            for (int i = len - 1; i > 0; i--) {
                snakex[i] = snakex[i - 1];
                snakey[i] = snakey[i - 1];
            }
            if (direct == "R") {
                snakex[0] = snakex[0] + 25;
                if (snakex[0] > 850)
                    snakex[0] = 25;

            } else if (direct == "L") {
                snakex[0] = snakex[0] - 25;
                if (snakex[0] < 25)
                    snakex[0] = 850;

            } else if (direct == "U") {
                snakey[0] = snakey[0] - 25;
                if (snakey[0] < 75)
                    snakey[0] = 650;

            } else if (direct == "D") {
                snakey[0] = snakey[0] + 25;
                if (snakey[0] > 650)
                    snakey[0] = 75;
            }

            if (snakex[0] == foodx && snakey[0] == foody) {
                len++;
                score += 10;
                foodRand = rand.nextInt(4);
                foodRandSwitch();

            }

            else if (snakex[0] == powerfoodx && snakey[0] == powerfoody) {
                len += 3;
                score += 40;
                foodRand = rand.nextInt(4);
                foodRandSwitch();
            }

            else if (snakex[0] == greenfoodx && snakey[0] == greenfoody) {
                if (len > 3) {
                    len -= 1;
                }
                score += 5;
                foodRand = rand.nextInt(4);
                foodRandSwitch();
            }

            for (int i = 1; i < len; i++) {
                if (snakex[i] == snakex[0] && snakey[i] == snakey[0]) {
                    isFailed = true;
                }
            }

            repaint();
        }

        timer.start();
    }

    private void loadImages() {
        InputStream is;
        try {
            is = getClass().getClassLoader().getResourceAsStream("images/title.jpg");
            title = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/body.png");
            body = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/up.png");
            up = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/down.png");
            down = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/left.png");
            left = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/right.png");
            right = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/food.png");
            food = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/powerfood.png");
            powerfood = new ImageIcon(ImageIO.read(is));

            is = getClass().getClassLoader().getResourceAsStream("images/greenfood.png");
            greenfood = new ImageIcon(ImageIO.read(is));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void loadBGM() {
        try {
            bgm = AudioSystem.getClip();
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("sound/bgm.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            bgm.open(ais);

        } catch (LineUnavailableException e) {
            e.printStackTrace();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private void playBGM() {
        bgm.loop(Clip.LOOP_CONTINUOUSLY);

    }

    private void stopBGM() {
        bgm.stop();

    }

    public void foodRandSwitch() {
        switch (foodRand) {
        case 0:
            foodx = 25 + 25 * rand.nextInt(34);
            foody = 75 + 25 * rand.nextInt(24);
            powerfoodx = 0;
            powerfoody = 0;
            greenfoodx = 0;
            greenfoody = 0;
            break;

        case 1:
            foodx = 25 + 25 * rand.nextInt(34);
            foody = 75 + 25 * rand.nextInt(24);
            powerfoodx = 25 + 25 * rand.nextInt(34);
            powerfoody = 75 + 25 * rand.nextInt(24);
            greenfoodx = 0;
            greenfoody = 0;
            break;
        case 2:
            foodx = 25 + 25 * rand.nextInt(34);
            foody = 75 + 25 * rand.nextInt(24);
            powerfoodx = 0;
            powerfoody = 0;
            greenfoodx = 25 + 25 * rand.nextInt(34);
            greenfoody = 75 + 25 * rand.nextInt(24);
            break;
        case 3:
            foodx = 25 + 25 * rand.nextInt(34);
            foody = 75 + 25 * rand.nextInt(24);
            powerfoodx = 25 + 25 * rand.nextInt(34);
            powerfoody = 75 + 25 * rand.nextInt(24);
            greenfoodx = 25 + 25 * rand.nextInt(34);
            greenfoody = 75 + 25 * rand.nextInt(24);
            break;
        }
    }

}