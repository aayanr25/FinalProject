public class AtBat {
    private Pitcher pitcher;
    private Hitter hitter;
    private int balls;
    private int strikes;
    private boolean inPlay;
    private boolean out;

    public AtBat(Pitcher pitcher, Hitter hitter) {
        this.pitcher = pitcher;
        this.hitter = hitter;
        startAB();
    }

    private void startAB() {
        out = false;
        inPlay = false;
        while (strikes < 3 && balls < 4 && !inPlay) {
            // throw pitch
            boolean isStrike = false;
            double num = Math.random();
            if (num < 0.8) {
                isStrike = true;
            }
            if (isStrike) {
                num = Math.random();
                if (num > 0.6) {
                    inPlay = true;
                }
                if (inPlay) {
                    ballInPlay();
                    // display in play message
                } else {
                    strikes++;
                    // display strike message
                }
            } else {
                balls++;
                // display ball message
            }
        }
    }
    private void ballInPlay() {

    }
    public boolean out() {
        return out;
    }

}
