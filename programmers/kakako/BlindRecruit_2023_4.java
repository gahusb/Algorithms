package kakako;

import java.io.IOException;
import java.util.ArrayList;

public class BlindRecruit_2023_4 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            ArrayList<Long> st = new ArrayList<Long>();
            
            while(num > 0) {
                st.add(num % 2);
                num = num / 2;
            }

            boolean check = true;
            int size = st.size();
            for(int j = size - 1; j >= 0; j--) {
                System.out.print(st.get(j));
                 // 짝수번대 값이 0이면 트리 불가
                if(size % 2 == 0) { // size가 짝수면 0번 인덱스가 짝수
                    if(j % 2 == 0 && st.get(j) == 0) {
                        answer[i] = 0;
                        check = false;
                        break;
                    }
                } else {
                    if(j % 2 == 1 && st.get(j) == 0) {
                        answer[i] = 0;
                        check = false;
                        break;
                    }
                }
            }
            System.out.println();
            if(check) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BlindRecruit_2023_4 mc = new BlindRecruit_2023_4();

        long[] numbers = {7, 5};
        int[] result = mc.solution(numbers);

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        long[] numbers2 = {62, 111, 95};
        int[] result2 = mc.solution(numbers2);

        for(int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
    }
}
