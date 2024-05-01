import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[201];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            a+=100;
            arr[a]++;
        }

        int v = Integer.parseInt(br.readLine());
        v+=100;
        System.out.println(arr[v]);

        br.close();
        bw.flush();
        bw.close();
    }
}