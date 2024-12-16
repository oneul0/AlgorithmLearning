import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] pr;
    static int N, M;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        pr = new int[N+1];

        for(int i = 0; i<=N; i++) pr[i] = i;

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                if(st.nextToken().equals("1")){
                    union(i, j);
                }
            }
        }

        boolean fg = true;
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        for(int i = 1; i<M; i++){
            if(find(s) != find(Integer.parseInt(st.nextToken()))) {
                fg = false;
                break;
            }
        }

        if(fg) bw.write("YES");
        else bw.write("NO");
        bw.flush();
        br.close();
        bw.close();
    }

    static int find(int a){
        if(pr[a] == a) return a;
        return find(pr[a]);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){
            if(x > y) pr[x] = y;
            else pr[y] = x;
        }
    }
}
