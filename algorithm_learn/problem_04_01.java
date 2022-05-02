import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

class problem_04_01 {
    public char solution(int n, String str) {
        char result = '\0';
        int max = Integer.MIN_VALUE;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        char[] charArr = str.toCharArray();
        for(char c : charArr) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        Iterator<Character> it = map.keySet().iterator();
        while(it.hasNext()) {
            char c = it.next();
            if(max < map.get(c)) {
                max = map.get(c);
                result = c;
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        problem_04_01 mc = new problem_04_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        System.out.println(mc.solution(N, str));
    }
}
