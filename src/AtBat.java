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
        balls = 0;
        strikes = 0;
        game.getGraphicsPanel().updateCount(balls, strikes);
    }

    public void setThrowPitch(boolean value) {
        throwPitch = value;
    }

    public void pitch() {
        boolean isStrike = Math.random() < 0.75;
        if (isStrike) {
            if (Math.random() > 0.65) {
                inPlay = true;
                ballInPlay();
                game.showResultMessage(outcome.toUpperCase());
            } else {
                strikes++;
                game.getGraphicsPanel().updateCount(balls, strikes);
                if (strikes == 3) {
                    outcome = "Strikeout";
                    game.showResultMessage("STRIKEOUT");
                    out = true;
                } else {
                    game.showResultMessage("STRIKE " + strikes);
                }
            }
        } else {
            balls++;
            if (balls == 4) {
                outcome = "Walk";
                game.showResultMessage("WALK");
            } else {
                game.showResultMessage("BALL " + balls);
            }
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (out) {
            game.incrementOuts();
        }
    }
    public boolean getThrowPitch() {
        return throwPitch;
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
    public boolean isABOver() {
        return outcome != null;
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