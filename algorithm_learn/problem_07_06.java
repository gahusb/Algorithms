import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_07_06 {
    static int[] check;
    public void recursive(int n, int L) {
        if(L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++) {
                if(check[i] == 1) sb.append(i + " ");
            }
            System.out.println(sb.toString());
            return;
        } else {
            check[L] = 1;
            recursive(n, L + 1);    // left
            check[L] = 0;
            recursive(n, L + 1);    // right
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_06 mc = new problem_07_06();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        check = new int[N + 1];

        mc.recursive(N, 1);
    }
}