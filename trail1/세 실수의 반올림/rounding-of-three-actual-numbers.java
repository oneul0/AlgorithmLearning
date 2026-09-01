import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());
        double b = Double.parseDouble(br.readLine());
        double c = Double.parseDouble(br.readLine());
        System.out.printf("%.3f\n%.3f\n%.3f", a, b, c);
    }
}