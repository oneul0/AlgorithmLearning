
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n,num;
		n = Integer.parseInt(br.readLine());
		int[] nums = new int[1000];
		for(int i = 0; i<n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<n-i; j++) {
				if(nums[j]>nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		for(int i = 0; i < n; i++) {
		    bw.write(String.valueOf(nums[i]));
		    bw.newLine();
		}

		
		bw.flush();
		bw.close();
	}

}
