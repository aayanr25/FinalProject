public class Main {
    public static void main (String[] args) {
        Game game = new Game();
        game.setPitcher(new Pitcher(game));
        MainFrame m = new MainFrame(game);
        SecondFrame s = new SecondFrame(game);
    }
}

