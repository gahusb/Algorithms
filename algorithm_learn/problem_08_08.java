import java.io.IOException;
import java.util.Scanner;

class problem_08_08 {
    static int[] b, p, check;
    static int[][] memo;
    static int N, F;
    static boolean flag;
    public static int combi(int n, int r) {
        if(memo[n][r] != 0) return memo[n][r];
        if(n == r || r == 0) return 1;
        else return memo[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int lvl, int sum) {
        if(flag) return;
        if(lvl == N) {
            if(sum == F) {
                for(int x : p) {
                    System.out.print(x + " ");
                }
                System.out.println();
                flag = true;
            }
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(check[i] == 0) {
                check[i] = 1;
                p[lvl] = i;
                DFS(lvl + 1, sum + (p[lvl] * b[lvl]));
                check[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_08 mc = new problem_08_08();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        F = sc.nextInt();
        b = new int[N];
        p = new int[N];
        check = new int[N + 1];
        memo = new int[N + 1][N + 1];
        
        for(int i = 0; i < N; i++) {
            b[i] = combi(N - 1, i);
        }
        
        flag = false;
        mc.DFS(0, 0);
        sc.close();
    }
}