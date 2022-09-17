import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;
    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class problem_09_05_dijkstra {
    static int N, M;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist;

    public void solution(int val) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(val, 0));
        dist[val] = 0;
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dist[now]) continue;
            for(Edge ob : graph.get(now)) {
                if(dist[ob.vex] > nowCost + ob.cost) {
                    dist[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_09_05_dijkstra mc = new problem_09_05_dijkstra();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }
        
        mc.solution(1);
        for(int i = 2; i <= N; i++) {
            if(dist[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dist[i]);
            else System.out.println(i + " : impossible");
        }
    }
}