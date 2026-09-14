import java.util.Scanner;
public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        permute(new int[n], 0, 0);
        System.out.print(sb.toString());
    }

    public static void permute(int[] arr, int idx, int mask){
        if(idx == n){
            for(int i = 0; i<n; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i<=n; i++){
            if((mask & (1<<i)) == 0){
                arr[idx] = i;
                permute(arr, idx+1, mask | (1<<i));
            }
        }
    }
}