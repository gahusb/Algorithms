import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class problem_07_10_graph_list {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;
    static int N, M, answer;
    public void DFS(int node) {
        if(node == N) answer++;
        else {
            for(int nv : graph.get(node)) {
                if(check[nv] == 0) {
                    check[nv] = 1;
                    DFS(nv);
                    check[nv] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_10_graph_list mc = new problem_07_10_graph_list();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        check = new int[N + 1];
        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        answer = 0;
        check[1] = 1;
        mc.DFS(1);
        System.out.println(answer);
    }
}