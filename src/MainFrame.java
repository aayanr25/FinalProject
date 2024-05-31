import javax.swing.*;

public class MainFrame implements Runnable {
    private GraphicsPanel panel;
    public MainFrame() {
        JFrame frame = new JFrame("Baseball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 651);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        panel = new GraphicsPanel();
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
