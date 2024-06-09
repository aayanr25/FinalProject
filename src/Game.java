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
        if (currentAtBat.isABOver()) {
            handleBasepaths();
        }
        if (outs >= 3) {
            inning++;
            outs = 0;
            showResultMessage("INNING " + inning);
        }
        placeInLineup = (placeInLineup + 1) % battingOrder.size();
        currentHitter = battingOrder.get(placeInLineup);
        currentAtBat = new AtBat(pitcher, currentHitter, this);
        currentAtBat.startAB();
        graphicsPanel.updateDisplay();
    }

    private void handleBasepaths() {
        String outcome = currentAtBat.getOutcome();
        if (outcome.equals("Single")) {
            if (onThird) {
                runsAllowed++;
                onThird = false;
            }
            if (onSecond) {
                onThird = true;
                onSecond = false;
            }
            if (onFirst) {
                onSecond = true;
            }
            onFirst = true;
        } else if (outcome.equals("Double")) {
            if (onThird) {
                runsAllowed++;
                onThird = false;
            }
            if (onSecond) {
                runsAllowed++;
                onSecond = false;
            }
            if (onFirst) {
                onThird = true;
                onFirst = false;
            }
            onSecond = true;
        } else if (outcome.equals("Home Run")) {
            if (onThird) {
                runsAllowed++;
                onThird = false;
            }
            if (onSecond) {
                runsAllowed++;
                onSecond = false;
            }
            if (onFirst) {
                runsAllowed++;
                onFirst = false;
            }
            runsAllowed++;
        } else if (outcome.equals("Walk")) {
            if (onFirst && onSecond && onThird) {
                runsAllowed++;
            } else if (onFirst && onSecond) {
                onThird = true;
            } else if (onFirst) {
                onSecond = true;
            }
            onFirst = true;
        } else {

        }

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

