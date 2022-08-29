import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_07_04_memoization {
    static int[] fibo;

    public int recursive(int n) {
        if(fibo[n] != 0) return fibo[n];        // 메모이제이션 가지치기
        if(n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = recursive(n - 2) + recursive(n - 1);
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_04_memoization mc = new problem_07_04_memoization();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        fibo = new int[N + 1];

        mc.recursive(N);

        for(int i = 1; i <= N; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}