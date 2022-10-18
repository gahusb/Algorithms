import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaperCount_1780 {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        int c = -1;
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
