import java.util.ArrayList;

public class Game {
    private Pitcher pitcher;
    private ArrayList<Hitter> battingOrder;
    private int currentHitter;
    private int runsAllowed;
    private int outs;
    private boolean onFirst;
    private boolean onSecond;
    private boolean onThird;

    public Game(Pitcher pitcher) {
        this.pitcher = pitcher;
        initializeBattingOrder();
    }
    public ArrayList<Hitter> getBattingOrder() {
        return battingOrder;
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
