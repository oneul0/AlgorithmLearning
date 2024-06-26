import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      public static void main(String[] args) throws IOException {
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int order = Integer.parseInt(input[0]);
            if(order == 1) {
                int x = Integer.parseInt(input[1]);
                st.push(x);
            }
            else if(order == 2) {
                if(st.isEmpty()) {
                    bw.write("-1");
                }else{
                    bw.write(Integer.toString(st.pop()));
                }

                bw.write("\n");
            }
            else if(order == 3) {
                bw.write(Integer.toString(st.size()));

                bw.write("\n");
            }
            else if(order == 4) {
                if(st.isEmpty()) {
                    bw.write("1");
                }else{
                    bw.write("0");
                }

                bw.write("\n");
            } else if (order == 5) {
                if(st.isEmpty()) {
                    bw.write("-1");
                }else{
                    bw.write(Integer.toString(st.peek()));
                }

                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
