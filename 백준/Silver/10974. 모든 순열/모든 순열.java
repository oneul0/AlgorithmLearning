import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        dfs(1, new int[N+1], new boolean[N+1]);

    }

    static void dfs(int len, int[] arr, boolean[] chk) throws Exception {
        if(len > N){
            for(int i = 1; i<=N; i++){
                bw.write(arr[i]+" ");
            }
            bw.flush();
            bw.newLine();
        }

        for(int i = 1; i<=N; i++){
            if(!chk[i]){
                arr[len] = i;
                chk[i] = true;
                dfs(len+1, arr, chk);
                chk[i] = false;
            }
        }
    }
}
