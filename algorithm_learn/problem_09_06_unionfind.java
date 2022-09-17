import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_09_06_unionfind {
    static int[] union;

    public static int Find(int v) {
        if(v == union[v]) return v;
        else return union[v] = Find(union[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) union[fa] = fb;
    }
    
    public static void main(String[] args) throws IOException {
        problem_09_06_unionfind mc = new problem_09_06_unionfind();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        union = new int[N + 1];
        for(int i = 1; i <= N; i++) union[i] = i;
        for(int i = 1; i <= M; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a, b);
        }

        if(!st.hasMoreTokens()) st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) System.out.println("NO");
        else System.out.println("YES");
    }
}