import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		boolean[][] whitePaper = new boolean[101][101];
		int count = 0;
		for(int i = 0; i<n; i++){
			//색종이의 왼쪽 아래 좌표(색종이의 크기는 10)
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Math.min(100, sx+10);
			int ey = Math.min(100, sy+10);
			//기록하고
			for(int  x= sx; x<ex; x++){
				for(int y = sy; y<ey; y++){
					//개수세기
					if(!whitePaper[x][y]){
						whitePaper[x][y] = true;
						count++;
					}

				}
			}
		}
		System.out.println(count);
	}
}
