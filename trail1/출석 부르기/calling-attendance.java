import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = {"", "John", "Tom", "Paul"};
        if(n>3)System.out.print("Vacancy");
        else System.out.print(names[n]);
    }
}