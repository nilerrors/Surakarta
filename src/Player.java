import java.util.ArrayList;

public class Player {
    public enum PLAYER {
        RED,
        YELLOW,
        EMPTY
    }

    public final static int MAX_PLAYER_PIECES = 12;

    PLAYER playerType;
    SurakartaBoard.Position position;

    int id;

    public Player(int id) {
        this.id = id;
        playerType = PLAYER.EMPTY;
    }

    public Player(int id, PLAYER player) {
        this.id = id;
        playerType = player;
        position = new SurakartaBoard.Position(0, 0);
    }

    public ArrayList<SurakartaBoard.Position> captures(SurakartaBoard board) {
        ArrayList<SurakartaBoard.Position> allCapturePositions = new ArrayList<SurakartaBoard.Position>();

        ArrayList<SurakartaBoard.Position> allPossibleTunnels = new ArrayList<SurakartaBoard.Position>();
        // right tunnel check
        for (int i = this.position.col; i < SurakartaBoard.ROW_SIZE; i++) {

        }
        // left tunnel check

        // upper tunnel check

        // bottom tunnel check

        return allCapturePositions;
    }
}