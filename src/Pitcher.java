import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pitcher {
    private Animation pitch;
    private int fastballSkill;
    private int curveballSkill;
    private int knuckleballSkill;

    private ArrayList<BufferedImage> pitchAnimation;
    public Pitcher() {
        pitchAnimation = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String name = "src/PitcherFrames/pitcher" + i + ".png";
            try {
                pitchAnimation.add(ImageIO.read(new File(name)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        fastballSkill = (int) (Math.random() * 100);
        curveballSkill = (int) (Math.random() * 100);
        knuckleballSkill = (int) (Math.random() * 100);
        pitch = new Animation(pitchAnimation, 200);
    }

    public void throwPitch() {
        pitch.start();
    }

    public BufferedImage restImage() {
        try {
            return ImageIO.read(new File("src/PitcherFrames/pitcher0.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public int getFastballSkill() {
        return fastballSkill;
    }
    public int getCurveballSkill() {
        return curveballSkill;
    }
    public int getKnuckleballSkill() {
        return knuckleballSkill;
    }
    public Animation getAnimation() {
        return pitch;
    }

    public BufferedImage getFrame() {
        return pitch.getActiveFrame();
    }

    public boolean animationRunning() {
        return pitch.getCurrentFrame() != 0 || pitch.getActiveFrame() == pitchAnimation.get(0);
    }

}
