import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int totalFee = 0;

		final int DAY_START = time_2_min("07:00");
		final int NIGHT_START = time_2_min("19:00");
		final int FULL_DAY = 1440;

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startTime = time_2_min(st.nextToken());
			int duration = Integer.parseInt(st.nextToken());

			int currentFee = 0;

			for(int m = 0; m < duration; m++) {
				int currentMinuteOfDay = (startTime + m) % FULL_DAY;

				if (currentMinuteOfDay >= DAY_START && currentMinuteOfDay < NIGHT_START) {
					currentFee += 10;
				} else {
					currentFee += 5;
				}
			}
			totalFee += currentFee;
		}

		System.out.println(totalFee);
	}

	public static int time_2_min(String time){
		String[] sp = time.split(":");
		int hhToMm = Integer.parseInt(sp[0]) * 60;
		int mm = Integer.parseInt(sp[1]);
		return hhToMm + mm;
	}
}