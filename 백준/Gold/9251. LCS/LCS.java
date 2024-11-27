import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] lcs = new int[1001][1001];

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        bw.write(lcs[s1.length()][s2.length()]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
