import java.io.*;
import java.util.*;

public class Main {
	static class Paper{
		int sx, sy, w, h;
		Paper(int sx, int sy, int w, int h){
			this.sx = sx;
			this.sy = sy;
			this.w = w;
			this.h = h;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Paper[] papers = new Paper[n];
		for(int i =0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			papers[i] = new Paper(sx, sy, w, h);
		}

		boolean[][] visited = new boolean[1011][1011];
		int[] result = new int[n];
		for(int i = n-1; i>=0; i--){
			int count = 0;
			Paper p = papers[i];

			//fill
			int xLen = p.sx+p.w;
			int yLen = p.sy+p.h;
			for(int x = p.sx; x<xLen; x++){
				for(int y = p.sy; y<yLen; y++){
					if(!visited[x][y]){
						visited[x][y] = true;
						count++;
					}
				}
			}

			result[i] = count;
		}

		StringBuilder sb = new StringBuilder();
		for(int r : result){
			sb.append(r).append("\n");
		}
		System.out.print(sb);
	}
}
