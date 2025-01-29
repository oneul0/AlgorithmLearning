import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0, sum = 0, l = 0, r = N-1;
        while(l<r){
            sum = arr[l]+arr[r];
            if(sum < M){
                l++;
            }
            else if(sum > M){
                r--;
            }
            else{
                cnt++;
                l++;
                r--;
            }
        }
        System.out.println(cnt);
    }
}