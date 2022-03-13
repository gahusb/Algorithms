package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * JAVA 언어
 * 19,524 kb 메모리
 * 111 ms 실행시간
 * 1,242 코드길이
 * 
 */
public class Password_1234 {
	static char[] pass;
	static String delete() {
		String result = "";
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < pass.length; i++) {
			if(stack.isEmpty()) {
				stack.push(pass[i]);
			} else if(stack.peek() == pass[i]) {
				stack.pop();
			} else {
				stack.push(pass[i]);
			}
		}
		char[] ch = new char[stack.size()];
		int k = 0;
		while(!stack.isEmpty()) {
			ch[k] = stack.pop();
			k++;
		}
		for (int i = ch.length - 1; i >= 0; i--) {
			result += ch[i];
		}
		return result;
	}
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("password.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len;
		for (int t = 1; t <= 10; t++) {
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			pass = new char[len];
			pass = st.nextToken().toCharArray();
			System.out.println("#" + t + " " + delete());
		}
	}
}
