import java.util.Arrays;

public class cost2 {
    static int minCost = 1000000;
    static int[] coin = {1, 5, 10, 50, 100, 500};

    public static int solution(int money, int[] cost) {
        int answer = 0;
        int[] rank = new int[6];
        
        for(int i = 0; i < 6; i++) {
            rank[i] = cost[i];
        }

        Arrays.sort(rank);
        
        for(int i = 0; i < 6; i++) {
            System.out.print(rank[i] + " ");
        }
        System.out.println();

        int rankIdx = 0;
        for(int i = 0; i < 6; i++) {
            int idx = 0;
            for(int j = 0; j < 6; j++) {
                if(cost[j] == rank[rankIdx]) {
                    System.out.println(cost[j] + " " + j);
                    idx = j;
                    break;
                }
            }
            rankIdx++;
            int temp = money / coin[idx];
            answer += cost[idx] * temp;
            money = money % coin[idx];
            System.out.println(answer);
        }
        
        return answer;
    }
    public static void main(String[] args) {
        int[] cost = {1, 4, 99, 35, 50, 1000};
        int ass = 0;
        ass = solution(4578, cost);
        System.out.println(ass);
    }
}
