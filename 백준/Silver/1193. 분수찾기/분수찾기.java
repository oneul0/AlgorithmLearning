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
        int numer,denom;
        int i = 1;
        while(n > i){
            n -= i;
            i++;
        }
        if(i%2 == 0){
            numer = n;
            denom = i - n + 1;
        }
        else{
            numer = i - n + 1;
            denom = n;
        }
        bw.write(numer+"/"+denom+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
}

/*
1 : 1 1
2 : 1 2
3 : 2 1
4 : 3 1
5 : 2 2
6 : 1 3

* */