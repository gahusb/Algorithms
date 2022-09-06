import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class problem_08_12 {
    static int[][] box, dis;
    static int N, M;
    static Queue<Tomato> queue;
    static int[][] dir = {
        {-1, 0, 1, 0},
        {0, -1, 0, 1}
    };
    
    public void BFS() {
        while(!queue.isEmpty()) {
            Tomato tmp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dir[0][i];
                int ny = tmp.y + dir[1][i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    queue.offer(new Tomato(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_12 mc = new problem_08_12();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        dis = new int[N][M];
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                    box[i][j] = -1;
                }
            }
        }

        int day = 0;
        mc.BFS();
        
        boolean flag = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }

        if(flag) System.out.println(-1);
        else {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    day = Math.max(day, dis[i][j]);
                }
            }
            System.out.println(day);
        }
    }
}

class Tomato {
    int x, y;
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}