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
        HashSet<String> set = new HashSet();
        ArrayList<String> list = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 0; i < n; i++){
            String x = br.readLine();
            set.add(x);
        }
        for(int i = 0; i<m; i++){
            String y = br.readLine();
            if(set.contains(y)){
                list.add(y);
            }
        }
        list.sort(Comparator.naturalOrder());
        bw.write(list.size()+"\n");
        for(String s : list){
            bw.write(s+'\n');
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
