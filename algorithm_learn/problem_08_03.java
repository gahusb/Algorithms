import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_08_03 {
    static int[][] problem;
    static int N, M;
    static int max;
    public void DFS(int score, int time, int lvl) {
        if(time > M) return;
        if(lvl == N) {
            max = Math.max(max, score);
            return;
        }

        DFS(score + problem[lvl][0], time + problem[lvl][1], lvl + 1);
        DFS(score, time, lvl + 1);
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_03 mc = new problem_08_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        problem = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            problem[i][0] = Integer.parseInt(st.nextToken());
            problem[i][1] = Integer.parseInt(st.nextToken());
        }
        
        max = Integer.MIN_VALUE;
        mc.DFS(0, 0, 0);
        System.out.println(max);
    }
}