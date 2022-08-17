import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class problem_06_09 {
    public int counter(ArrayList<Integer> list, int mid) {
        int sum = 0;
        int su = 1;
        for(int x : list) {
            if(sum + x > mid) {
                sum = x;
                su++;
            } else {
                sum += x;
            }
        }

        return su;
    }

    public int solution(ArrayList<Integer> list, int M) {
        int answer = 0;
        
        int lt = list.get(list.size() - 1), rt = 0;
        for(int x : list) rt += x;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(counter(list, mid) <= M) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        problem_06_09 mc = new problem_06_09();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }

        System.out.println(mc.solution(list, M));
    }
}