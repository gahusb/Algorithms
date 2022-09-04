import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_07_10_graph_array {
    static int[][] graph;
    static int[] check;
    static int N, M, answer;
    public void DFS(int node) {
        if(node == N) answer++;
        else {
            for(int i = 1; i <= N; i++) {
                if(graph[node][i] == 1 && check[i] != 1) {
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_10_graph_array mc = new problem_07_10_graph_array();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        check = new int[N + 1];
        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph[V][E] = graph[E][V] = 1;
        }
        answer = 0;
        check[1] = 1;
        mc.DFS(1);
        System.out.println(answer);
    }
}