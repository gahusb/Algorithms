package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Where_1979 {
	static int K, N;
	static int[][] map;
	
	static int where() {
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) { // 가로 검사
				if(map[i][j] == 1) cnt++;
				else {
					if(cnt == K) {
						result++;
					}
					cnt = 0;
				}
			}
			cnt = 0;
			for (int j = 0; j < N; j++) { // 세로 검사
				if(map[j][i] == 1) cnt++;
				else {
					if(cnt == K) {
						result++;
					}
					cnt = 0;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("1979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + i + " " + where());
		}
	}
}
