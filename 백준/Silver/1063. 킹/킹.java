import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Pos king, rock;
    static final int BOARD_SIZE = 8;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        king = new Pos(input[0]);
        rock = new Pos(input[1]);
        int N = Integer.parseInt(input[2]);

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            move(command);
        }

        bw.write(king.toChessNotation() + "\n" + rock.toChessNotation());
        bw.flush();
        br.close();
        bw.close();
    }

    static void move(String command) {
        int[] direction = getDirection(command);

        Pos newKingPos = king.move(direction);
        if (!newKingPos.isValid()) return;
        if (newKingPos.equals(rock)) {
            Pos newRockPos = rock.move(direction);
            if (!newRockPos.isValid()) return;
            rock = newRockPos;
        }

        king = newKingPos;
    }

    static int[] getDirection(String command) {
        if(command.equals("R")) return new int[]{1, 0};  // R : 한 칸 오른쪽으로
        else if(command.equals("L")) return new int[]{-1, 0}; // L : 한 칸 왼쪽으로
        else if(command.equals("B")) return new int[]{0, -1}; // B : 한 칸 아래로
        else if(command.equals("T")) return new int[]{0, 1};  // T : 한 칸 위로
        else if(command.equals("RT")) return new int[]{1, 1}; // RT : 오른쪽 위 대각선으로
        else if(command.equals("LT")) return new int[]{-1, 1}; // LT : 왼쪽 위 대각선으로
        else if(command.equals("RB")) return new int[]{1, -1}; // RB : 오른쪽 아래 대각선으로
        else if(command.equals("LB")) return new int[]{-1, -1}; // LB : 왼쪽 아래 대각선으로
        else return new int[]{0, 0};
    }

    static class Pos {
        int x, y; // x: column (A-H), y: row (1-8)
        Pos(String chessNotation) {
            this.x = chessNotation.charAt(0)-'A';
            this.y = chessNotation.charAt(1)-'1';
        }
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Pos move(int[] direction) {
            return new Pos(this.x + direction[0], this.y + direction[1]);
        }
        //'8' : 56 '1' : 49 최대 7
        boolean isValid() {
            return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
        }
        boolean equals(Pos o) {
            return this.x == o.x && this.y == o.y;
        }
        String toChessNotation() {
            return (char) (x + 'A') + "" + (y + 1);
        }
    }
}
