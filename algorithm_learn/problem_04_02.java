import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

class problem_04_02 {
    public String solution(String f, String s) {
        char[] fArr = f.toCharArray();
        char[] sArr = s.toCharArray();

        HashMap<Character, Integer> fMap = new HashMap<Character, Integer>();
        for(char c : fArr) {
            if(fMap.containsKey(c)) {
                int tmp = fMap.get(c);
                fMap.replace(c, tmp, tmp + 1);
            } else {
                fMap.put(c, 1);
            }
        }

        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        for(char c : sArr) {
            if(sMap.containsKey(c)) {
                int tmp = sMap.get(c);
                sMap.replace(c, tmp, tmp + 1);
            } else {
                sMap.put(c, 1);
            }
        }

        Iterator<Character> it = fMap.keySet().iterator();
        while(it.hasNext()) {
            char c = it.next();
            if(fMap.get(c) != sMap.get(c)) {
                return "NO";
            }
        }

        return "YES";
    }
    public static void main(String[] args) throws IOException {
        problem_04_02 mc = new problem_04_02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        System.out.println(mc.solution(first, second));
    }
}
