import java.util.LinkedList;

public class clock {
    static int dr[][] = {
        // 0 : clock, 1 : reverse
        {0, 1, 0, -1},
        {1, 0, -1, 0}
    };
    static int dc[][] = {
        // 0 : clock, 1 : revelse
        {1, 0, -1, 0},
        {0, 1, 0, -1}
    };
    static int[][] map = new int[1000][1000];
    static LinkedList<POINT> qu = new LinkedList<POINT>();

    public static int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        int clockDir = 0;
        if(clockwise == false) clockDir = 1;

        // 1. 시작 4개의 포인트 qu에 삽입
        if(clockwise == true) {
            // clock
            qu.add(new POINT(0, 0, 1, 0));
            map[0][0] = 1;
            qu.add(new POINT(0, n - 1, 1, 1));
            map[0][n-1] = 1;
            qu.add(new POINT(n - 1, n - 1, 1, 2));
            map[n-1][n-1] = 1;
            qu.add(new POINT(n - 1, 0, 1, 3));
            map[n-1][0] = 1;
        } else {
            // reverse
            qu.add(new POINT(0, 0, 1, 0));
            map[0][0] = 1;
            qu.add(new POINT(n - 1, 0, 1, 1));
            map[n-1][0] = 1;
            qu.add(new POINT(n - 1, n - 1, 1, 2));
            map[n-1][n-1] = 1;
            qu.add(new POINT(0, n - 1, 1, 3));
            map[0][n-1] = 1;
        }

        while(!qu.isEmpty()) {
            int squ = qu.size();
            for(int i = 0; i < squ; i++) {
                POINT temp = qu.poll();

                int nr = temp.r + dr[clockDir][temp.dir];
                int nc = temp.c + dc[clockDir][temp.dir];

                if((nr < 0 || nc < 0 || nr >= n || nc >= n) || map[nr][nc] != 0) {
                    // map 안에 없고, 소용돌이 O - 방향 전환
                    temp.dir++;
                    if(temp.dir >= 4) temp.dir = 0;

                    nr = temp.r + dr[clockDir][temp.dir];
                    nc = temp.c + dc[clockDir][temp.dir];
                }

                if((nr >= 0 || nc >= 0 || nr < n || nc < n) && map[nr][nc] == 0) {
                    // map 안에 있고, 소용돌이 X - go
                    map[nr][nc] = temp.num + 1;
                    qu.add(new POINT(nr, nc, temp.num + 1, temp.dir));
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
        return answer;
    }
    public static void main(String[] args) {
        solution(5, true);
    }

    public static class POINT {
        int r, c, num, dir;
        public POINT(int r, int c, int num, int dir) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
        }
    }
}
