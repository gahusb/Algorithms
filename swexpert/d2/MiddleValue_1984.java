package d2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * JAVA 언어
 * 20,820 kb 메모리
 * 163 ms 실행시간
 * 598 코드길이
 * 
 */
public class MiddleValue_1984 {
	static int middle(int[] val) {
		double result = 0.0;
		Arrays.sort(val);
		for (int i = 1; i < val.length - 1; i++) {
			result += val[i];
		}
		result = Math.round(result / 8);
		return (int)result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] value;
		for (int t = 1; t <= T; t++) {
			value = new int[10];
			for (int i = 0; i < value.length; i++) {
				value[i] = sc.nextInt();
			}
			System.out.println("#" + t + " " + middle(value));
		}
	}
}
