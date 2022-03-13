package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * JAVA 언어
 * 84,120 kb 메모리
 * 288 ms 실행시간
 * 1,078 코드길이
 * 
 */
public class Bumuck_7964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int N = 0, D = 0;
		int d = 0;
		
		int result = 0;
		int[] kingdom;
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			kingdom = new int[N];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < kingdom.length; j++) {
				kingdom[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < kingdom.length; j++) {
				d++;
				if(kingdom[j] == 0) {
					if(d == D) {
						d = 0;
						kingdom[j] = 1;
						result++;
					}
				} else d = 0;
			}
			System.out.println("#" + i + " " + result);
		}
	}
}
