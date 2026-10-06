import java.util.*;
import java.io.*;


class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" ");
			int n = Integer.parseInt(br.readLine());
			int[] x = new int[n];
			int[] y = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			long result = prim(x, y, n, E);
			bw.write(result+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static long prim(int[] x, int[] y, int n, double E) {
		long[] minEdge = new long[n];
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;
		boolean[] visited = new boolean[n];
		long total = 0;
		for(int i = 0; i<n; i++) {
			int minNode = -1;
			long minDist = Long.MAX_VALUE;
			
			for(int j = 0; j<n; j++) {
				if(!visited[j] && minEdge[j] < minDist) {
					minDist = minEdge[j];
					minNode = j;
				}
			}

			visited[minNode] = true;
			total+=minDist;
			
			for(int j = 0; j<n; j++) {
				if(!visited[j]) {
					long dx = (long) x[minNode] - x[j];
					long dy = (long) y[minNode] - y[j];
					
					long dist = dx*dx + dy*dy;
					
					if(dist < minEdge[j]) {
						minEdge[j] = dist;
					}
				}
			}
		}
		
		return Math.round(total * E);
	}
}