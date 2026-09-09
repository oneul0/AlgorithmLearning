import java.util.*;
import java.io.*;

public class Solution {
	static final int MAX = 987654321;
	static int n, wire, conn, result;
	static List<int[]> cores;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" ");
			wire = 0;
			conn = 0;
			result = MAX;
			n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			cores = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					int cur = Integer.parseInt(st.nextToken());
					if(cur == 1) {
						arr[i] |= (1<<j);
						cores.add(new int[]{i, j});
					}
				}
			}
			
			backtrack(0, 0, 0, arr);
			
			bw.write(wire+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void backtrack(int idx, int connCnt, int wireLen, int[] board) {
		if(idx == cores.size()) {
			if(conn < connCnt) {
				conn = connCnt;
				wire = wireLen;
			}
			else if(conn == connCnt) {
				wire = Math.min(wire, wireLen);
			}
			return ;
		}
		
		//to next
		int[] cur = cores.get(idx);
		
		for(int d = 0; d<4; d++) {
			int[] newBoard = board.clone();
			int additional = getShortestLen(cur[0], cur[1], d, newBoard);
			if(additional != MAX) {
				backtrack(idx+1, connCnt+1, wireLen+additional, newBoard);
			}
		}
		backtrack(idx+1, connCnt, wireLen, board);
	}
	
	//하나의 방향으로 범위 밖에 도달할 수 있는지
	//가능하다면 보드에 표시하고 그 보드를 최신상태로 만듦
	public static int getShortestLen(int x, int y, int d, int[] board) {
	    int len = 0;
	    int nx = x+dx[d];
	    int ny = y+dy[d];

	    while (nx>=0 && nx<n && ny>=0 && ny<n) {

	        if ((board[nx] & (1 << ny)) != 0) {
	            return MAX;
	        }

	        board[nx] |= (1 << ny);
	        len++;

	        nx += dx[d];
	        ny += dy[d];
	    }
	    return len;
	}

}
