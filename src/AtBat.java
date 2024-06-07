public class AtBat {
    private Pitcher pitcher;
    private Hitter hitter;
    private Game game;
    private int balls;
    private int strikes;
    private boolean inPlay;
    private boolean out;

    public AtBat(Pitcher pitcher, Hitter hitter, Game game) {
        this.pitcher = pitcher;
        this.hitter = hitter;
        this.game = game;
        this.balls = 0;
        this.strikes = 0;
        this.inPlay = false;
        this.out = false;
        startAB();
    }

    private void startAB() {
        out = false;
        inPlay = false;
        while (strikes < 3 && balls < 4 && !inPlay) {
            boolean isStrike = Math.random() < 0.8;
            if (isStrike) {
                if (Math.random() > 0.6) {
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
        }
    }

    private void ballInPlay() {
        // Logic to handle ball in play
        out = Math.random() > 0.5; // Example logic
    }

    public boolean isOut() {
        return out;
    }
}