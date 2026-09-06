import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());
        if(a>=3000) System.out.print("book");
        else if(a>=1000) System.out.print("mask");
        else System.out.print("no");
    }
}