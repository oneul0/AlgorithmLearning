import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int C, N;
	static List<City> cities = new ArrayList<>();
	static int[] dp;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dp = new int[C + 101];

		Arrays.fill(dp, 100_000);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			cities.add(new City(cost, customer));
		}

		for (City city : cities) {
			for (int j = city.customer; j < dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j - city.customer] + city.cost);
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = C; i < dp.length; i++) {
			answer = Math.min(answer, dp[i]);
		}

		System.out.println(answer);
	}
}

class City {
	int cost, customer;

	City(int cost, int customer) {
		this.cost = cost;
		this.customer = customer;
	}
}
