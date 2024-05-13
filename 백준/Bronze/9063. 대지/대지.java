import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        if(n <= 1){
            bw.write(Long.toString(0));
        }
        else {
            List<Integer> listX = new ArrayList<>();
            List<Integer> listY = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                String[] s = br.readLine().split(" ");
                listX.add(Integer.parseInt(s[0]));
                listY.add(Integer.parseInt(s[1]));
            }
            listX.sort(Comparator.reverseOrder());
            listY.sort(Comparator.reverseOrder());
            int x = listX.get(listX.size() - 1) - listX.get(0);
            int y = listY.get(listY.size() - 1) - listY.get(0);
            bw.write(Integer.toString((x*y)));
        }


        br.close();
        bw.flush();
        bw.close();
    }
}