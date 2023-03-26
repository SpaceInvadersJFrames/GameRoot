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
    BufferedImage ship;

    Rocket(int xPosition, int yPosition, int ROCKET_WIDTH, int ROCKET_HEIGHT) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void setXDirection(int xDirection) {

    }

    public void move() {

    }

    public void draw(Graphics g) {
        g.setColor(new Color(219, 155, 4));
        try {
            ship = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\ship.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(ship, xPosition, yPosition, null);
    }
}
