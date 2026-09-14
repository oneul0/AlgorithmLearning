import java.util.Scanner;
public class Main {
    static int[][] grid;
    static int n, maxVal = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        백트래킹(0, 0, 0);
        System.out.print(maxVal);
    }
    public static void 백트래킹(int r, int sum, int colored){
        if(r == n){
            maxVal = Math.max(maxVal, sum);
            return;
        }

        for(int c = 0; c<n; c++){
            if((colored & (1<<c)) == 0){
                백트래킹(r+1, sum + grid[r][c], colored | (1<<c));
            }
        }
    }
}