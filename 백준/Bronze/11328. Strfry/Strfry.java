import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n<N; n++){
			int[] str1 = new int[26];
			int[] str2 = new int[26];
			String[] input = br.readLine().split(" ");
			for(int i = 0; i<input[0].length(); i++){
				int idx = input[0].charAt(i) - 'a';
				str1[idx]++;
			}
			for(int i = 0; i<input[1].length(); i++){
				int idx = input[1].charAt(i) - 'a';
				str2[idx]++;
			}
			String result = "Possible";
			for(int i = 0; i<26; i++){
				if(str1[i] != str2[i]){
					result = "Impossible";
					break;
				}
			}
			System.out.println(result);
		}


	}
}
