import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int kx = Integer.parseInt(st.nextToken());
		int ky = Integer.parseInt(st.nextToken());

		int[] dx = {0, -1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {0, -1, 0, 1, -1, 1, -1, 0, 1};

		long[][] targets = new long[9][2];
		boolean[] isAttacked = new boolean[9];
		boolean[] canGo = new boolean[9];

		for (int i = 0; i < 9; i++) {
			long nx = kx + dx[i];
			long ny = ky + dy[i];

			if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
				targets[i][0] = nx;
				targets[i][1] = ny;
				canGo[i] = true;
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			long qx = Long.parseLong(st.nextToken());
			long qy = Long.parseLong(st.nextToken());

			for (int j = 0; j < 9; j++) {
				if (!canGo[j]) continue;
				if (qx == targets[j][0] || qy == targets[j][1] ||
					Math.abs(qx - targets[j][0]) == Math.abs(qy - targets[j][1])) {
					isAttacked[j] = true;
				}
			}
		}

		boolean curPosAttacked = isAttacked[0];
		boolean canMove = false;

		for (int i = 1; i < 9; i++) {
			if (canGo[i] && !isAttacked[i]) {
				canMove = true;
				break;
			}
		}

		if (curPosAttacked && !canMove) System.out.println("CHECKMATE");
		else if (curPosAttacked && canMove) System.out.println("CHECK");
		else if (!curPosAttacked && !canMove) System.out.println("STALEMATE");
		else System.out.println("NONE");
	}
}