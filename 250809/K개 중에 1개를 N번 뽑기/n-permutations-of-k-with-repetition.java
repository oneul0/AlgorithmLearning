import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        dfs(new int[9], 0, n, k);
    }
    public static void dfs(int[] result, int depth, int n, int k){
        if(depth == n){
            for(int i = 0; i<n; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i<=k; i++){
            result[depth] = i;
            dfs(result, depth+1, n, k);
        }
    }
}