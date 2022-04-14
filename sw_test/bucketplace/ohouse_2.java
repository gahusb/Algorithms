import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ohouse_2 {
    public static String solution(String call) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        char[] charArr = call.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            String tmp = "";
            for(int j = i; j < charArr.length; j++) {
                tmp += charArr[j];
                if(map.containsKey(tmp)) {
                    int tmpCnt = map.get(tmp) + 1;
                    map.remove(tmp);
                    map.put(tmp, tmpCnt);
                } else map.put(tmp, 1);
            }
        }

        HashSet<String> patternSet = new HashSet<String>();
        int maxPattern = Integer.MIN_VALUE;
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            int value = map.get(key);
            if(maxPattern == value) {
                patternSet.add(key);
            } else if(maxPattern < value) {
                patternSet.clear();
                maxPattern = value;
                patternSet.add(key);
            }
        }

        Iterator iter = patternSet.iterator();
        while(iter.hasNext()) {
            String pattern = (String)iter.next();
            String upCasePattern = pattern.toUpperCase();
            String downCasePattern = pattern.toLowerCase();
            answer = call.replaceAll(upCasePattern, "");
            answer = answer.replaceAll(downCasePattern, "");
        }

        return answer;
    }
    public static void main(String[] args) {
        String tstring = "ABCabcA";
        System.out.println(solution(tstring));
    }
}