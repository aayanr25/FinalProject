import javax.swing.*;

public class MainFrame implements Runnable {
    private GraphicsPanel panel;
    private Game game;

    public MainFrame(Game game) {
        this.game = game;
        JFrame frame = new JFrame("Baseball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 651);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        panel = new GraphicsPanel(game);
        frame.add(panel);

        // Set the graphics panel in the game
        game.setGraphicsPanel(panel);

        frame.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            panel.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}