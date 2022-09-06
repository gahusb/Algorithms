import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Player implements Comparable<Player> {
    int height, weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player o) {
        return o.height - this.height;
    }
}

class problem_09_01 {
    static int N;
    static ArrayList<Player> players;

    public void solution() {
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        Collections.sort(players);
        for(Player p : players) {
            if(p.weight > max) {
                max = p.weight;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static void main(String[] args) throws IOException {
        problem_09_01 mc = new problem_09_01();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        players = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            players.add(new Player(h, w));
        }
        
        mc.solution();
    }
}