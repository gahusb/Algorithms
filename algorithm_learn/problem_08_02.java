import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_08_02 {
    static int[] baduk;
    static int N, M;
    static long max;
    public void DFS(long curr, int lvl) {
        if(curr > N) return;
        if(lvl == M) {
            if(max < curr) max = curr;
            return;
        }

        DFS(curr + baduk[lvl], lvl + 1);
        DFS(curr, lvl + 1);
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_02 mc = new problem_08_02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        baduk = new int[M];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            baduk[i] = Integer.parseInt(st.nextToken());
        }
        
        max = Long.MIN_VALUE;
        mc.DFS(0, 0);
        System.out.println(max);
    }
}