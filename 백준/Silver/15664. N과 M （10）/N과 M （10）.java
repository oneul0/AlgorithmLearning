import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] nums;
	static Set<String> set = new HashSet<>();
	public static void comnination(int depth, int start, int[] ans){
		if(depth == M){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<depth; i++){
				sb.append(ans[i]).append(" ");
			}
			if(!set.contains(sb.toString())){
				System.out.print(sb);
				set.add(sb.toString());
				System.out.println();
			}
			return;
		}

		for(int i = start; i<N; i++){
			ans[depth] = nums[i];
			comnination(depth+1, i+1, ans);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		comnination(0, 0, new int[M+1]);

		br.close();

	}
}
