import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		List<int[]> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split(" ");
			arr.add(new int[]{Integer.parseInt(st[0]), Integer.parseInt(st[1])});
		}

		int[] grade = new int[N];
		Arrays.fill(grade, 1);
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(i == j) continue;
				if(arr.get(i)[0] < arr.get(j)[0] && arr.get(i)[1] < arr.get(j)[1]) {
					grade[i]++;
				}
			}
		}

		for(int i = 0; i<N; i++) {
			System.out.print(grade[i] + " ");
		}
	}
}

//둘 다 더 크면 등수가 당겨짐
//둘 중 하나만 더 크면 같음
//둘 다 낮으면 밀림