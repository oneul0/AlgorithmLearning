import java.util.*;
import java.io.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws Exception
    {
        calc(br.readLine());

        br.close();
        bw.close();
    }

    static void calc(String formula) throws IOException {
        Deque<Character> ops = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String postfix = "";
        //make
        for(int i = 0; i<formula.length(); i++){
            //ops
            char c = formula.charAt(i);
            if(c >= 'A' && c<='Z'){
                sb.append(c);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    sb.append(ops.pop());
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && isPriority(ops.peek()) >= isPriority(c)) {
                    sb.append(ops.pop());
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            sb.append(ops.pop());
        }
        postfix = sb.toString();

        bw.write(postfix);
        bw.flush();
    }


    static int isPriority(char op){
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }
    }

}

