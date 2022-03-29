import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_02_09 {
    public int solution(int[][] map) {
        int answer = 0;
        int len = map.length;
        
        int tmp = 0, tmp2 = 0;
        for(int i = 0; i < len; i++) {
            tmp += map[i][i];
            tmp2 += map[i][len - i - 1];
        }
        if(answer < tmp) answer = tmp;
        if(answer < tmp2) answer = tmp2;

        for(int i = 0; i < len; i++) {
            tmp = 0; tmp2 = 0;
            for(int j = 0; j < len; j++) {
                tmp += map[i][j];
                tmp2 += map[j][i];
            }
            if(answer < tmp) answer = tmp;
            if(answer < tmp2) answer = tmp2;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_02_09 mc = new problem_02_09();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(mc.solution(map));
    }
}
