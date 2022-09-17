import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    int time;
    char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}

class problem_09_03 {
    static int N;
    static ArrayList<Time> times;

    public void solution() {
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        Collections.sort(times);
        for(Time t : times) {
            if(t.state == 'e') {
                cnt--;
            } else if(t.state == 's') {
                cnt++;
            }

            max = max < cnt ? cnt : max;
        }

        System.out.println(max);
    }
    
    public static void main(String[] args) throws IOException {
        problem_09_03 mc = new problem_09_03();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        times = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(new Time(s, 's'));
            times.add(new Time(e, 'e'));
        }
        
        mc.solution();
    }
}