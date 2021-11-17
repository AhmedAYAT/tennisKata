/**
 * @author ahmed
 * GameScore is an enum to represent the current score in one game 0, 15, 30, 40, deuce, AV
 *
 */
public enum GameScore {
    LOVE(1, "0"){
        @Override
        GameScore nextGameScore(boolean isWin, GameScore oppositePlayerGameScore) {
            return isWin ? GameScore.FIFTEEN : GameScore.LOVE;
        }
    },
    FIFTEEN(2, "15") {
        @Override
        GameScore nextGameScore(boolean isWin, GameScore oppositePlayerGameScore) {
            return isWin ? GameScore.THIRTY :
                    ((oppositePlayerGameScore == GameScore.FORTY) ? GameScore.LOVE : GameScore.FIFTEEN);
        }
    },
    THIRTY(3,"30") {
        @Override
        GameScore nextGameScore(boolean isWin, GameScore oppositePlayerGameScore) {
            return isWin ?
                    ((oppositePlayerGameScore == GameScore.FORTY) ? GameScore.DEUCE : GameScore.FORTY)
                    : ((oppositePlayerGameScore == GameScore.FORTY) ? GameScore.LOVE : GameScore.THIRTY);
        }
    },
    FORTY(4,"40") {
        @Override
        GameScore nextGameScore(boolean isWin, GameScore oppositePlayerGameScore) {
            return isWin ? GameScore.LOVE :
                    ((oppositePlayerGameScore == GameScore.THIRTY) ? GameScore.DEUCE : GameScore.FORTY);
        }
    },
    DEUCE(4,"deuce") {
        @Override
        GameScore nextGameScore(boolean isWin, GameScore oppositePlayerGameScore) {
            return isWin ? (oppositePlayerGameScore == GameScore.ADVANTAGE ? GameScore.DEUCE : GameScore.ADVANTAGE) :
                    (oppositePlayerGameScore == GameScore.ADVANTAGE ? GameScore.LOVE : GameScore.DEUCE);
        }
    },
    ADVANTAGE(5, "advantage") {
        @Override
        GameScore nextGameScore(boolean isWin, GameScore oppositePlayerGameScore) {
            return isWin ? GameScore.LOVE : GameScore.DEUCE;
        }
    };

    private final String displayValue;
    private final int weight;

    GameScore(int weight, String displayValue) {
        this.weight = weight;
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public int getWeight() {
        return weight;
    }

    /**
     *
     * @param isWin
     * @param oppositePlayerGameScore
     * @return the next GameScore
     */
    abstract GameScore nextGameScore(boolean isWin, GameScore oppositePlayerGameScore);

}
