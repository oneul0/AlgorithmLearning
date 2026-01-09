import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[n];
		for(int i = 0; i<n; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long answer = n;
		for(int i = 0; i<n; i++){
			int left = A[i]-b;
			if(left < 0) continue;
			int needed = left%c == 0 ? (left/c) : (left/c)+1;
			answer += needed;
		}
		System.out.println(answer);
	}
}
