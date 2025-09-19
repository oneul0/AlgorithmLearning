import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] costs = new int[N];
		int maxCost = 0;
		for(int i = 0; i<N; i++){
			costs[i] = Integer.parseInt(st.nextToken());
			maxCost = Math.max(maxCost, costs[i]);
		}
		int limit = Integer.parseInt(br.readLine());
		if(Arrays.stream(costs).sum() <= limit){
			System.out.println(maxCost);
		}
		else{
			System.out.println(upper_bound(costs, limit, maxCost));
		}

		br.close();
	}

	public static int upper_bound(int[] arr, int limit, int maxCost){
		int begin = 0;
		int end = maxCost;
		int result = 0;
		while(begin <= end){
			int mid = (begin + end) / 2;
			if(canExcution(arr, limit, mid)){
				begin = mid+1;
				result = mid;
			}
			else{
				end = mid-1;
			}
		}
		return result;
	}
	public static boolean canExcution(int[] arr, int limit, int bound){
		int totalCost = 0;
		for(int a : arr){
			totalCost += Math.min(a, bound);
		}
		return totalCost <= limit;
	}
}

//upper bound