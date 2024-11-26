package Hello;

public class Main {
    public static void main(String[] args) {
        game game = new game();

        game.rollDice();
        GameStatus gameStatus = game.getGameStatus();

        if (gameStatus == GameStatus.POINT_SET) {
            System.out.println("Point set: " + game.getPoint());
            while (gameStatus == GameStatus.POINT_SET) {
                game.rollForPoint();
                gameStatus = game.getGameStatus();
            }
        }

        if (gameStatus == GameStatus.WIN) {
            System.out.println("You win!");
        } else if (gameStatus == GameStatus.LOSE) {
            System.out.println("You lose!");
        }
    }
}
