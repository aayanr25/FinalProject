import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PitcherPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private BufferedImage restImage;
    private Pitcher pitcher;
    public PitcherPanel() {
        pitcher = new Pitcher();
        try {
            background = ImageIO.read(new File("src/background2.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
           restImage = ImageIO.read(new File("src/PitcherFrames/pitcher0.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(pitcher.getImage(), 225, 75, null);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
