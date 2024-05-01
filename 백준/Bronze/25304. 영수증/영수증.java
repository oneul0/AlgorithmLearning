import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] intArray = new int[st.countTokens()];
            for(int j = 0; j<intArray.length; j++){
                intArray[j] = Integer.parseInt(st.nextToken());
            }
            sum += (intArray[0]*intArray[1]);
        }

        br.close();

        if(s == sum){
            bw.write("Yes");
        }
        else{
            bw.write("No");
        }
        bw.flush();
        bw.close();
    }
}