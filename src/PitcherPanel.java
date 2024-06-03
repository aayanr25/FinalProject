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
    private JButton fastball;
    private JButton curveball;
    private JButton knuckleball;
    private Pitcher pitcher;
    private Game game;
    private boolean pitchThrown;
    private Timer animationTimer;
    public PitcherPanel() {
        pitcher = new Pitcher();
        game = new Game(pitcher);
        try {
            background = ImageIO.read(new File("src/background2.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        pitchThrown = false;
        fastball = new JButton("Fastball");
        add(fastball);
        fastball.addActionListener(this);
        curveball = new JButton("Curveball");
        add(curveball);
        curveball.addActionListener(this);
        knuckleball = new JButton("Knuckleball");
        add(knuckleball);
        knuckleball.addActionListener(this);

        animationTimer = new Timer(200, this);
        animationTimer.start();
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        fastball.setLocation(50, 400);
        curveball.setLocation(150, 400);
        knuckleball.setLocation(250,400);
        if (pitchThrown) {
            g.drawImage(pitcher.getFrame(), 100, 60, null);
        } else {
            g.drawImage(pitcher.restImage(), 100, 60, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            pitcher.throwPitch();
            pitchThrown = true;
            if (button == fastball) {

            } else if (button == curveball) {

            } else if (button == knuckleball) {

            }

        }
        if (e.getSource() instanceof Timer) {
            if (pitchThrown) {
                repaint();
            }
            if (!pitcher.animationRunning()) {
                pitchThrown = false;
            }
        }
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
