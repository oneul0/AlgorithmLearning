import java.io.*;
import java.util.Arrays;
import java.util.Collections;

//Sensor
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        Integer[] space = new Integer[N-1];
        for(int i = 0; i<N-1; i++){
            space[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(space, Collections.reverseOrder());
        int ans = 0;
        for(int i = K-1; i<N-1; i++){
            ans += space[i];
        }
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
