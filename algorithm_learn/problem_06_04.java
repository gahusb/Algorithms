import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_06_04 {
    public void solution(int[] cache, int[] work) {
        int workLen = work.length;
        int cacheLen = cache.length;

        for(int i = 0; i < workLen; i++) {
            int lru = -1;
            for(int j = 0; j < cacheLen; j++) {
                if(cache[j] == work[i]) {
                    lru = j;
                    break;
                }
            }
            if(lru == -1) lru = cacheLen - 1;

            for(int j = lru; j >= 1; j--) {
                cache[j] = cache[j - 1];
            }
            cache[0] = work[i];
        }

        for(int x : cache) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        problem_06_04 mc = new problem_06_04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cache = new int[S];
        int[] work = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }

        mc.solution(cache, work);
    }
}