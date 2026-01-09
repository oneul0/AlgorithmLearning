import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[7][2];
		for(int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[y][s]++;
		}
		int count = 0;
		for(int i = 1; i<=6; i++){
			for(int g = 0; g<2; g++){
				count+= (arr[i][g] == 0 ?
					0 : (arr[i][g]%k == 0 ? arr[i][g]/k : (arr[i][g]/k)+1));
			}
		}
		System.out.println(count);
	}
}
