import java.util.*;
import java.io.*;

class Solution
{
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dx = {0, 0, -1, 1}, dy = {1,-1,0,0};
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" ");
			int N = Integer.parseInt(br.readLine());
			Map<Integer, List<int[]>> atoms = new HashMap<>();
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())*2+2000;
				int y = Integer.parseInt(st.nextToken())*2+2000;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				int coords = x * 4001 + y;
				atoms.computeIfAbsent(coords, key -> new ArrayList<>())
				.add(new int[] {d, k});
			}
			
			int result = simulation(atoms);
			bw.write(result+"");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static int simulation(Map<Integer, List<int[]>> atoms) {
		int energy = 0;
		
		while (!atoms.isEmpty()) {
		    List<int[]> crashed = new ArrayList<>();
		    Map<Integer, List<int[]>> nextAtoms = new HashMap<>();

		    for (Map.Entry<Integer, List<int[]>> entry : atoms.entrySet()) {
		        int key = entry.getKey();
		        List<int[]> value = entry.getValue();

		        // crashed
		        if (value.size() > 1) {
		            crashed.addAll(value);
		            continue;
		        }

		        for (int[] a : value) {
		            int x = key / 4001;
		            int y = key % 4001;

		            x += dx[a[0]];
		            y += dy[a[0]];

		            //out of range
		            if (x < 0 || y < 0 || x > 4000 || y > 4000) continue;

		            int newKey = x * 4001 + y;

		            nextAtoms.computeIfAbsent(newKey, k -> new ArrayList<>())
		                .add(a);
		        }
		    }

		    atoms = nextAtoms;
		    for(int[] c : crashed) {
		    	energy += c[1];
		    }
		}
		
		return energy;
	}

}