import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Theater_2302 {
    public static int seat[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        seat = new int[N + 1];

        seat[0] = 1;
        seat[1] = 1;
        seat[2] = 2;
        for(int i = 3; i <= N; i++) {
            seat[i] = seat[i - 1] + seat[i - 2];
        }
        
        int result = 1, prev = 0;
        for(int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());
            result *= seat[temp - prev - 1];
            prev = temp;
        }
        result *= seat[N - prev];

        System.out.println(result);
    }
}
