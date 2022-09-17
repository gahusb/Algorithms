import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    int money, day;

    public Lecture(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.day - this.day;
    }
}

class problem_09_04 {
    static int N, max = Integer.MIN_VALUE;

    public void solution(ArrayList<Lecture> list) {
        int pay = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);
        int j = 0;
        for(int i = max; i >= 1; i--) {
            for( ; j < N; j++) {
                if(list.get(j).day < i) break;
                pq.offer(list.get(j).money);
            }
            if(!pq.isEmpty()) pay += pq.poll();
        }

        System.out.println(pay);
    }
    
    public static void main(String[] args) throws IOException {
        problem_09_04 mc = new problem_09_04();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        ArrayList<Lecture> lectures = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(M, D));
            max = max < D ? D : max;
        }
        
        mc.solution(lectures);
    }
}