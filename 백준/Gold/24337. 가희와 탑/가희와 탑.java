import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		List<Integer> H = new ArrayList<>();

		if (a + b > N + 1) {
			System.out.print(-1);
			return;
		}

		for (int i = 1; i < a; i++) {
			H.add(i);
		}
		H.add(Math.max(a, b));

		for (int i = b - 1; i >= 1; i--) {
			H.add(i);
		}

		//padding
		if (a == 1) {
			while (H.size() < N) {
				H.add(1, 1);
			}
		} else {
			while (H.size() < N) {
				H.add(0, 1);
			}
		}
		for (int i : H) {
			System.out.print(i + " ");
		}
	}
}
