import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(
			(a, b) -> {
				if(Math.abs(a) != Math.abs(b)){
					return Math.abs(a) - Math.abs(b);
				}
				return a - b;
			}
		);

		while(N-- > 0){
			int x = Integer.parseInt(br.readLine());
			if(x == 0)System.out.println(pq.isEmpty() ? 0 : pq.poll());
			else pq.offer(x);
		}
		br.close();
	}
}
