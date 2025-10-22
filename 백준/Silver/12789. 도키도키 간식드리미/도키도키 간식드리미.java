import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 1; i<=N; i++){
			q.offer(Integer.parseInt(st.nextToken()));
		}
		br.close();
		int idx = 1;
		while(true){
			boolean moved = false;
			if(!q.isEmpty() && q.peek() == idx){
				q.poll();
				idx++;
				moved = true;
			}
			else if(!stack.isEmpty() && stack.peek() == idx){
				stack.pop();
				idx++;
				moved = true;
			}
			else if(!q.isEmpty()){
				stack.push(q.poll());
				moved = true;
			}

			if(q.isEmpty() && stack.isEmpty()) break;
			else if(q.isEmpty() && !stack.isEmpty() && stack.peek() != idx) break;

			if(!moved) break;
		}

		if(idx == N+1){
			System.out.println("Nice");
		}
		else {
			System.out.println("Sad");
		}
	}
}
