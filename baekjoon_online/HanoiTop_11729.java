import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class HanoiTop_11729 {
	static int N;
	static BufferedWriter bw;
	static void hanoi(int N, int from, int middle, int to) throws IOException {
		if(N == 0) return;
		
		hanoi(N - 1, from, middle, to);
		bw.write(from + " " + to + "\n");
		hanoi(N - 1, middle, from, to);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String cnt = Integer.toString((int)Math.pow(2, N) - 1);
		bw.write(cnt + "\n");
		
		hanoi(N, 1, 2, 3);
		
		bw.flush();
		bw.close();
	}
}