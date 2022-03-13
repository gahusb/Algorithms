package d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * JAVA 언어
 * 27,004 kb 메모리
 * 168 ms 실행시간
 * 1,650 코드길이
 */
public class Time_7732 {
	public static String solve(String cTime, String pTime) {
		String result = "";
		int[] ct = new int[3];
		int[] pt = new int[3];
		String[] c = cTime.split(":");
		String[] p = pTime.split(":");
		for (int i = 0; i < 3; i++) {
			ct[i] = Integer.parseInt(c[i]);
			pt[i] = Integer.parseInt(p[i]);
		}
		if(isNextDay(ct, pt)) {		
			pt[0] += (24 - ct[0]);
			for (int i = 1; i < 3; i++) {
				if(pt[i] - ct[i] < 0) {
					pt[i] += (60 - ct[i]);
					pt[i-1]--;
				} else {
					pt[i] -= ct[i];
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				if(pt[i] - ct[i] < 0) {
					pt[i] += (60 - ct[i]);
					pt[i-1]--;
				} else {
					pt[i] -= ct[i];
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			String tmp = "";
			if(pt[i] < 10) tmp += "0" + pt[i];
			else tmp += pt[i];
			
			if(i == 2) result += tmp;
			else result += tmp + ":";
		}
		return result;
	}
	public static boolean isNextDay(int[] ct, int[] pt) {
		boolean result = true;
		
		if(ct[0] > pt[0]) return result;
		else if(ct[0] == pt[0] && ct[1] > pt[1]) return result;
		else if(ct[0] == pt[0] && ct[1] == pt[1] && ct[2] > pt[2]) return result;
		else result = false;
		
		return result;
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("time.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= T; t++) {
			String currentTime = sc.next();
			String promiseTime = sc.next();
			System.out.println("#" + t + " " + solve(currentTime, promiseTime));
		}
	}
}
