import javax.swing.*;
import java.awt.*;

public class SecondFrame extends JFrame implements Runnable {
    private Game game;
    private PitcherPanel panel;

    public SecondFrame(Game game) {
        this.game = game;

        JFrame frame = new JFrame("Pitcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(612, 460); // 540 height of image + 40 for window menu bar
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        panel = new PitcherPanel(game);
        frame.add(panel);

        // display the frame
        frame.setVisible(true);

        // start thread, required for animation
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (!game.isGameOver()) {
            try {
                Thread.sleep(1000); // Simulate time between innings
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game over! Runs allowed: " + game.getRunsAllowed());
    }

}