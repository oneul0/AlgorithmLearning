import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }
        int m = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        for(int i = 0; i < m; i++) {
            if(set.contains(Integer.parseInt(input2[i]))) {
                bw.write("1 ");
            }
            else{
                bw.write("0 ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
