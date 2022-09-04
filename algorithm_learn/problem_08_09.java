import java.io.IOException;
import java.util.Scanner;

class problem_08_09 {
    static int[] combi;
    static int N, M;

    public void DFS(int lvl, int s) {
        if(lvl == M) {
            for(int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for(int i = s; i <= N; i++) {
            combi[lvl] = i;
            DFS(lvl + 1, i + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_09 mc = new problem_08_09();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        combi = new int[M];
        
        mc.DFS(0, 1);
        sc.close();
    }
}