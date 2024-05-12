import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static List<Integer> primeFactors(int number) {
        List<Integer> primeFactorsList = new ArrayList<>();
        int divisor = 2;
        while (number > 1) {
            while (number % divisor == 0) {
                primeFactorsList.add(divisor);
                number /= divisor;
            }
            divisor++;
        }
        return primeFactorsList;
    }


    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        List<Integer> primeFactorsList = primeFactors(n);
        for(int i = 0; i < primeFactorsList.size(); i++) {
            bw.write(primeFactorsList.get(i) + "\n");
        }
        


        br.close();
        bw.flush();
        bw.close();
    }
}