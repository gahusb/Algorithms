import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class problem_08_13_BFS {
    static int N, island;
    static Queue<Point> queue;
    static int[][] dir = {
        {-1, -1, 0, 1, 1, 1, 0, -1},
        {0, 1, 1, 1, 0, -1, -1, -1}
    };
    
    public void BFS(int x, int y, int[][] board) {
        queue.offer(new Point(x, y));
        while(!queue.isEmpty()) {
            Point tmp = queue.poll();
            for(int i = 0; i < 8; i++) {
                int nx = tmp.x + dir[0][i];
                int ny = tmp.y + dir[1][i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    island++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_13_BFS mc = new problem_08_13_BFS();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        queue = new LinkedList<>();
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

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}