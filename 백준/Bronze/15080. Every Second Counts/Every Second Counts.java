import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] first = br.readLine().split(":");
		String[] second = br.readLine().split(":");

		int start = 0;
		int end = 0;
		int sec = 3600;

		for (int i = 0; i < 3; i++) {
			start += Integer.parseInt(first[i].trim()) * sec;
			end += Integer.parseInt(second[i].trim()) * sec;
			sec /= 60;
		}

		if (end < start) {
			end += 24 * 60 * 60;
		}

		System.out.println(end - start);
	}
}