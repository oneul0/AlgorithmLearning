import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parent;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        for(int i = 0; i<=N; i++){
            parent[i] = i;
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 1; j<=N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    union(i, j);
                }
            }
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        for(int i = 1; i<M; i++){
            int p = Integer.parseInt(st.nextToken());
            if(find(sx) != find(p)){
                flag = false;
                break;
            }
        }

        if(flag){
            bw.write("YES");
        }
        else{
            bw.write("NO");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int find(int x){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x>y){
                parent[x] = y;
            }
            else{
                parent[y] = x;
            }
        }

    }
}
