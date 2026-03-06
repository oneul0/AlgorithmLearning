import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean[] chk = new boolean[1000001];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (!chk[a] && !chk[b] && !chk[c]) {
				ans++;
			}

			chk[a] = true;
			chk[b] = true;
			chk[c] = true;
		}

		System.out.println(ans);
	}
}
//입력 받을 때 정렬해서 받고
//메모리 적어서 dp는 못 쓰고
//완탐 될 거 같은데