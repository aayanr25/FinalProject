public class AtBat {
    private Pitcher pitcher;
    private Hitter hitter;
    private Game game;
    private int balls;
    private int strikes;
    private boolean inPlay;
    private boolean out;
    private String outcome;
    private boolean throwPitch;

    public AtBat(Pitcher pitcher, Hitter hitter, Game game) {
        this.pitcher = pitcher;
        this.hitter = hitter;
        this.game = game;
        outcome = null;
    }

    public void startAB() {
        out = false;
        inPlay = false;
        game.getGraphicsPanel().updateCount(0,0);
        while (strikes < 3 && balls < 4 && !inPlay) {
            if (throwPitch) {
                pitch();
                throwPitch = false;
            }
        }
    }
    public void setThrowPitch(boolean value) {
        throwPitch = value;
    }
    public void pitch() {
        boolean isStrike = Math.random() < 0.6;
        if (isStrike) {
            if (Math.random() > 0.65) {
                inPlay = true;
                ballInPlay();
            } else {
                strikes++;
                game.getGraphicsPanel().updateCount(balls, strikes);
                game.getGraphicsPanel().showMessage("STRIKE", 2000);
            }
        } else {
            balls++;
            game.getGraphicsPanel().updateCount(balls, strikes);
            game.getGraphicsPanel().showMessage("BALL", 2000);
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (strikes == 3) {
            outcome = "Strikeout";
        } else if (balls == 4) {
            outcome = "Walk";
        }
    }

    public void ballInPlay() {
        double num = Math.random();
        if (num > 0.95) {
            outcome = "Home Run";
        } else if (num > 0.75) {
            outcome = "Double";
        } else if (num > 0.5) {
            outcome = "Single";
        } else {
            outcome = "Out";
            out = true;
        }
    }

    public String getOutcome() {
        return outcome;
    }

    public boolean isOut() {
        return out;
    }
    public int getBalls() {
        return balls;
    }
    public int getStrikes() {
        return strikes;
    }
}