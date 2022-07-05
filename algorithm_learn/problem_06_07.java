import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class problem_06_07 {
    public void solution(ArrayList<PointDot> list) {
        Collections.sort(list, new Comparator<PointDot>() {
            @Override
            public int compare(PointDot o1, PointDot o2) {
                if(o1.x == o2.x) return o1.y - o2.y;
                else return o1.x - o2.x;
            }
        });

        for(PointDot p : list) {
            p.printPoint();
        }
    }
    public static void main(String[] args) throws IOException {
        problem_06_07 mc = new problem_06_07();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<PointDot> list = new ArrayList<PointDot>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new PointDot(x, y));
        }

        mc.solution(list);
    }
}

class PointDot {
    int x, y;
    public PointDot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void printPoint() {
        System.out.println(x + " " + y);
    }
}