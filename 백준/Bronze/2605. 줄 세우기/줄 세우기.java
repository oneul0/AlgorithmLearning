import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> c = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int idx = Integer.parseInt(st.nextToken());
			c.add(c.size() - idx, i);
		}
		for(int i : c){
			System.out.print(i+" ");
		}
	}
}
