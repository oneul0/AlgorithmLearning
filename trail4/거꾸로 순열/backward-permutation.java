import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        permute(new int[n], 0, 0);
        bw.flush();
        bw.close();
    }
    public static void permute(int[] arr, int idx, int mask) throws Exception{
        if(idx == n){
            for(int i = 0; i<n; i++){
                bw.write(arr[i] + " ");
            }
            bw.newLine();
        }
        for(int i = n; i>=1; i--){
            if((mask & (1<<i)) == 0){
                arr[idx] = i;
                permute(arr, idx+1, mask | (1<<i));
            }
        }
    }
}