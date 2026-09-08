import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        comb(1, new int[m], 0, 0);
        

        bw.flush();
        bw.close();
    }
    public static void comb(int start, int[] arr, int idx, int mask) throws IOException {
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
            comb(i+1, arr, idx+1, mask);
            mask &= ~(1<<i);
        }
    }
}