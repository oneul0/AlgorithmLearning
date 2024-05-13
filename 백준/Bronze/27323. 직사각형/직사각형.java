import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(a*b));
        br.close();
        bw.flush();
        bw.close();
    }
}