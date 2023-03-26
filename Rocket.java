import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Rocket {
    int xVelocity;
    int xPosition;
    int yPosition;
    int movement = 10;
    BufferedImage ship;

    Rocket(int xPosition, int yPosition, int ROCKET_WIDTH, int ROCKET_HEIGHT) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_D) || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            setXDirection(movement);
            move();
        }
        if ((e.getKeyCode() == KeyEvent.VK_A) || (e.getKeyCode() == KeyEvent.VK_LEFT)) {
            setXDirection(-movement);
            move();
        }
    }

    public void keyReleased(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_D) || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            setXDirection(0);
            move();
        }
        if ((e.getKeyCode() == KeyEvent.VK_A) || (e.getKeyCode() == KeyEvent.VK_LEFT)) {
            setXDirection(0);
            move();
        }
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void move() {
        xPosition += xVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(219, 155, 4));
        try {
            // "E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\rocketship.png"
            ship = ImageIO.read(new File("C:\\Users\\sonu_\\OneDrive\\Desktop\\SpaceInvader\\GameRoot\\rocketship.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(ship, xPosition, yPosition, null);
    }
}
