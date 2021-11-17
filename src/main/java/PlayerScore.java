/**
 * @author ahmed
 * PlayerScore is a representation of the scores obtained by the player during the match
 */
public class PlayerScore {

    /**
     * the name of the player
     */
    private String name;
    /**
     * currentGameScore represents the score of the current game
     */
    private GameScore currentGameScore = GameScore.LOVE;
    /**
     * setsScore is an array of int represents the score points by set
     */
    private int[] setsScore;

    public PlayerScore(String name, int nbSets) {
        this.name = name;
        this.setsScore =  new int[nbSets];
    }

    public String getName() {
        return name;
    }


    public GameScore getCurrentGameScore() {
        return currentGameScore;
    }

    public PlayerScore resetGameScore() {
        this.currentGameScore = GameScore.LOVE;
        return this;
    }

    public void setCurrentGameScore(GameScore currentGameScore) {
        this.currentGameScore = currentGameScore;
    }

    public PlayerScore addOneSetPoint(int indexSet) {
         this.setsScore[indexSet]++;
         return this;
    }

    public int getSetScoreByIndex(int indexSet){
        return this.setsScore[indexSet];
    }

    public int[] getSetScore(){
        return this.setsScore;
    }

    /**
     *
     * @param isWin
     * @param oppositeGameScore
     * @param currentSetPlay
     */
    public void nextGameScore(boolean isWin, GameScore oppositeGameScore, int currentSetPlay) {
        GameScore nextGameScore = this.currentGameScore.nextGameScore(isWin, oppositeGameScore);
        if(nextGameScore == GameScore.LOVE && isWin){
            this.addOneSetPoint(currentSetPlay);
        }
        this.currentGameScore = nextGameScore;
    }
}
