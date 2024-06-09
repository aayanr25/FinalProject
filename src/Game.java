import java.util.ArrayList;


public class Game {
    private Pitcher pitcher;
    private ArrayList<Hitter> battingOrder;
    private Hitter currentHitter;
    private AtBat currentAtBat;
    private int placeInLineup;
    private int runsAllowed;
    private int outs;
    private int inning;
    private boolean onFirst;
    private boolean onSecond;
    private boolean onThird;
    private boolean gameOver;
    private GraphicsPanel graphicsPanel;


    public Game() {
        inning = 1;
        initializeBattingOrder();
        currentHitter = battingOrder.get(0);
        currentAtBat = new AtBat(pitcher, currentHitter, this);
    }
    public void setPitcher(Pitcher pitcher) {
        this.pitcher = pitcher;
    }


    public void startGame() {
        placeInLineup = 0;
        currentHitter = battingOrder.get(placeInLineup);
        currentAtBat = new AtBat(pitcher, currentHitter, this);
        currentAtBat.startAB();
    }
    public void setGraphicsPanel(GraphicsPanel graphicsPanel) {
        this.graphicsPanel = graphicsPanel;
    }


    public GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }


    public ArrayList<Hitter> getBattingOrder() {
        return battingOrder;
    }


    public int getRunsAllowed() {
        return runsAllowed;
    }


    public int getInning() {
        return inning;
    }


    public int getOuts() {
        return outs;
    }


    public boolean isGameOver() {
        return gameOver;
    }
    public String getCurrentHitter() {
        return currentHitter.getName();
    }
    public AtBat getCurrentAtBat() {
        return currentAtBat;
    }


    public void playNextAtBat() {
        placeInLineup = (placeInLineup + 1) % battingOrder.size();
        currentHitter = battingOrder.get(placeInLineup);
        currentAtBat = new AtBat(pitcher, currentHitter, this);
        currentAtBat.startAB();
        graphicsPanel.updateDisplay();
    }



    // add names
    private void initializeBattingOrder() {
        battingOrder = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            battingOrder.add(new Hitter("Hitter " + (i + 1), (int) (Math.random() * 100)));
        }
    }

    public void incrementOuts() {
        outs++;
    }


    public Pitcher getPitcher() {
        return pitcher;
    }
    public void showResultMessage(String message) {
        graphicsPanel.showMessage(message, 2000);
    }
}

