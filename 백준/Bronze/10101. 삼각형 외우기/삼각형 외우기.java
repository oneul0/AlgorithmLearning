import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String ans = "";
        if(n+m+k != 180){
            ans = "Error";
        }
        else{
            if(n == 60 && m == 60 && k == 60){
                ans = "Equilateral";
            }
            else if(n  == m || n == k || m == k){
                ans = "Isosceles";
            }
            else{
                ans = "Scalene";
            }
        }
        bw.write(ans);
        br.close();
        bw.flush();
        bw.close();
    }
}