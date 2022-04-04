import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RecommQuestion_21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Question> list = new ArrayList<Question>();

        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            list.add(new Question(P, L));
        }

        StringBuilder sb = new StringBuilder();
        if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {    // 가장 어려운 문제
                    int maxL = 0;
                    int maxP = 0;
                    for(int j = 0; j < list.size(); j++) {
                        if(list.get(j).L > maxL) {
                            maxP = list.get(j).P;
                            maxL = list.get(j).L;
                        } else if(list.get(j).L == maxL) {
                            if(list.get(j).P > maxP) {
                                maxP = list.get(j).P;
                                maxL = list.get(j).L;
                            }
                        }
                    }
                    sb.append(maxP + "\n");
                } else {        // 가장 쉬운 문제
                    int minL = Integer.MAX_VALUE;
                    int minP = Integer.MAX_VALUE;
                    for(int j = 0; j < list.size(); j++) {
                        if(list.get(j).L < minL) {
                            minP = list.get(j).P;
                            minL = list.get(j).L;
                        } else if(list.get(j).L == minL) {
                            if(list.get(j).P < minP) {
                                minP = list.get(j).P;
                                minL = list.get(j).L;
                            }
                        }
                    }
                    sb.append(minP + "\n");
                }
            } else if(cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                list.add(new Question(P, L));
            } else {    // solved
                int P = Integer.parseInt(st.nextToken());
                for(int j = 0; j < list.size(); j++) {
                    if(list.get(j).P == P) {
                        list.remove(j);
                        break;
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }
}

class Question {
    int P = 0;
    int L = 0;
    
    public Question(int P, int L) {
        this.P = P;
        this.L = L;
    }
}
