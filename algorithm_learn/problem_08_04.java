import java.io.IOException;
import java.util.Scanner;

class problem_08_04 {
    static int[] num;
    static int N, M;
    public void DFS(int lvl) {
        if(lvl == M) {
            for(int n : num) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            num[lvl] = i;
            DFS(lvl + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_04 mc = new problem_08_04();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[M];
        
        mc.DFS(0);
        sc.close();
    }
}