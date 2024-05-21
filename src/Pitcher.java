import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pitcher {
    private Animation pitch;
    public Pitcher() {
        ArrayList<BufferedImage> pitch_animation = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String name = "src/PitcherFrames/pitcher" + i + ".png";
            try {
                pitch_animation.add(ImageIO.read(new File(name)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        pitch = new Animation(pitch_animation, 10);
    }

    public BufferedImage getImage() {
        return pitch.getActiveFrame();
    }
}
