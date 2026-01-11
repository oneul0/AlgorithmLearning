import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int prev = System.in.read();
		int answer = 10;
		int cur;
		while ((cur = System.in.read()) != -1) {
			if (cur == 10) break;
			if (cur == prev) answer += 5;
			else answer += 10;
			prev = cur;
		}

		System.out.println(answer);
	}
}