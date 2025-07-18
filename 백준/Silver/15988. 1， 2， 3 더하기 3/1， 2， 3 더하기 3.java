import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int MOD = 1_000_000_009;
	static long[] memo = new long[1_000_001];
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for(int i = 0; i<T; i++){
			int n = Integer.parseInt(br.readLine());
			for(int j = 4; j <=n; j++){
				if(memo[j] == 0){
					memo[j] = (memo[j -1] + memo[j -2] + memo[j -3])%MOD;	
				}
			}
			System.out.println(memo[n]%MOD);
		}
	}
}
