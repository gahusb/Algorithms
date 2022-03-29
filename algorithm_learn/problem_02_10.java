import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_02_10 {
    public int[][] dir = {
        {1, 0, -1, 0},
        {0, 1, 0, -1}
    };
    public int solution(int[][] map) {
        int answer = 0;
        int len = map.length;
        
        for(int i = 1; i < len; i++) {
            for(int j = 1; j < len; j++) {
                int tmp = 0;
                for(int k = 0; k < 4; k++) {
                    int rx = i + dir[0][k];
                    int ry = j + dir[1][k];
                    if(0 <= rx && rx < len && 0 <= ry && ry < len) {
                        if(map[i][j] > map[rx][ry]) {
                            tmp++;
                            continue;
                        } else break;
                    } else break;
                }
                if(tmp == 4) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_02_10 mc = new problem_02_10();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 2][N + 2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(mc.solution(map));
    }
}
