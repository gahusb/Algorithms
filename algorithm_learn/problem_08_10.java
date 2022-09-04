import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_08_10 {
    static int[][] board;
    static int N, M, total;
    static int[][] dir = {
        {-1, 0, 1, 0},
        {0, -1, 0, 1}
    };

    public void DFS(int x, int y) {
        if(x == 7 && y == 7) {
            total++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dir[0][i];
            int ny = y + dir[1][i];
            if(1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                DFS(nx, ny);
                board[nx][ny] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_10 mc = new problem_08_10();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[8][8];
        for(int i = 1; i <= 7; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        total = 0;
        board[1][1] = 1;
        mc.DFS(1, 1);
        System.out.println(total);
    }
}