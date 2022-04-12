import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MagicianShark_Windblows_21610 {
    static int N, M;
    static int[][] map;
    static int[][] dir = {  // 0은 빈칸, 좌, 좌상, 상, 우상, 우, 우하, 하, 좌하
        {0, 0, -1, -1, -1, 0, 1, 1, 1},
        {0, -1, -1, 0, 1, 1, 1, 0, -1}
    };
    static int[][] checkBucket = {
        {-1, -1, 1, 1},
        {-1, 1, -1, 1}
    };
    static int[][] command;
    static Queue<Cloud> cloud;
    public static void moveCloud(int d, int s) {
        int size = cloud.size();

        while(size > 0) {
            Cloud tmp = cloud.poll();
            int nr = tmp.r + (dir[0][d] * s);
            int nc = tmp.c + (dir[1][d] * s);

            // 이어붙인 공간 넘어가기
            while(nr <= 0) nr = N + nr;
            while(nc <= 0) nc = N + nc;
            while(nr > N) nr = nr - N;
            while(nc > N) nc = nc - N;

            cloud.add(new Cloud(nr, nc));
            size--;
        }
    }
    public static void rainncopywater() {
        boolean[][] rain = new boolean[N + 1][N + 1];

        while(!cloud.isEmpty()) {
            Cloud tmp = cloud.poll();
            map[tmp.r][tmp.c]++;
            rain[tmp.r][tmp.c] = true;

            // 물 복사 마법
            int cnt = 0;
            for(int i = 0; i < 4; i++) {
                int nr = tmp.r + checkBucket[0][i];
                int nc = tmp.c + checkBucket[1][i];
                if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;
                if(map[nr][nc] > 0) cnt++; 
            }
            map[tmp.r][tmp.c] += cnt;
        }

        makeCloud(rain);
    }
    public static void makeCloud(boolean[][] rain) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!rain[i][j] && map[i][j] > 2) {
                    cloud.add(new Cloud(i, j));
                    map[i][j] -= 2;
                }
            }
        }
    }
    public static void solution() {
        for(int i = 0; i < M; i++) {
            moveCloud(command[i][0], command[i][1]);
            rainncopywater();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        command = new int[M][2];

        cloud = new LinkedList<Cloud>();

        cloud.add(new Cloud(N, 1));
        cloud.add(new Cloud(N, 2));
        cloud.add(new Cloud(N - 1, 1));
        cloud.add(new Cloud(N - 1, 2));
        
        for(int i = 1; i <= N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            command[i][0] = Integer.parseInt(st.nextToken());
            command[i][1] = Integer.parseInt(st.nextToken());
        }

        solution();

        int result = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
    }
}

class Cloud {
    int r, c;   // 위치 정보 초기 (N, 1), (N, 2), (N-1, 1), (N-1, 2)
    public Cloud(int r, int c) {
        this.r = r;
        this.c = c;
    }
}