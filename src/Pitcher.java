import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pitcher {
    private Animation pitch;
    private static int num;
    private ArrayList<BufferedImage> pitchAnimation;
    public Pitcher() {
        ArrayList<BufferedImage> pitchAnimation = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String name = "src/PitcherFrames/pitcher" + i + ".png";
            try {
                pitchAnimation.add(ImageIO.read(new File(name)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        pitch = new Animation(pitchAnimation, 200);
    }

    public BufferedImage throwPitch() {
        if (num < 5) {
            num++;
            return pitch.getActiveFrame();
        } else {
            return restImage();
        }
    }

    public BufferedImage restImage() {
        try {
            return ImageIO.read(new File("src/PitcherFrames/pitcher0.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public void throwFastball() {

    }


}
