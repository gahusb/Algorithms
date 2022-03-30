import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_02_12 {
    public int solution(int n, int m, int[][] score) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                boolean posi = true;
                for(int k = 0; k < m; k++) {
                    int pi = -1, pj = -1;
                    for(int l = 0; l < n; l++) {
                        if(score[k][l] == i) pi = l;
                        if(score[k][l] == j) pj = l;
                    }
                    if(pi > pj) {
                        posi = false;
                        break;
                    }
                }
                if(posi) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_02_12 mc = new problem_02_12();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] score = new int[M][N];
        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(mc.solution(N, M, score));
    }
}
