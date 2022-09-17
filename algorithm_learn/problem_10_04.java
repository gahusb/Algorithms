import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class problem_10_04 {
    static class Block implements Comparable<Block> {
        int area, height, weight;
        public Block(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block ob) {
            return ob.area - this.area;
        }
    }

    static Block[] arr;
    static int[] dy;
    public int solution(int n) {
        int answer = Integer.MIN_VALUE;
        answer = dy[0] = arr[0].height;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j].weight > arr[i].weight && max < dy[j]) {
                    max = dy[j];
                }
            }
            dy[i] = max + arr[i].height;
            answer = answer < dy[i] ? dy[i] : answer;
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        problem_10_04 mc = new problem_10_04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new Block[N];
        dy = new int[N + 1];
        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Block(a, h, w);
        }

        Arrays.sort(arr);

        System.out.println(mc.solution(N));
    }
}