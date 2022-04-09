import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreenQuery_15681 {
    static int N, R, Q;
    static int[] arrq, cnt;
    static ArrayList<Integer>[] tree;

    public static void search(int x, int prevNode) {
        cnt[x] = 1;     // 현 루트 또한 간선의 개수로 포함

        for(int a : tree[x]) {
            if(a == prevNode) continue;     // 이전에 방문한 노드는 넘어간다.
            search(a, x);
            cnt[x] += cnt[a];               // 하위 노드의 간선 갯수도 더해준다.
        }
    }

    public static void solution() {
        search(R, -1);

        StringBuilder sb = new StringBuilder();
        for(int i : arrq) {
            sb.append(cnt[i] + "\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        cnt = new int[N + 1];
        arrq = new int[Q];

        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for(int i = 1; i < N; i++) {    // 가중치 없는 무방향 그래프
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree[U].add(V);
            tree[V].add(U);
        }

        for(int i = 0; i < Q; i++) {
            arrq[i] = Integer.parseInt(br.readLine());
        }
        solution();
    }
}