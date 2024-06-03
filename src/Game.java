import java.util.ArrayList;

public class Game {
    private Pitcher pitcher;
    private ArrayList<Hitter> battingOrder;
    private int placeInLineup;
    private Hitter currentHitter;
    private int runsAllowed;
    private int outs;
    private int inning;
    private boolean onFirst;
    private boolean onSecond;
    private boolean onThird;
    private boolean gameOver;

    public Game(Pitcher pitcher) {
        this.pitcher = pitcher;
        initializeBattingOrder();
        while(!gameOver) {
            while (inning <= 9) {
                playInning();
            }
            outs = 0;
            inning++;
        }
    }
    public ArrayList<Hitter> getBattingOrder() {
        return battingOrder;
    }
    private void playInning() {
        currentHitter = battingOrder.get(placeInLineup);
        while (outs < 3) {

        }
        AtBat current = new AtBat(pitcher, currentHitter);
    }

    private void initializeBattingOrder() {
        battingOrder = new ArrayList<>();
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
        battingOrder.add(new Hitter(" ", (int) (Math.random() * 100)));
    }

}
