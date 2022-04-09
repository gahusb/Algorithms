import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Decreasenum_1174 {
    public static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public static ArrayList<Long> al = new ArrayList<Long>();
    public static void solutionByBitmask(int n) {
        ArrayList<Long> list = new ArrayList<Long>();
        // 2^10의 모든 경우의수를 만든다.
        for(int i = 1; i < (1<<10); i++) {
            long sum = 0;
            // 10 자리만큼 탐색
            for(int j = 0; j < 10; j++) {
                // i가 0^2, 1^2, 2^2, .. , j^2 보다 크다면
                // i에 해당하는 비트가 각각 어느위치에 비트를 가지고 있는지 체크
                // if문을 만족한다면 해당 자릿수가 만족한다는 것이므로 sum*10 + num[j]를 추가.
                if( (i & (1 << j)) > 0 ) {
                    sum = sum * 10 + num[j];
                }
            }
            list.add(sum);
        }

        Collections.sort(list);
        if(n > list.size()) {
            System.out.println("-1");
            return;
        }
        System.out.println(list.get(n - 1));
    }

    public static void solutionByRecursive(long sum, int idx) {
        if(!al.contains(sum)) {
            al.add(sum);
        }
        if(idx >= 10) {
            return;
        }
        solutionByRecursive( (sum * 10) + num[idx], idx + 1);
        solutionByRecursive(sum, idx + 1);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int result = 0;
        if(result == 0) {
            solutionByBitmask(N);
        } else {
            solutionByRecursive(0, 0);
            al.sort(null);
            if(N > 1023)
                System.out.println("-1");
            else
                System.out.println(al.get(N - 1));
        }
    }
}
