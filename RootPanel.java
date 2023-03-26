import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RootPanel extends JPanel implements Runnable {
    static final int GAME_HEIGHT = 750;
    static final int GAME_WIDTH = 650;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int ROCKET_HEIGHT = 192;
    static final int ROCKET_WIDTH = 192;
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
        playerRocket = new Rocket((GAME_WIDTH / 2) - (ROCKET_WIDTH / 2), ROCKET_HEIGHT * 3, ROCKET_WIDTH,
                ROCKET_HEIGHT);
    }

    public void newRocks() {

    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        playerRocket.draw(g);
    }

    public void move() {
        playerRocket.move();
    }

    public void checkCollision() {
        // stops rocket from going out of the screen
        if (playerRocket.xPosition <= 0) {
            playerRocket.xPosition = 0;
        }
        if (playerRocket.xPosition >= (GAME_WIDTH - ROCKET_WIDTH)) {
            playerRocket.xPosition = GAME_WIDTH - ROCKET_WIDTH;
        }
    }

    public void run() {
        // gameloop
        long lastTime = System.nanoTime();
        double fps = 60.0;
        double ns = 1000000000 / fps; // ns -> nanoseconds
        double delta = 0;
        boolean running = true;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;

            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            playerRocket.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            playerRocket.keyReleased(e);
        }
    }
}
