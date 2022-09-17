import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class problem_09_07_kruskal {
    static class Edge implements Comparable<Edge> {
        public int v1, v2, cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] union;

    public static int Find(int v) {
        if(v == union[v]) return v;
        else return union[v] = Find(union[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) union[fa] = fb;
    }
    
    public static void main(String[] args) throws IOException {
        // problem_09_07_kruskal mc = new problem_09_07_kruskal();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        union = new int[V + 1];
        for(int i = 1; i <= V; i++) union[i] = i;

        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 1; i <= E; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        int answer = 0;
        int cnt = 0;
        Collections.sort(edges);
        for(Edge ob : edges) {
            if(cnt == V - 1) break;
            int fa = Find(ob.v1);
            int fb = Find(ob.v2);
            if(fa != fb) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
                cnt++;
            }
        }

        System.out.println(answer);
    }
}