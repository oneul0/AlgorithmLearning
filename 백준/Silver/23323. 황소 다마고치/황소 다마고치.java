import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());
			long days = 0;
			//홀수면 버림이 생기므로 짝수로 만드는 그리디 설계
			while (n > 0) {
				n >>= 1;
				days++;
			}
			System.out.println(days+m);
		}
	}
}
