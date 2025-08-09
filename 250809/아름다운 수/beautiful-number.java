import java.util.Scanner;
public class Main {
    static int n, count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
        System.out.print(count);
    }

    public static void dfs(int depth){
        if(depth >= n){
            if(depth == n) count++;
            return;
        }
        for(int i = 1; i<=4; i++){
            dfs(depth+i);
        }
    }
}