package kakako;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// 메뉴 리뉴얼
public class BlindRecruit_2021_2 {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < orders.length; i++) {
            char[] cArr = orders[i].toCharArray();
            for(int j = 0; j < cArr.length; j++) {
                if(map.containsKey(cArr[i])) {
                    map.get(cArr[i]).add(j);
                } else {
                    map.put(cArr[i], new ArrayList<Integer>());
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BlindRecruit_2021_2 mc = new BlindRecruit_2021_2();

        String[] order1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] order2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] order3 = {"XYZ", "XWY", "WXA"};

        int[] course1 = {2, 3, 4};
        int[] course2 = {2, 3, 5};
        int[] course3 = {2, 3, 4};

        String[] result1 = mc.solution(order1, course1);
        String[] result2 = mc.solution(order2, course2);
        String[] result3 = mc.solution(order3, course3);

        for(int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + " ");
        }
        System.out.println();
    }
}
