import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        parent = new int[N+1];

        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            String[] L = br.readLine().split(" ");
            int query = Integer.parseInt(L[0]);
            int a = Integer.parseInt(L[1]);
            int b = Integer.parseInt(L[2]);
            if(query == 0){
                union(a,b);
            }
            else{
                if(checkSame(a,b)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }

    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    
    static int find(int a){
        if(a == parent[a]){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }
    
    static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return true;
        }
        return false;
    }
}
