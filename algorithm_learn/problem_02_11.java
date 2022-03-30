import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_02_11 {
    public int solution(int[][] map) {
        int answer = 0;
        int len = map.length - 1, max = Integer.MIN_VALUE;
        
        for(int i = 1; i <= len; i++) {
            int cnt = 0;
            for(int j = 1; j <= len; j++) {
                for(int k = 1; k <= 5; k++) {
                    if(map[i][k] == map[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_02_11 mc = new problem_02_11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][6];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(mc.solution(map));
    }
}
