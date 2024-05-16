import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i<input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        bw.write(Integer.toString(arr[n-k]));
        br.close();
        bw.flush();
        bw.close();
    }
}