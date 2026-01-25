import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		while(tc-- > 0){
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());

			for(int i = 0; i < k; i++){
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if(cmd.equals("I")){
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if(map.isEmpty()) continue;

					int key;
					if(num == 1) {
						key = map.lastKey();
					} else {
						key = map.firstKey();
					}

					if(map.get(key) == 1) {
						map.remove(key);
					} else {
						map.put(key, map.get(key) - 1);
					}
				}
			}

			if(map.isEmpty()){
				bw.write("EMPTY\n");
			} else {
				bw.append(map.lastKey()+"")
					.append(" ")
					.append(map.firstKey()+"")
					.write("\n");
			}
		}
		bw.flush();
	}
}