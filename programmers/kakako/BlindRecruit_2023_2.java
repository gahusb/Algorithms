package kakako;

import java.io.IOException;

public class BlindRecruit_2023_2 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BlindRecruit_2023_2 mc = new BlindRecruit_2023_2();

        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        System.out.println(mc.solution(4, 5, deliveries, pickups));
    }
}
