import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long a = Long.parseLong(br.readLine());
        bw.write(Long.toString(4*a));
        br.close();
        bw.flush();
        bw.close();
    }
}