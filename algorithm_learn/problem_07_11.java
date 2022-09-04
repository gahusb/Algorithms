import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class problem_07_11 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dist;
    static int[] check;
    static int N, M;
    public void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        check[node] = 1;
        dist[node] = 0;
        queue.offer(node);
        while(!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph.get(cv)) {
                if(check[nv] == 0) {
                    check[nv] = 1;
                    queue.offer(nv);
                    dist[nv] = dist[cv] + 1;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_11 mc = new problem_07_11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        check = new int[N + 1];
        dist = new int[N + 1];
        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        mc.BFS(1);
        for(int i = 2; i <= N; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }
}