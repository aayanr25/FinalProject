public class AtBat {
    private Pitcher pitcher;
    private Hitter hitter;
    private int balls;
    private int strikes;
    boolean inPlay;
    public AtBat(Pitcher pitcher, Hitter hitter) {
        this.pitcher = pitcher;
        this.hitter = hitter;
        startAB();
    }

    private void startAB() {
        while (strikes < 3 && balls < 4 && !inPlay) {
            // throw pitch
            boolean isStrike = false;
            double num = Math.random();
            if (num < 0.8) {
                isStrike = true;
            }
            if (isStrike) {
                if (inPlay) {
                    ballInPlay();
                } else {
                    strikes++;
                    // display strike message
                }
            } else {
                balls++;
            }
        }
    }
    private void ballInPlay() {

    }

}
