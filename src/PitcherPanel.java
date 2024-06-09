import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PitcherPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private JButton fastball;
    private JButton curveball;
    private JButton knuckleball;
    private Pitcher pitcher;
    private Game game;
    private boolean pitchThrown;
    private Timer animationTimer;


    public PitcherPanel(Game game) {
        this.game = game;
        this.pitcher = game.getPitcher();


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


        animationTimer = new Timer(50, this);
        animationTimer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        fastball.setLocation(50, 400);
        curveball.setLocation(150, 400);
        knuckleball.setLocation(250, 400);
        if (pitchThrown) {
            g.drawImage(pitcher.getFrame(), 100, 60, null);
        } else {
            g.drawImage(pitcher.restImage(), 100, 60, null);
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            if (pitchThrown) {
                repaint();
            }
        } else if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == fastball) {
                pitchThrown = true;
                pitcher.throwPitch();
                game.getCurrentAtBat().setThrowPitch(true);
                game.getCurrentAtBat().pitch();
            } else if (button == curveball) {
                pitchThrown = true;
                pitcher.throwPitch();
                game.getCurrentAtBat().setThrowPitch(true);
                game.getCurrentAtBat().pitch();
            } else if (button == knuckleball) {
                pitchThrown = true;
                pitcher.throwPitch();
                game.getCurrentAtBat().setThrowPitch(true);
                game.getCurrentAtBat().pitch();
            }
            if (game.getCurrentAtBat().getOutcome() != null) {
                game.playNextAtBat();
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {}


    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void mouseClicked(MouseEvent e) {}


    @Override
    public void mousePressed(MouseEvent e) {}


    @Override
    public void mouseReleased(MouseEvent e) {}


    @Override
    public void mouseEntered(MouseEvent e) {}


    @Override
    public void mouseExited(MouseEvent e) {}
}
