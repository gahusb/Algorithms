import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SharkPrimary_21608 {
    static int N;
    static int[][] seats, favor;
    static int[][] dir = {
        {0, 1, 0, -1},
        {1, 0, -1, 0}
    };
    public static int checkFavor(int x, int y, int idx) {
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[0][i];
            int ny = y + dir[1][i];
            if(nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
            for(int j = 0; j < 4; j++) {
                if(favor[idx][j] == seats[nx][ny]) cnt++;
            }
        }

        return cnt++;
    }
    public static int solution() {
        int answer = 0;


        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        seats = new int[N + 1][N + 1];
        favor = new int[N * N][4];

        for(int i = 0; i < N * N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                favor[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
