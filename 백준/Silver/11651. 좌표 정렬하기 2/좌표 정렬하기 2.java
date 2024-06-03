import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // pair 클래스 구현을 static으로 변경
    public static class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Pair<Integer,Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            list.add(new Pair<>(k,v)); // Java 7 이후로는 new Pair<>(k,v) 형태로 타입 추론 가능
        }
        list.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                if (p1.getValue().equals(p2.getValue())) {
                    return p1.getKey().compareTo(p2.getKey());
                } else {
                    return p1.getValue().compareTo(p2.getValue());
                }
            }
        });
        for(Pair<Integer,Integer> p : list){
            bw.write(p.getKey() + " " + p.getValue() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
