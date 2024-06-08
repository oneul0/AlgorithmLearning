import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{
        private String x, y;

        Pair(String x, String y){
            this.x = x;
            this.y = y;
        }

        public String x(){
            return x;
        }

        public String y(){
            return y;
        }

        @Override
        public int compareTo(Pair o){
            return this.x.compareTo(o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }
        List<Pair> list = new ArrayList<>();
        for(Map.Entry<String,String> entry: map.entrySet()){
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);
        Collections.reverse(list);

        for(Pair p : list){
            if(p.y().equals("enter")){
                bw.write(p.x()+"\n");
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }
}
