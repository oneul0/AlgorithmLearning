import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}


		int sum = 0;
		//처음 k개의 합 왼쪽에서부터 0~k-1개
		for(int r = 0; r<k; r++){
			sum += arr[r];
		}
		int answer = sum;
		int l = 0;
		for(int r = k; r <n; r++){
			sum -= arr[l];
			sum += arr[r];
			answer = Math.max(answer, sum);
			l++;
		}
		System.out.println(answer);
	}
}
