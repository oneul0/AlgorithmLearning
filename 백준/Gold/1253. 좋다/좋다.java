import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i<N; i++){
            int l = 0, r = N-1;
            while(l<r){
                if(l == i || r == i){
                    if(l == i) l++;
                    else r--;
                }
                else{
                    long sum = arr[l]+arr[r];
                    if(arr[i] == sum){
                        ans++;
                        break;
                    }
                    else if(sum < arr[i]){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}