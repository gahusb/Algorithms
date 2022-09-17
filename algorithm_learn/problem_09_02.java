import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}

class problem_09_02 {
    static int N;
    static ArrayList<Meeting> meetings;

    public void solution() {
        int cnt = 0;
        int time = 0;
        Collections.sort(meetings);
        for(Meeting m : meetings) {
            if(time <= m.start) {
                cnt++;
                time = m.end;
            }
        }
        System.out.println(cnt);
    }
    
    public static void main(String[] args) throws IOException {
        problem_09_02 mc = new problem_09_02();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        meetings = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(s, e));
        }
        
        mc.solution();
    }
}