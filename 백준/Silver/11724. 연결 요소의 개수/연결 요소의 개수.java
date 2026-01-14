import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean[] visited;
	static List<List<Integer>> gr = new ArrayList<>();

	public static void dfs(int cur){
		if(visited[cur]) return;
		visited[cur] = true;
		for(int next : gr.get(cur)){
			dfs(next);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n+1];
		for(int i =0 ;i<=n; i++){
			gr.add(new ArrayList<>());
		}
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			gr.get(a).add(b);
			gr.get(b).add(a);
		}

		int count = 0;
		for(int i = 1; i<=n; i++){
			if(!visited[i]){
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}
}
