import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> treemap = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        String[] input = br.readLine().split(" ");


        for(int i = 0; i < n; i++){
            int key = Integer.parseInt(input[i]);
            list.add(key);
            treemap.put(key, 0);
        }
        int idx = 0;
        // 새로운 TreeMap 생성
        TreeMap<Integer, Integer> newTreeMap = new TreeMap<>();
        // 새로운 TreeMap에 변경된 값을 저장
        for (Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
            newTreeMap.put(entry.getKey(), idx);
            idx++;
        }
        for(int i = 0; i < list.size(); i++){
            bw.write(newTreeMap.get(list.get(i)) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
