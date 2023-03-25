import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RootPanel extends JPanel implements Runnable {
    static final int GAME_HEIGHT = 600;
    static final int GAME_WIDTH = 500;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int ROCKET_HEIGHT = 40;
    static final int ROCKET_WIDTH = 30;
    static final int ROCK_DIAMETER = 30;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Rocket playerRocket;
    Rocks rocks;
    Score score;

    RootPanel() {
        newRocket();
        newRocks();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newRocket() {

    }

    public void newRocks() {

    }

    public void paint(Graphics g) {

    }

    public void draw(Graphics g) {

    }

    public void move() {

    }

    public void checkCollision() {

    }

    public void run() {

    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {

        }
    }
}
