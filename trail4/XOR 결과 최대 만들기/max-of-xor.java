import java.util.Scanner;

public class Main {
    static int n, m;
    static int maxVal = 0;
    static int[] A;
    public static void comb(int start, int val, int count, int mask){
        if(count == m){
            maxVal = Math.max(maxVal, val);
            return;
        }
        for(int i = start; i<n; i++){
            if((mask & (1<<i)) != 0) continue;
            mask |= (1<<i);
            comb(i+1, val^A[i], count+1, mask);
            mask &= ~(1<<i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        comb(0, 0, 0, 0);
        
        System.out.print(maxVal);
    }
}