import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Area_2583 {
    static class Area {
        int x1, y1, x2, y2;
        public Area(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static int[][] dir = {
        {0, 1, -1, 0},
        {1, 0, 0, -1}
    };

    static int M, N, K;
    static int[][] check;
    static ArrayList<Area> areas;

    public static boolean isArea(int x, int y) {
        for(Area area : areas) {
            if(area.x1 > x || area.x2 < x || area.y1 > y || area.y2 < y) return false;
        }
        return true;
    }

    public static void solution() {
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(check[i][j] == 0) {
                    cnt++;
                    list.add(DFS(i, j, 1));
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);
        for(int i : list) System.out.print(i + " ");
    }

    public static int DFS(int x, int y, int len) {
        for(int i = 0; i < 4; i++) {
            int tx = x + dir[0][i];
            int ty = y + dir[0][i];
            if(tx >= 0 && ty >= 0 && tx < M && ty < N && check[tx][ty] == 0 && isArea(tx, ty)) {
                check[tx][ty] = 1;
                DFS(tx, ty, len + 1);
            }
        }

        return len;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        areas = new ArrayList<>();
        check = new int[M][N];

        for(int i = 0; i < K; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            areas.add(new Area(a, b, c, d));
        }

        solution();
    }
}