
public class cost {
    static int minCost = 1000000;
    static int[] coin = {1, 5, 10, 50, 100, 500};

    public static void getCost(int money, int[] cost, int[] num, int idx) {
        int coinSum = 0, costSum = 0;
        for (int i = 0; i < 6; i++) {
            coinSum += coin[i] * num[i];
            costSum += cost[i] * num[i];
        }
        if(coinSum > money) return;
        else if(coinSum == money) {
            if(minCost > costSum) minCost = costSum;
            return;
        }

        for(int i = idx; i < num.length; i++) {
            int loopCnt = 1000000 / coin[i];
            for(int j = 0; j < loopCnt; j++) {
                num[i]++;
                getCost(money, cost, num, ++idx);
            }
        }
    }

    public static int solution(int money, int[] cost) {
        int answer = 0;
        int num[] = new int[6];
        getCost(money, cost, num, 0);
        answer = minCost;
        return answer;
    }
    public static void main(String[] args) {
        int[] cost = {1, 4, 99, 35, 50, 1000};
        int ass = 0;
        ass = solution(4578, cost);
        System.out.println(ass);
    }
}
