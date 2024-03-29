import java.io.IOException;
import java.util.Scanner;

class problem_10_01 {
    static int[] dy;
    public static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n];
    }
    
    public static void main(String[] args) throws IOException {
        // problem_10_01 mc = new problem_10_01();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dy = new int[N + 1];

        System.out.println(solution(N));
        sc.close();
    }
}