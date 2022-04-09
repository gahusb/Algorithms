import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hellhoseok_20166 {
    static int N, M, K;
    static char[][] cloud;
    static int[][] dir = { // 배열 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
        {-1, 1, 0, 0, -1, -1, 1, 1},
        {0, 0, -1, 1, -1, 1, -1, 1}
    };
    static int[] result;

    public static void solution(int x, int y, String[] keywords) {
        Queue<Words> q = new LinkedList<>();
        q.add(new Words(x, y, 1, cloud[x][y]+""));

        while(!q.isEmpty()) {
            Words tmpW = q.poll();

            if(tmpW.len > 5) continue;

            for(int j = 0; j < K; j++) {
                if(keywords[j].equals(tmpW.str)) {
                    result[j]++;
                }
            }

            for(int i = 0; i < 8; i++) {
                int nx = tmpW.x + dir[0][i];
                int ny = tmpW.y + dir[1][i];

                if(nx == 0) nx = N;
                if(ny == 0) ny = M;
                if(nx > N) nx = 1;
                if(ny > M) ny = 1;

                q.add(new Words(nx, ny, tmpW.len + 1, tmpW.str + cloud[nx][ny]));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cloud = new char[N + 1][M + 1];
        result = new int[K];

        String tmp = "";
        for(int i = 1; i <= N; i++) {
            tmp = br.readLine();
            for(int j = 1; j <= M; j++) {
                cloud[i][j] = tmp.charAt(j - 1);
            }
        }

        String[] keywords = new String[K];
        for(int i = 0; i < K; i++) {
            tmp = br.readLine();
            keywords[i] = tmp;

        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                solution(i, j, keywords);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb.toString());
    }
}

class Words {
    int x;
    int y;
    int len;
    String str;
    public Words(int x, int y, int len, String str) {
        this.x = x;
        this.y = y;
        this.len = len;
        this.str = str;
    }
}