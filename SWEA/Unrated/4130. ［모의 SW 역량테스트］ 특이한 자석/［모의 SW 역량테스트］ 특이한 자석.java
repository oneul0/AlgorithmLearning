import java.util.*;
import java.io.*;

class Solution
{
	static int[] gears;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#" + test_case + " ");

			gears = new int[4];
			int K = Integer.parseInt(br.readLine());

			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());

				for(int j = 0; j < 8; j++) {
					gears[i] |= (Integer.parseInt(st.nextToken()) << j);
				}
			}

			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken()) - 1;
				int side = Integer.parseInt(st.nextToken());

				int[] dirs = new int[4];
				dirs[num] = side;

				// 왼쪽으로 전파
				for(int j = num; j > 0; j--) {
					int curLeft = (gears[j] >> 6) & 1;
					int leftRight = (gears[j - 1] >> 2) & 1;

					if(curLeft != leftRight) {
						dirs[j - 1] = -dirs[j];
					}
					else {
						break;
					}
				}

				// 오른쪽으로 전파
				for(int j = num; j < 3; j++) {
					int curRight = (gears[j] >> 2) & 1;
					int rightLeft = (gears[j + 1] >> 6) & 1;

					if(curRight != rightLeft) {
						dirs[j + 1] = -dirs[j];
					}
					else {
						break;
					}
				}

				// 극 비교가 전부 끝난 다음 회전
				for(int j = 0; j < 4; j++) {
					if(dirs[j] != 0) {
						rotate(j, dirs[j]);
					}
				}
			}

			int answer = 0;

			for(int i = 0; i < 4; i++) {
				if((gears[i] & 1) != 0) {
					answer += (1 << i);
				}
			}

			bw.write(answer + "");
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

	public static void rotate(int num, int dir) {
		int cur = gears[num];

		// clockwise
		if(dir == 1) {
			int last = (cur >> 7) & 1;

			cur = (cur << 1) & 0xFF;
			cur |= last;
		}
		// counterclockwise
		else {
			int first = cur & 1;

			cur >>= 1;
			cur |= (first << 7);
		}

		gears[num] = cur;
	}
}