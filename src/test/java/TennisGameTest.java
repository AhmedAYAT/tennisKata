
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
class TennisGameTest {

    public static final String PLAYER1 = "NADAL";
    public static final String PLAYER2 = "DJOKOVIC";
    public static final int MAX_SETS = 5;
    private TennisGame tennisGame;

    @BeforeEach
    public  void init(){
       this.tennisGame = new TennisGame(PLAYER1, PLAYER2, MAX_SETS);
    }

    @Test
    void test_3_wins_consecutive_() {
        //Given
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER1);
        //when
        //then
        assertTrue(tennisGame.getPlayer1().getCurrentGameScore() == GameScore.FORTY);
    }

    @Test
    void test_Deuce() {
        //Given
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        //when
        //then
        assertTrue(tennisGame.getPlayer1().getCurrentGameScore() == GameScore.DEUCE);
    }

    @Test
    void test_advantage_for_player_2() {
        //Given
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER2);
        //when
        //then
        assertTrue(tennisGame.getPlayer2().getCurrentGameScore() == GameScore.ADVANTAGE);
    }

    @Test
    void test_deuce_after_gaining_advantage_for_player_2() {
        //Given
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        //when
        //then
        assertTrue(tennisGame.getPlayer2().getCurrentGameScore() == GameScore.DEUCE);
    }

    @Test
    void test_wining_game_for_player_2() {
        //Given
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER1);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER2);
        tennisGame.wonPoint(PLAYER2);
        //when
        //then
        assertTrue(tennisGame.getPlayer2().getSetScoreByIndex(0) == 1);
    }
}
