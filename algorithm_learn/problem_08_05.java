import java.io.IOException;
import java.util.Scanner;

class problem_08_05 {
    static int[] coin;
    static int N, M, min;
    public void DFS(int sum, int cnt) {
        if(sum > M) return;
        if(cnt > min) return;
        if(sum == M) {
            min = Math.min(min, cnt);
            return;
        }

        for(int i = N - 1; i >= 0; i--) {
            DFS(sum + coin[i], cnt + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_05 mc = new problem_08_05();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        coin = new int[N];
        for(int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }
        M = sc.nextInt();
        
        min = Integer.MAX_VALUE;
        mc.DFS(0, 0);
        System.out.println(min);
        sc.close();
    }
}