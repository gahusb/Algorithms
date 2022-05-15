import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicianShark_OrganizingFishbowl {
    static int N, K;
    public static int[] fish;
    static int cnt;

    public static void solution() {
        while(!check()) {
            cnt++;
            plusMinFish();
            floatingAir();
            divideFish();
        }
    }

    public static void plusMinFish() {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            if(min > fish[i]) min = fish[i];
        }

        for(int i = 0; i < N; i++) {
            if(min == fish[i]) fish[i]++;
        }
    }

    public static void floatingAir() {

    }

    public static void divideFish() {
        for(int i = 0; i < N; i++) {
            
        }
    }

    public static boolean check() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(min > fish[i]) min = fish[i];

            if(max < fish[i]) max = fish[i];
        }

        if(max - min >= K) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fish = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            fish[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        solution();
        System.out.println(cnt);
    }   
}
