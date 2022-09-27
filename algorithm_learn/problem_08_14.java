import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class problem_08_14 {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int N, M, len, answer;
    static int[] combi;
    static ArrayList<Point> home, pizza;
    static int[][] dir = {
        {-1, -1, 0, 1, 1, 1, 0, -1},
        {0, 1, 1, 1, 0, -1, -1, -1}
    };

    public int calcDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public void DFS(int L, int s) { // 조합을 구한다.
        if(L == M) {
            int sum = 0;
            for(Point h : home) {
                int dis = Integer.MAX_VALUE;
                for(int idx : combi) {
                    dis = Math.min(dis, calcDist(h.x, h.y, pizza.get(idx).x, pizza.get(idx).y));
                }
                sum += dis;
            }

            answer = Math.min(answer, sum);
            return;
        }

        for(int i = s; i < len; i++) {
            combi[L] = i;
            DFS(L + 1, i + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_14 mc = new problem_08_14();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        pizza = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) home.add(new Point(i, j));
                else if(tmp == 2) pizza.add(new Point(i, j));
            }
        }
        answer = Integer.MAX_VALUE;
        len = pizza.size();
        combi = new int[M];
        mc.DFS(0, 0);
        System.out.println(answer);
    }
}