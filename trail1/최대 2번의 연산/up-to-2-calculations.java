import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 2;
        if(n%2==0) n/=2;
        if(n%2==1){
            n++;
            n /= 2;
        }
        System.out.print(n);
    }
}