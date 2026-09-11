import java.util.*;
import java.io.*;

class Solution
{
    static class BC {
        int x, y, c;
        int power;
        BC(int x, int y, int c, int power){
            this.x = x;
            this.y =y;
            this.c = c;
            this.power = power;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            
            int[] aDir = new int[M];
            int[] bDir = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                aDir[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                bDir[i] = Integer.parseInt(st.nextToken());
            }
            BC[] bc = new BC[A];
            for(int i = 0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                bc[i] = new BC(x, y, c, power);
            }

            bw.write("#"+test_case+" "+solve(M, A, aDir, bDir, bc)+"\n");
		}
        bw.flush();
        br.close();
        bw.close();
	}

    public static int solve(int M, int A, int[] aDir, int[] bDir, BC[] bc) {
        int ax = 1, ay = 1;
        int bx = 10, by = 10;

        int answer = 0;

        for (int time = 0; time <= M; time++) {

            int aMask = 0;
            int bMask = 0;

            //현재 위치에서 사용할 수 있는 BC 확인
            for (int i = 0; i < A; i++) {
                if (canCharge(ax, ay, bc[i])) {
                    aMask |= (1 << i);
                }

                if (canCharge(bx, by, bc[i])) {
                    bMask |= (1 << i);
                }
            }

            int curMax = 0;

            //-1은 아무 충전기도 사용하지 않음
            for (int i = -1; i < A; i++) {
                if (i != -1 && (aMask & (1 << i)) == 0) {
                    continue;
                }

                for (int j = -1; j < A; j++) {
                    if (j != -1 && (bMask & (1 << j)) == 0) {
                        continue;
                    }

                    int charge = 0;

                    if (i == -1 && j == -1) {
                        charge = 0;
                    } else if (i == -1) {
                        charge = bc[j].power;
                    } else if (j == -1) {
                        charge = bc[i].power;
                    } else if (i == j) {
                        //같은 BC를 사용하면 둘이 나눠 가지므로 총합은 power
                        charge = bc[i].power;
                    } else {
                        //다른 BC
                        charge = bc[i].power + bc[j].power;
                    }

                    curMax = Math.max(curMax, charge);
                }
            }

            answer += curMax;

            if (time == M) break;

            ax += dx[aDir[time]];
            ay += dy[aDir[time]];

            bx += dx[bDir[time]];
            by += dy[bDir[time]];
        }

        return answer;
    }

    public static boolean canCharge(int x, int y, BC charger) {
        return getDist(x, y, charger.x, charger.y) <= charger.c;
    }

    public static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}