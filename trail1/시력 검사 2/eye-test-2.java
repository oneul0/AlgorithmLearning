import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());
        if(a>=1.0) System.out.print("High");
        else if(a>=0.5) System.out.print("Middle");
        else System.out.print("Low");
    }
}