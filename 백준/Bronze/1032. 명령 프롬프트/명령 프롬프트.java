import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		char[] first = br.readLine().toCharArray();
		for(int i = 1; i<N; i++){
			String tmp = br.readLine();
			for(int j = 0; j<tmp.length(); j++){
				if(first[j] != tmp.charAt(j)){
					first[j] = '?';
				}
			}
		}
		for(char c : first){
			System.out.print(c);
		}
	}
}
