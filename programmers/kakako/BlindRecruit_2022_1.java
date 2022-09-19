package kakako;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// 신고 결과 받기
public class BlindRecruit_2022_1 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int user_num = id_list.length;
        int[] answer = new int[user_num];
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" ");
            int ps = 0;
            if(!map.containsKey(tmp[1])) {
                map.put(tmp[1], new ArrayList<String>());
            } else {
                for(String listString : map.get(tmp[1])) {
                    if(listString.equals(tmp[0])) {
                        ps++;
                        break;
                    }
                }
            }
            if(ps == 0) map.get(tmp[1]).add(tmp[0]);
        }

        for(String key : map.keySet()) {
            int su = map.get(key).size();
            if(su >= k) {
                for(int j = 0; j < su; j++) {
                    String tm = map.get(key).get(j);
                    for(int i = 0; i < user_num; i++) {
                        if(id_list[i].equals(tm)) {
                            answer[i]++;
                        }
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BlindRecruit_2022_1 mc = new BlindRecruit_2022_1();

        String[] mun1 = {"muzi", "frodo", "apeach", "neo"};
        String[] mun2 = {"con", "ryan"};

        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};

        int[] ans1 = mc.solution(mun1, report1, 2);
        int[] ans2 = mc.solution(mun2, report2, 3);

        for(int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i] + ", ");
        }
        System.out.println();

        for(int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + ", ");
        }
        System.out.println();
    }
}
