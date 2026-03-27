import java.io.*;
import java.util.*;

public class Main {
	static int N, minDiff = Integer.MAX_VALUE;
	static int[][] stats;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		stats = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++){
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(minDiff);
	}

	static void dfs(int idx, int cnt){
		if(cnt == N>>>1){
			calcDiff();
			return;
		}

		for(int i = idx; i<N; i++){
			if(!visited[i]){
				visited[i] = true;
				dfs(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}

	static void calcDiff(){
		int startScore = 0, linkScore =0;
		for(int i = 0; i<N-1; i++){
			for(int j = i+1; j<N; j++){
				if(i == j) continue;
				if(visited[i] && visited[j]){
					startScore += (stats[i][j] + stats[j][i]);
				}
				else if(!visited[i] && !visited[j]){
					linkScore += (stats[i][j] + stats[j][i]);
				}
			}
		}
		int diff = Math.abs(startScore - linkScore);
		if(diff == 0){
			System.out.println(0);
			System.exit(0);
		}

		minDiff = Math.min(minDiff, diff);
	}
}
