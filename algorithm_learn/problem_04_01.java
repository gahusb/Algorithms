import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_04_01 {
    public int solution(int n, String str) {
        int result = Integer.MIN_VALUE;


        return result;
    }
    public static void main(String[] args) throws IOException {
        problem_04_01 mc = new problem_04_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        System.out.println(mc.solution(N, str));
    }
}
