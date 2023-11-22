
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score;
        if (isTie())
            score = getTieScore();
        else if (isOneScoreGreaterEqual4())
            score = getAdvantageScore();
        else
        {
            score = getScoreBoard();
        }
        return score;
    }

    private String getScoreBoard() {
        return getScoreStringFromScore(player1Score) + "-" + getScoreStringFromScore(player2Score);
    }

    private String getScoreStringFromScore(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }

    private String getAdvantageScore() {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1)
            score = "Advantage " + player1Name;
        else if (minusResult == -1)
            score = "Advantage " + player2Name;
        else if (minusResult >= 2)
            score = "Win for " + player1Name;
        else
            score = "Win for " + player2Name;
        return score;
    }

    private boolean isOneScoreGreaterEqual4() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isTie() {
        return player1Score == player2Score;
    }

    private String getTieScore() {
        return switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
