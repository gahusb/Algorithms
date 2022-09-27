import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DigitJump_2210 {
    static int[][] dir = {
        {0, 1, 0, -1},
        {1, 0, -1, 0}
    };
    static HashSet<Integer> digits;
    static void DFS(int[][] board, int r, int c, int len, int digit) {
        if(len >= 6) {
            digits.add(digit);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nr = r + dir[0][i];
            int nc = c + dir[1][i];
            if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
            DFS(board, nr, nc, len + 1, digit * 10 + board[nr][nc]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int[][] board = new int[5][5];

        for(int i = 0; i < 5; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        digits = new HashSet<Integer>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                DFS(board, i, j, 1, board[i][j]);
            }
        }
        System.out.println(digits.size());
    }
}
