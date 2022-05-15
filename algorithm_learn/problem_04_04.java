import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

class problem_04_04 {
    public int solution(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int answer = 0;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();

        for(int i = 0; i < tLen - 1; i++) {
            smap.put(sArr[i], smap.getOrDefault(sArr[i], 0) + 1);
        }

        for(char c : tArr) tmap.put(c, tmap.getOrDefault(c, 0) + 1);

        int lt = 0;
        for(int rt = tLen - 1; rt < sLen; rt++) {
            smap.put(sArr[rt], smap.getOrDefault(sArr[rt], 0) + 1);

            Iterator<Character> it = tmap.keySet().iterator();
            boolean same = true;
            while(it.hasNext()) {
                Character c = it.next();
                if(tmap.get(c) != smap.get(c)) {
                    same = false;
                    break;
                }
            }

            if(same) answer++;

            if(smap.get(sArr[lt]) != 1) smap.put(sArr[lt], smap.get(sArr[lt]) - 1);
            else smap.remove(sArr[lt]);
            lt++;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_04_04 mc = new problem_04_04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(mc.solution(S, T));
    }
}
