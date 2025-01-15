import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, L, R;
    static int ans;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        arr = new int[n]; L = new int[n]; R = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        L[0] = ans = arr[0];
        for(int i = 1; i<n; i++){
            L[i] = Math.max(arr[i], L[i-1]+arr[i]);
            ans = Math.max(ans, L[i]);
        }
        R[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            R[i] = Math.max(arr[i], R[i+1]+arr[i]);
        }
        for(int i = 1; i<n-1; i++){
            ans = Math.max(ans, L[i-1]+R[i+1]);
        }
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
