import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		String str1 = br.readLine();
		String str2 = br.readLine();
		int N = str1.length();
        int M = str2.length();
		//N번째 문자가 같은지 비교 (1~N)
		int[][] dp = new int[N+1][M+1];

		int answer = 0;
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				answer = Math.max(dp[i][j], answer);
			}
		}

		System.out.println(answer);
		br.readLine();
	}
}
