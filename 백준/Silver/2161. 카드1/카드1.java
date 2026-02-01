import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i<=n; i++){
			q.offer(i);
		}
		//카드가 한 장 남을 때 까지 반복
		while(q.size() > 1){
			//제일 위에 있는 카드를 바닥에 버린다
			System.out.print(q.poll()+" ");
			//제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다
			if(!q.isEmpty()) q.offer(q.poll());
		}
		System.out.println(q.poll());
	}
}
