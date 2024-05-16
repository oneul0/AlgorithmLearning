import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for(int i = chars.length - 1; i >= 0; i--) {
            bw.write(chars[i]);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}