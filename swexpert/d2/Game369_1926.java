package d2;

import java.util.Scanner;

// 1926. 간단한 369게임
/*
 * 21,828 kb 메모리
 * 164 ms 실행시간
 * 923 코드길이
 * 
 */
public class Game369_1926 {
	static void gameStart(int count) {
		String result = "";
		for (int i = 1; i <= count; i++) {
			if(i == count) result += compare(i);
			else result += compare(i) + " ";
		}
		System.out.println(result);
	}
	
	static String compare(int num) {
		int su = 0;
		String re = "", tmp = "";
		if(num == 1000) su = 3;
		else if(num >= 100) su = 2;
		else if(num >= 10) su = 1;
		
		boolean check = false;
		for (int i = su; i >= 0; i--) {
			tmp = Integer.toString((int)(num / Math.pow(10, i)));
			
			if(tmp.matches("[3|6|9]")) {
				if(re.matches("[0-9]")) {
					re = "";
				}
				re += "-";
				check = true;
			} else if(tmp.matches("[0-24-57-8]") && !check) {
				re += tmp;
			}
			num = (int)(num % Math.pow(10, i));
		}
		
		return re;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		gameStart(N);
	}
}
