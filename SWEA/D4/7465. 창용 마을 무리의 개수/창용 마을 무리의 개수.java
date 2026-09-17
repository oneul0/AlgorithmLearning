
import java.util.*;
import java.io.*;

class Solution
{
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] parent;
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			for(int i = 1; i<=n; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			int count = 0;
			for(int i = 1; i<=n; i++) {
				if(parent[i] == i) {
					count++;

				}
			}
			bw.write(count+"");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}