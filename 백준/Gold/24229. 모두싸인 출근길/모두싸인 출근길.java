import java.io.*;
import java.util.*;

public class Main {
	public static class Pair implements Comparable<Pair> {
		int l, r;
		Pair(int l, int r){
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(Pair o){
			if (this.l == o.l) return this.r - o.r;
			return this.l - o.l;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<Pair> coords = new ArrayList<>();

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			coords.add(new Pair(a, b));
		}

		Collections.sort(coords);

		List<Pair> merged = new ArrayList<>();
		int curL = coords.get(0).l;
		int curR = coords.get(0).r;

		for(int i = 1; i < coords.size(); i++){
			Pair next = coords.get(i);
			if(next.l <= curR){
				curR = Math.max(curR, next.r);
			}
			else{
				merged.add(new Pair(curL, curR));
				curL = next.l;
				curR = next.r;
			}
		}
		merged.add(new Pair(curL, curR));

		int maxReach = merged.get(0).r + (merged.get(0).r - merged.get(0).l);
		int curEnd = merged.get(0).r;

		for (int i = 1; i < merged.size(); i++) {
			int nextL = merged.get(i).l;
			int nextR = merged.get(i).r;
			int nextJump = nextR - nextL;

			if (maxReach >= nextL) {
				maxReach = Math.max(maxReach, nextR + nextJump);
				curEnd = nextR;
			}
			else {
				break;
			}
		}

		System.out.println(curEnd);
	}
}