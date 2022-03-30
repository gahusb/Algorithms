import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SetRepre_1717 {
    static int[] parents;
    private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	private static int find(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = find(parents[a]);
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        Arrays.fill(parents, -1);
        for(int i = 0; i < m; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(st.nextToken());
            // 합집합은 0 a b의 형태로 입력이 주어진다. 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미
			int condition = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(condition == 0) {
				union(a, b);
			} else {	// 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
        }
    }
}
