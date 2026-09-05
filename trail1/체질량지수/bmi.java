import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double h = Double.parseDouble(st.nextToken());
        double w = Double.parseDouble(st.nextToken());
        int b = (int)((10000*w)/(h*h));
        System.out.print(b +"\n"+ (b>=25 ? "Obesity" : ""));
    }
}