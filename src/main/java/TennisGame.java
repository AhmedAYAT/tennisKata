import java.util.Arrays;

/**
 * @author ahmed
 * TennisGame implements the principals behaviour described in the KATA
 * TennisGame is simplified representation of a tennis match
 *
 */
public class TennisGame implements ITennisGame {

    private PlayerScore player1;
    private PlayerScore player2;
    private int currentSetPlay = 0;
    private int maxSetPlay = 0;

    public TennisGame(String player1, String player2, int nbMaxSets) {
        this.player1 = new PlayerScore(player1, nbMaxSets);
        this.player2 = new PlayerScore(player2, nbMaxSets);
        this.maxSetPlay = nbMaxSets;
    }

    @Override
    public void wonPoint(String playerName) {
        PlayerScore winner;
        PlayerScore loser ;
        if(playerName.equals(player1.getName())){
            winner = player1;
            loser = player2;
        }else{
            winner = player2;
            loser = player1;
        }
        final GameScore looserCurrentGameScore = loser.getCurrentGameScore();
        final GameScore winnerCurrentGameScore = winner.getCurrentGameScore();
        winner.nextGameScore(true, looserCurrentGameScore, currentSetPlay);
        loser.nextGameScore(false, winnerCurrentGameScore, currentSetPlay);
        if(isSetFinalWinPoint(winner, loser) && currentSetPlay < maxSetPlay){
            currentSetPlay++;
        }
    }

    private boolean isSetFinalWinPoint(PlayerScore winnerPoint, PlayerScore loserPoint) {
        return winnerPoint.getSetScoreByIndex(currentSetPlay) >= 6 &&
                (winnerPoint.getSetScoreByIndex(currentSetPlay) - loserPoint.getSetScoreByIndex(currentSetPlay) == 2);
    }

    public int getCurrentSetPlay() {
        return currentSetPlay;
    }

    public int getMaxSetPlay() {
        return maxSetPlay;
    }

    public PlayerScore getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerScore player1) {
        this.player1 = player1;
    }

    public PlayerScore getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerScore player2) {
        this.player2 = player2;
    }

    @Override
    public void printTennisGameCurrentScore() {
            System.out.printf("Player 1: %s\n", player1.getName());
            System.out.printf("Player 2: %s\n", player2.getName());
            String s = "";
            int limit = currentSetPlay < maxSetPlay ? currentSetPlay : maxSetPlay-1;
            for(int i=0 ; i<= limit ; i++){
                s+=String.format("(%d-%d)",player1.getSetScoreByIndex(i), player2.getSetScoreByIndex(i));
            }
            System.out.printf("Score  : %s\n", s);
            if(currentSetPlay < maxSetPlay){
                System.out.printf("Current game status : %s\n", printCurrentGameStatus());
            }
    }

    private String printCurrentGameStatus() {
        if(!Arrays.asList(GameScore.DEUCE, GameScore.ADVANTAGE).contains(player1.getCurrentGameScore())){
            return String.format("%s-%s", player1.getCurrentGameScore().getDisplayValue(), player2.getCurrentGameScore().getDisplayValue());
        }else if(Arrays.asList(player1.getCurrentGameScore(), player2.getCurrentGameScore()).contains(GameScore.ADVANTAGE)){
            return GameScore.ADVANTAGE.getDisplayValue();
        }else{
            return GameScore.DEUCE.getDisplayValue();
        }
    }


}
