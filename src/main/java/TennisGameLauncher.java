import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TennisGameLauncher {

    public static final String PLAYER1 = "NADAL";
    public static final String PLAYER2 = "DJOKOVIC";
    public static final int MAX_SETS = 5;

    public static void main(String[] args) {
        List<String> players = Arrays.asList(PLAYER1, PLAYER2);
        TennisGame tennisGame = new TennisGame(PLAYER1, PLAYER2, MAX_SETS);
        /*   the match finish when we play the max sets,
             as it is described in the kata the match win is not to implement as like as Tie break
         */
        while (tennisGame.getCurrentSetPlay() < MAX_SETS){
            tennisGame.wonPoint(chooseRandomPlayer(players));
            tennisGame.printTennisGameCurrentScore();
        }

    }

    private static String chooseRandomPlayer(List<String> players) {
        Random rand = new Random();
        return players.get(rand.nextInt(players.size()));
    }
}
