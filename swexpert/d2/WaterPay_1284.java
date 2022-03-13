package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * JAVA 언어
 * 19,240 kb 메모리
 * 110 ms 실행시간
 * 942 코드길이
 * 
 */
public class WaterPay_1284 {
	public static void main(String[] args) throws IOException, FileNotFoundException{
		System.setIn(new FileInputStream("waterpay.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int P, Q, R, S, W;
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			int min = P * W;
			if(W < R) {
				if(min > Q) min = Q;
			} else {
				int tmp = S * (W - R) + Q;
				if(min > tmp) min = tmp;
			}
			
			System.out.println("#" + (t+1) + " " + min);
		}
	}
}
