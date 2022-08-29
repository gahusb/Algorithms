import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_07_01 {
    public void recursive(int n) {
        if(n == 0) return;
        else {
            recursive(n - 1);
            System.out.print(n + " ");
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_01 mc = new problem_07_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        mc.recursive(N);
    }
}