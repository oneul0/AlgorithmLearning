import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] dx = {0,0,1,-1}, dy = {-1,1,0,0};//왼, 오, 아래, 위
	static boolean[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	//나는 0base 심장 출력은 +1씩
		board = new boolean[n][n];
		Queue<int[]> tmp = new ArrayDeque<>();
		for(int i = 0; i<board.length; i++){
			String line = br.readLine();
			for(int j = 0; j<board[i].length; j++){
				board[i][j] = line.charAt(j) != '*';
				if(!board[i][j]){
					tmp.offer(new int[]{i, j});
				}
			}
		}

		int hx = -1, hy = -1;
		while(!tmp.isEmpty()){
			int[] cur = tmp.poll();
			int canGO = 0;
			for(int i = 0; i<4; i++){
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(!isValid(nx, ny) || board[nx][ny]) continue;
				canGO++;
			}
			if(canGO == 4){
				hx = cur[0];
				hy = cur[1];
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(hx+1).append(" ").append(hy+1).append("\n");
		//왼팔
		//오른팔
		//허리
		int[] endPoint = new int[]{-1,-1, 0}; // x, y, len
		for(int i = 0; i<3; i++){
			endPoint = getLen(hx, hy, i);
			sb.append(endPoint[2]).append(" ");
		}

		//허리에서 대각선으로 갔을 때 왼쪽에 있는게 왼다리, 오른쪽 오른다리
		//1,-1
		//왼다리
		int leftLeg = getLen(endPoint[0]+1, endPoint[1]-1, 2)[2]+1;
		sb.append(leftLeg).append(" ");
		//1,1
		//오른다리

		int rightLeg = getLen(endPoint[0]+1, endPoint[1]+1, 2)[2]+1;
		sb.append(rightLeg);
		System.out.println(sb);
	}

	public static int[] getLen(int sx, int sy, int dir){
		int x = sx;
		int y = sy;
		int len = 0;

		while(isValid(x, y) && !board[x][y]){
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(!isValid(nx, ny) || board[nx][ny]) break;

			x = nx;
			y = ny;
			len++;
		}
		return new int[]{x, y, len};
	}

	public static boolean isValid(int x, int y){
		return x>=0 && y>=0 && x<n && y<n;
	}
}
