import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        //쿼터 25센트
        //다임 10센트
        //니켈 5센트
        //페니 1센트
        int[] arr = {25,10,5,1};

        for(int i = 1; i <= n; i++) {
            int[] changes = {0,0,0,0};
            int change = Integer.parseInt(br.readLine());
            for(int j = 0; j < arr.length; j++) {
                if(change >= arr[j]){
                    changes[j] = (change / arr[j]);
                    change %= arr[j];
                }
            }
            for(int j = 0; j < 4; j++) {
                bw.write(changes[j] + " ");
            }
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}