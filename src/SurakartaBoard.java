import java.util.HashMap;

public class SurakartaBoard {
    public static class Position {
        public int row;
        public int col;

        Position(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }

    public static final HashMap<Position, Position> tunnels = new HashMap<Position, Position>();
    public static final int ROW_SIZE = 6;
    public static final int COL_SIZE = 6;
    public static final int MAX_BOARD_SIZE = 36;  // 6x6 matrix

    Player[] board = new Player[MAX_BOARD_SIZE];

    public SurakartaBoard() {
        tunnels.put(new Position(0, 3), new Position(2, 5));
        tunnels.put(new Position(2, 5), new Position(0, 3));
        tunnels.put(new Position(2, 0), new Position(0, 2));
        tunnels.put(new Position(0, 2), new Position(2, 0));
        tunnels.put(new Position(5, 2), new Position(3, 0));
        tunnels.put(new Position(3, 0), new Position(5, 2));
        tunnels.put(new Position(3, 5), new Position(5, 3));
        tunnels.put(new Position(5, 3), new Position(3, 5));
        newBoard();
    }

    public Player[] getColumn(int column) {
        Player[] my_column = new Player[6];
        for (int i = 0; i < ROW_SIZE; i++) {
            my_column[i] = getBoardPosition(new Position(i, column));
        }
        return my_column;
    }

    public Player[] getRow(int row) {
        Player[] my_row = new Player[6];
        for (int i = 0; i < COL_SIZE; i++) {
            my_row[i] = getBoardPosition(new Position(row, i));
        }
        return my_row;
    }
    public boolean isTunnel(Position position) {
        for (Position key : tunnels.keySet()) {
            if (key == position) {
                return true;
            }
        }
        return false;
    }

    public boolean isTunnelHorizontal(Position tunnel) {
        return (tunnel.col == 0 || tunnel.col == 5);
    }

    public boolean isTunnelVertical(Position tunnel) {
        return (tunnel.row == 0 || tunnel.row == 5);
    }

    public Position exitTunnel(Position initialTunnel) {
        if (!isTunnel(initialTunnel)) return null;
        return tunnels.get(initialTunnel);
    }

    public void newBoard() {
        for (int i = 0; i < Player.MAX_PLAYER_PIECES; i++) {
            board[i] = new Player(i, Player.PLAYER.RED);
            board[ROW_SIZE * 5 + i] = new Player(i, Player.PLAYER.YELLOW);
        }
    }

    public Player getBoardPosition(Position position) {
        return board[position.row * ROW_SIZE + position.col];
    }

    void setBoardPosition(Position position, Player player) {
        board[position.row * ROW_SIZE + position.col] = player;
    }

    public void display() {

    }
}
