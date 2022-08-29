import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_07_04 {
    public int recursive(int n) {
        if(n == 1) return 1;
        else if(n == 2) return 1;
        else return recursive(n - 2) + recursive(n - 1);
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_04 mc = new problem_07_04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            System.out.print(mc.recursive(i) + " ");
        }
    }
}