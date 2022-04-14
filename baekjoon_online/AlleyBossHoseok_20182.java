import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AlleyBossHoseok_20182 {
    static int N, M, A, B, C;
    static List<List<Pay>> map;
    static int min[];
    static int solution() {
        int answer = 0;

        PriorityQueue<Pay> pq = new PriorityQueue<>(new Comparator<Pay>(){
            @Override
            public int compare(Pay o1, Pay o2) {
                if(o1.p == o2.p) return o1.n - o2.n;
                else return o1.p - o2.p;
            }
        });

        boolean[] visited = new boolean[N + 1];

        pq.add(new Pay(A, 0, Integer.MIN_VALUE));

        while(!pq.isEmpty()) {
            Pay cur = pq.poll();
            if(visited[cur.n] || cur.n == B) continue;
            
            visited[cur.n] = true;

            for(Pay next : map.get(cur.n)) {
                int totalPay = cur.p + next.n;
                if(visited[next.n] || totalPay > C) continue;

                int curMax = cur.max;
                if(curMax < next.p) {
                    curMax = next.p;
                }
                if(min[next.n] > curMax) min[next.n] = curMax;
                pq.add(new Pay(next.n, totalPay, curMax)); 
            }
        }
        
        answer = min[B] != Integer.MAX_VALUE ? min[B] : -1;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        min = new int[N + 1];
        Arrays.fill(min, Integer.MIN_VALUE);

        for(int i = 0; i <= N; i++) map.add(new ArrayList<>());
        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(one).add(new Pay(two, cost));
            map.get(two).add(new Pay(one, cost));
        }

        System.out.println(solution());
    }
}

class Pay {
    int n;
    int p;
    int max;

    public Pay(int n, int p) {
        this.n = n;
        this.p = p;
    }

    public Pay(int n, int p, int max) {
        this.n = n;
        this.p = p;
        this.max = max;
    }
}
