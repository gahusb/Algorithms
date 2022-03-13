package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1926. 간단한 369게임
/*
 * 18,812 kb 메모리
 * 115 ms 실행시간
 * 747 코드길이
 * 
 */
public class Game369_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			String tmp = i + "";
			int count = 0;
			for (int j = 0; j < tmp.length(); j++) {
				if(tmp.charAt(j) == '3' || tmp.charAt(j) == '6' || tmp.charAt(j) == '9') {
					count++;
				}
			}
			if(count == 0) {
				sb.append(tmp + " ");
			} else {
				for (int j = 0; j < count; j++) {
					sb.append("-");
				}
				sb.append(" ");
			}
		}
		System.out.print(sb);
	}
}
