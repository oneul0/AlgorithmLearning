import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        comb(1, n, m, new int[m], 0, 0);
        

        bw.flush();
        bw.close();
    }
    public static void comb(int start, int n, int m, int[] arr, int idx, int mask) throws IOException {
        if(idx == m){
            for(int v : arr){
                bw.write(v+" ");
            }
            bw.newLine();
            return;
        }

        for(int i = start; i<=n; i++){
            if((mask & (1<<i)) != 0) continue;
            mask |= (1<<i);
            arr[idx] = i;
            comb(i+1, n, m, arr, idx+1, mask);
            mask &= ~(1<<i);
        }
    }
}