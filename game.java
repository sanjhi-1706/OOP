package Hello;



/**
 * Represents a Craps game with its rules and outcomes.
 */
public class game {
    private Die die1;
    private Die die2;
    private GameStatus gameStatus;
    private int point;

    public game() {
        this.die1 = new Die();
        this.die2 = new Die();
        this.gameStatus = GameStatus.CONTINUE;
        this.point = 0;
    }

    public void rollDice() {
        int die1Value = die1.roll();
        int die2Value = die2.roll();
        int sum = die1Value + die2Value;

        switch (sum) {
            case 7:
            case 11:
                gameStatus = GameStatus.WIN;
                break;
            case 2:
            case 3:
            case 12:
                gameStatus = GameStatus.LOSE;
                break;
            default:
                point = sum;
                gameStatus = GameStatus.POINT_SET;
                break;
        }
    }

    public void rollForPoint() {
        int die1Value = die1.roll();
        int die2Value = die2.roll();
        int sum = die1Value + die2Value;

        if (sum == point) {
            gameStatus = GameStatus.WIN;
        } else if (sum == 7) {
            gameStatus = GameStatus.LOSE;
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getPoint() {
        return point;
    }
}

/**
 * Enum representing the game status.
 */
enum GameStatus {
    WIN,
    LOSE,
    CONTINUE,
    POINT_SET
}


