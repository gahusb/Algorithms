import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class problem_06_08 {
    public int solution(ArrayList<Integer> list, int M) {
        Collections.sort(list);
        
        int lt = 0, rt = list.size() - 1;
        int i = 0;
        while(lt <= rt) {
            i = (lt + rt) / 2;
            int tmp = list.get(i);
            if(tmp == M) break;
            else if(tmp > M) rt = i - 1;
            else lt = i + 1;
        }

        return i + 1;
    }
    public static void main(String[] args) throws IOException {
        problem_06_08 mc = new problem_06_08();
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