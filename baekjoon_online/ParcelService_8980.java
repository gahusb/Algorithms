import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ParcelService_8980 {
    public int solution(int n, int c, int[][] box) {
        int answer = 0;

        return answer;
    }
    public static void main(String[] args) throws IOException {
        ParcelService_8980 mc = new ParcelService_8980();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] box = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(mc.solution(N, C, box));
    }
}
