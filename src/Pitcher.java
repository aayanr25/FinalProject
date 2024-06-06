import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pitcher {
    private Animation pitch;
    private ArrayList<BufferedImage> pitchAnimation;
    private Game game;
    private int fastballSkill;
    private int curveballSkill;

    public Pitcher(Game game) {
        this.game = game;
        this.fastballSkill = (int) (Math.random() * 100); // Example skill level
        this.curveballSkill = (int) (Math.random() * 100); // Example skill level
        pitchAnimation = new ArrayList<>();
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
        return pitch.getActiveFrame();
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
        pitch.start();
    }

    public Animation getAnimation() {
        return pitch;
    }

    public boolean isAnimating() {
        return pitch.getCurrentFrame() != 0 || (pitch.getCurrentFrame() == 0 && pitch.getActiveFrame() != pitchAnimation.get(0));
    }

    public int getFastballSkill() {
        return fastballSkill;
    }

    public int getCurveballSkill() {
        return curveballSkill;
    }
}