import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i<=n; i++){
			q.offer(i);
		}
		while(!q.isEmpty()){
			System.out.print(q.poll() +" ");
			if(q.isEmpty()) break;
			q.offer(q.poll());
		}
	}
}