import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a, b, c;
        while(true)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if(a == 0 && b == 0 && c == 0)
                break;
            if(a == b && b == c)
                System.out.println("Equilateral");
            else if(a + b <= c || a + c <= b || b + c <= a)
                System.out.println("Invalid");
            else if(a == b || b == c || c == a)
                System.out.println("Isosceles");
            else
                System.out.println("Scalene");
        }
    }
}