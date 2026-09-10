import java.util.Scanner;
public class Main {
    static int n, mindiff = 987654321;
    static int total = 0;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        dfs(0, 0, 0, 0);
        System.out.print(mindiff);
    }

    public static void dfs(int start, int mask, int sum, int cnt){
        if(cnt == n){
            mindiff = Math.min(mindiff, Math.abs(sum-(total - sum)));
            return;
        }
        for(int i = start; i<n+n; i++){
            if((mask & (1<<i))!=0) continue;
            dfs(i +1, (mask | (1<<i)), sum + arr[i], cnt+1);
        }
    }
}
