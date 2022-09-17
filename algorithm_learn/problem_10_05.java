import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_10_05 {
    static int[] dy, coin;
    public int solution(int n, int m) {
        dy[0] = 0;
        for(int i = 0; i < n; i++) {
            int c = coin[i];
            for(int j = c; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }

        return dy[m];
    }
    
    public static void main(String[] args) throws IOException {
        problem_10_05 mc = new problem_10_05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        coin = new int[N];

        if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        dy = new int[M + 1];
        for(int i = 0; i <= M; i++) dy[i] = Integer.MAX_VALUE;

        System.out.println(mc.solution(N, M));
    }
}