import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Val[] A = new Val[N];

		for(int i = 0; i<N; i++){
			A[i] = new Val(Integer.parseInt(br.readLine()), i);
		}

		Arrays.sort(A);
		int max = 0;
		for(int i = 0; i<N; i++){
			if(max < A[i].index - i){
				max = A[i].index - i;
			}
		}

		System.out.println(max+1);
	}

	public static class Val implements Comparable<Val>{
		int value, index;
		public Val(int value, int index){
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Val o){
			return this.value - o.value;
		}
	}
}
