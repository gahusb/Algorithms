import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_07_03 {
    public int recursive(int n) {
        if(n == 1) return 1;
        else return n * recursive(n - 1);
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_03 mc = new problem_07_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        System.out.println(mc.recursive(N));
    }
}