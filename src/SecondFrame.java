import javax.swing.*;

public class SecondFrame implements Runnable {
    private PitcherPanel panel;
    public SecondFrame() {
        JFrame frame = new JFrame("Pitcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(612, 460);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        panel = new PitcherPanel();
        frame.add(panel);

        // display the frame
        frame.setVisible(true);

        // start thread, required for animation
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while (true) {
            panel.repaint();
        }
    }
}
