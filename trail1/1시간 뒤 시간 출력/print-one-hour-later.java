import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(":");
        str[0] = String.valueOf(Integer.parseInt(str[0])+1);
        System.out.print(str[0]+":"+str[1]);
    }
}