import java.io.IOException;
import java.util.Scanner;

class problem_03_05 {
    public int solution(int n) {
        int result = 0;

        for(int i = 1; i <= n; i++) {
            int tmp = i;
            for(int j = i + 1; j <= n; j++) {
                tmp += j;
                if(tmp > n) break;
                else if(tmp == n) result++;
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        problem_03_05 mc = new problem_03_05();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(mc.solution(N));
    }
}
