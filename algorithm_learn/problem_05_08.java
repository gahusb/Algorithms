import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class problem_05_08 {
    public int solution(int M, Queue<Person> qu) {
        int answer = 0;

        while(!qu.isEmpty()) {
            Person person = qu.poll();
            for(Person x : qu) {
                if(x.danger > person.danger) {
                    qu.offer(person);
                    person = null;
                    break;
                }
            }
            if(person != null) {
                answer++;
                if(person.idx == M) return answer;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_05_08 mc = new problem_05_08();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Person> qu = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            qu.offer(new Person(i, Integer.parseInt(st.nextToken())));
        }

        System.out.println(mc.solution(M, qu));
    }
}

class Person {
    int idx;
    int danger;
    public Person(int idx, int danger) {
        this.idx = idx;
        this.danger = danger;
    }
}
