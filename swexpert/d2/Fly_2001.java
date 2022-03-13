package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2001번 파리 퇴치
/*
 * 19,676 kb 메모리
 * 128 ms 실행시간
 * 1,236 코드길이
 * 
 */
public class Fly_2001 {
	static int[][] map;
	static int N, M;
	
	static void smash(int tc) {
		int max = 0;
		
		for (int startY = 0; startY <= N - M; startY++) {
			for (int startX = 0; startX <= N - M; startX++) {
				int tmp = cnt(startY, startX);
				if(max < tmp) max = tmp;
			}
		}
		
		System.out.println("#" + tc + " " + max);
	}
	
	static int cnt(int dy, int dx) {
		int result = 0;
		
		for (int j = dy; j < dy + M; j++) {
			for (int i = dx; i < dx + M; i++) {
				result += map[j][i];
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			smash(i);
		}
	}

}
