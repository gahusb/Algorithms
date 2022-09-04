import java.io.IOException;
import java.util.Scanner;

class problem_08_06 {
    static int[] pm, num, check;
    static int N, M;
    public void DFS(int lvl) {
        if(lvl == M) {
            for(int nv : pm) {
                System.out.print(nv + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(check[i] == 0) {
                pm[lvl] = num[i];
                check[i] = 1;
                DFS(lvl + 1);
                check[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_06 mc = new problem_08_06();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        pm = new int[M];
        num = new int[N];
        check = new int[N];
        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        
        mc.DFS(0);
        sc.close();
    }
}