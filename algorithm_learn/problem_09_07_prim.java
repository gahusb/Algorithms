import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class problem_09_07_prim {
    static class Edge implements Comparable<Edge> {
        public int vex, cost;
        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] check;
    
    public static void main(String[] args) throws IOException {
        problem_09_07_prim mc = new problem_09_07_prim();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        check = new int[V + 1];
        
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= V; i++) graph.add(new ArrayList<Edge>());
        
        for(int i = 1; i <= E; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int ev = e.vex;
            if(check[ev] == 0) {
                check[ev] = 1;
                answer += e.cost;
                for(Edge ob : graph.get(ev)) {
                    if(check[ob.vex] == 0) pq.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }

        System.out.println(answer);
    }
}