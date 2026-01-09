import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n; i++){
			int[] a = new int[4];
			int[] b = new int[4];
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for(int c = 0; c< len; c++){
				int card = Integer.parseInt(st.nextToken());
				a[card-1]++;
			}
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			for(int c = 0; c< len; c++){
				int card = Integer.parseInt(st.nextToken());
				b[card-1]++;
			}

			char result = getWinner(a, b);
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
	public static char getWinner(int[] a, int[] b){
		if(a[3] != b[3]) return a[3] > b[3] ? 'A' : 'B';
		else if(a[2] != b[2]) return  a[2] > b[2] ? 'A' : 'B';
		else if(a[1] != b[1]) return  a[1] > b[1] ? 'A' : 'B';
		else if(a[0] != b[0]) return  a[0] > b[0] ? 'A' : 'B';
		return 'D';
	}
}