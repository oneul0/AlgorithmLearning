import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws Exception
    {
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            calc(test_case, Integer.parseInt(br.readLine()), br.readLine());
        }

        br.close();
        bw.close();
    }

    static void calc(int tc, int N, String formula) throws IOException {
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String postfix = "";
        //make
        for(int i = 0; i<N; i++){
            //ops
            char c = formula.charAt(i);
            if(c >= '0' && c<='9'){
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
        for(int i = 0; i<postfix.length(); i++){
            //nums
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                nums.push(c - '0');
            } else {
                int n2 = nums.pop();
                int n1 = nums.pop();
                int tmp = calcOps(n1, n2, c);
                nums.push(tmp);
            }
        }

        bw.write("#"+tc+" " +nums.pop()+"\n");
        bw.flush();
    }

    static int calcOps(int n1, int n2, char op){
        if(op == '*') return n1*n2;
        return n1+n2;
    }

    static int isPriority(char op){
        if (op == '+') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 0;
        }
    }

}
