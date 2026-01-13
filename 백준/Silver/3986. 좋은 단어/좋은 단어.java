import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = 0;

		for(int i = 0; i < n; i++){
			String line = br.readLine();
			Deque<Character> stack = new ArrayDeque<>();
			for(int j = 0; j < line.length(); j++){
				char cur = line.charAt(j);
				if(!stack.isEmpty() && stack.peek() == cur){
					stack.pop();
				}
				else{
					stack.push(cur);
				}
			}
			if(stack.isEmpty()) count++;
		}
		System.out.println(count);
	}
}