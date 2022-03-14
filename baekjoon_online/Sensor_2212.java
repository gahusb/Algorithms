import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sensor_2212 {
    static int[] sensors;
    static int[] diff;
    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        sensors = new int[N];
        diff = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        if(K >= N) System.out.println("0");
        else {
            Arrays.sort(sensors);

            for(int i = 0; i < N - 1; i++) {
                diff[i] = sensors[i + 1] - sensors[i];
            }

            Arrays.sort(diff);

            int answer = 0;

            for(int i = 0; i < N - K; i++) {
                answer += diff[i];
            }

            System.out.println(answer);
        }
    }
}
