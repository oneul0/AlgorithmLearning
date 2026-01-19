import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Pair[] bingo = new Pair[26];
		for(int i = 0; i<5;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++){
				bingo[Integer.parseInt(st.nextToken())] = new Pair(i, j);
			}
		}

		int[] chk = new int[5];
		int count = 0;
		for(int i = 0; i<5; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++){
				int num = Integer.parseInt(st.nextToken());
				int cx = bingo[num].x;
				int cy = bingo[num].y;

				chk[cx] |= (1<<cy);
				count++;
				if(check(chk) >= 3) {
					System.out.println(count);
					return;
				}
			}
		}

	}

	public static int check(int[] chk) {
		int lines = 0;
		int diag1 = 0;
		int diag2 = 0;

		for (int j = 0; j < 5; j++) {
			if ((chk[j] & 31) == 31) lines++;
			if ((chk[j] & (1 << j)) != 0) diag1 |= (1 << j);
			if ((chk[j] & (1 << (4 - j))) != 0) diag2 |= (1 << j);
			int colMask = 0;
			for (int i = 0; i < 5; i++) {
				if ((chk[i] & (1 << j)) != 0) colMask |= (1 << i);
			}
			if (colMask == 31) lines++;
		}
		if (diag1 == 31) lines++;
		if (diag2 == 31) lines++;

		return lines;
	}
}
