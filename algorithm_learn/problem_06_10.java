import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class problem_06_10 {
    public int counter(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }

        return cnt;
    }
    public int solution(int N, int C, int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);

        // 마굿간 사이 거리의 이분 탐색을 위한 알고리즘이기 때문에 dist가 범위
        int lt = 1, rt = arr[N - 1];
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(counter(arr, mid) >= C) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        problem_06_10 mc = new problem_06_10();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mc.solution(N, C, arr));
    }
}