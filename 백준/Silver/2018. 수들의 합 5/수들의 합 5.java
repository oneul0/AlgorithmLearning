import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int start = 1, end = 1, sum = 1;
        while(end != N){
            if(sum == N){
                cnt++;
                end++;
                sum += end;
            }
            else if(sum > N){
                sum -= start;
                start++;
            }
            else{
                end++;
                sum+=end;
            }
        }
        System.out.println(cnt);
    }
}
