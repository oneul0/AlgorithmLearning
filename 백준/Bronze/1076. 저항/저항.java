import java.io.*;
import java.util.HashMap;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] line = new String[3];
		for(int i = 0; i<3; i++){
			line[i] = br.readLine();
		}
		HashMap<String, int[]> map = new HashMap<>();
		map.put("black",  new int[]{0, 1});
		map.put("brown",  new int[]{1, 10});
		map.put("red",    new int[]{2, 100});
		map.put("orange", new int[]{3, 1000});
		map.put("yellow", new int[]{4, 10000});
		map.put("green",  new int[]{5, 100000});
		map.put("blue",   new int[]{6, 1000000});
		map.put("violet", new int[]{7, 10000000});
		map.put("grey",   new int[]{8, 100000000});
		map.put("white",  new int[]{9, 1000000000});

		long result = (map.get(line[0])[0] * 10L + map.get(line[1])[0]) * map.get(line[2])[1];
		System.out.println(result);
	}
}

