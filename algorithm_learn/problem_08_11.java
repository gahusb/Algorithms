import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class problem_08_11 {
    static int[][] board, check;
    static int min;
    static int[][] dir = {
        {-1, 0, 1, 0},
        {0, -1, 0, 1}
    };

    public int BFS(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        queue.offer(0);

        while(!queue.isEmpty()) {
            int cx = queue.poll();
            int cy = queue.poll();
            int dist = queue.poll();
            if(cx == 7 && cy == 7) {
                min = Math.min(min, dist);
                continue;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cx + dir[0][i];
                int ny = cy + dir[1][i];
                if(1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0 && check[nx][ny] == 0) {
                    queue.offer(nx);
                    queue.offer(ny);
                    queue.offer(dist + 1);
                    check[nx][ny] = 1;
                }
            }
        }

        if(min == Integer.MAX_VALUE) return -1;
        else return min;
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_11 mc = new problem_08_11();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[8][8];
        check = new int[8][8];
        for(int i = 1; i <= 7; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        min = Integer.MAX_VALUE;
        board[1][1] = 1;
        System.out.println(mc.BFS(1, 1));
    }
}