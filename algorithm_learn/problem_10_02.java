import java.io.IOException;
import java.util.Scanner;

class problem_10_02 {
    static int[] dy;
    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n + 1];
    }
    
    public static void main(String[] args) throws IOException {
        problem_10_02 mc = new problem_10_02();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dy = new int[N + 2];

        System.out.println(mc.solution(N));
        sc.close();
    }
}