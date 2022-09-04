import java.io.IOException;
import java.util.Scanner;

class problem_08_07 {
    static int[][] memo;
    public int DFS(int n, int r) {
        if(memo[n][r] != 0) return memo[n][r];
        if(n == r || r == 0) return 1;
        return memo[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_07 mc = new problem_08_07();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        memo = new int[N + 1][N + 1];
        
        mc.DFS(N, R);
        System.out.println(memo[N][R]);
        sc.close();
    }
}