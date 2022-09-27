package kakako;

import java.io.IOException;

public class BlindRecruit_2023_3 {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        // 10% 20% 30% 40% 구매 시, 금액 prefix sum
        int[][] userSum = new int[users.length][4];
        int[][] userPlus = new int[users.length][4];
        for(int i = 0; i < userSum.length; i++) {
            for(int j = 1; j <= 4; j++) {
                int per = j * 10;
                for(int k = 0; k < emoticons.length; k++) {
                    if(users[i][0] <= per) {
                        userSum[i][j - 1] += emoticons[k] * (1 - (0.01 * per));
                    }
                }
                
                if(userSum[i][j - 1] > users[i][1]) {
                    userPlus[i][j - 1]++;
                    userSum[i][j - 1] = 0;
                }
            }
        }

        for(int i = 0; i < emoticons.length; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < userSum.length; k++) {

                }
            }
        }
        for(int i = 0; i < 4; i++) {
            int ePlus = 0;
            int total = 0;
            for(int j = 0; j < emoticons.length; j++) {
                ePlus += userPlus[j][i];
                total += userSum[j][i];
            }

            if(answer[0] < ePlus) {
                answer[0] = ePlus;
                answer[1] = total;
            } else if(answer[0] == ePlus && answer[1] < total) {
                answer[1] = total;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BlindRecruit_2023_3 mc = new BlindRecruit_2023_3();

        int[][] users = {
            {40, 10000},
            {25, 10000}
        };

        int[] emotions = {7000, 9000};

        int[] result = mc.solution(users, emotions);
        System.out.println(result[0] + ", " + result[1]);
    }
}
