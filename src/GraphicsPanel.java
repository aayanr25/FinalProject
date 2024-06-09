import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GraphicsPanel extends JPanel {
    private Game game;
    private String message;
    private BufferedImage background;
    private Timer messageTimer;
    private boolean showMessage;
    private int balls;
    private int strikes;

    public GraphicsPanel(Game game) {
        this.game = game;
        message = "";
        try {
            background = ImageIO.read(new File("src/background.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0,0, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 14));
        g.drawString("Balls: " + game.getCurrentAtBat().getBalls(), 50, 50);
        g.drawString("Strikes: " + game.getCurrentAtBat().getStrikes(), 50, 70);
        g.drawString("Runs Allowed: " + game.getRunsAllowed(), 50, 90);
        g.drawString("Inning: " + game.getInning(), 50, 110);
        g.drawString("Outs: " + game.getOuts(), 50, 130);
        g.drawString("At Bat: " + game.getCurrentHitter(), 50, 150);

        if (showMessage && message != null) {
            g.setFont(new Font("Serif", Font.BOLD, 48));
            g.drawString(message, 300, 300);
        }
    }

    public void updateDisplay() {
        repaint();
    }

    // make this method better
    public void showMessage(String message, int duration) {
        this.message = message;
        showMessage = true;
        repaint();

        if (messageTimer != null) {
            messageTimer.cancel();
        }

        messageTimer = new Timer();
        messageTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                showMessage = false;
                updateDisplay();
            }
        }, duration);
    }

    public void updateCount(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
        updateDisplay();
    }
}