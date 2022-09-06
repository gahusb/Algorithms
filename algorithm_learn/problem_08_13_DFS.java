import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_08_13_DFS {
    static int N, island;
    static int[][] dir = {
        {-1, -1, 0, 1, 1, 1, 0, -1},
        {0, 1, 1, 1, 0, -1, -1, -1}
    };
    
    public void DFS(int x, int y, int[][] board) {
        for(int i = 0; i < 8; i++) {
            int nx = x + dir[0][i];
            int ny = y + dir[1][i];
            if(0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    island++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_13_DFS mc = new problem_08_13_DFS();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        island = 0;
        mc.solution(board);
        System.out.println(island);
    }
}