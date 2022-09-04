import java.io.IOException;
import java.util.*;

class problem_07_08 {
    int[] dir = {1, -1, 5};
    int[] check;
    public int BFS(int S, int E) {
        Queue<Integer> queue = new LinkedList<>();
        check = new int[10001];
        check[S] = 1;

        queue.offer(S);
        int lvl = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int x = queue.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = x + dir[j];
                    if(nx == E) return lvl + 1;
                    if(nx >= 0 && nx <= 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            lvl++;
        }

        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_08 mc = new problem_07_08();
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();

        System.out.println(mc.BFS(S, E));
    }
}