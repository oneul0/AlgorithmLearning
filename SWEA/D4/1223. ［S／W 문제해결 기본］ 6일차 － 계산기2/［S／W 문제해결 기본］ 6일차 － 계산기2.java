import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException
    {
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            calc(test_case, Integer.parseInt(br.readLine()), br.readLine());
        }

        br.close();
        bw.close();
    }

    static void calc(int tc, int N, String formula) throws IOException
    {
        Deque<Character> ops = new ArrayDeque<>(); //만들때
        Deque<Integer> nums = new ArrayDeque<>(); //계산할때
        StringBuilder sb = new StringBuilder();
        String postfix="";

        //만들기 만들 때는 연산자를 넣기
        for(int i = 0; i<N; i++){
            char cur = formula.charAt(i);
            //숫자면
            if(cur >= '0' && cur <='9'){
                sb.append(cur);
            }
            else{
                if(ops.isEmpty()){
                    ops.push(cur);
                }
                else{
                    //우선순위가 낮은 연산자가 나올 때 까지 pop
                    while(!ops.isEmpty() && isPriority(ops.peek(), cur)){
                        sb.append(ops.pop());
                    }
                    //우선순위 낮은 연산자 나오면 지금 연산자 push
                    ops.push(cur);
                }
            }

        }
        while(!ops.isEmpty()){
            sb.append(ops.pop());
        }
        postfix = sb.toString();
        //계산할 때는 피연산자를 넣기 피연산자를 만나면 2개 빼서 연산 후 집어넣기 이미 우선순위가 수식에서 있으니까
        for(int i = 0; i<N; i++){
            char cur = postfix.charAt(i);
            if(cur >= '0' && cur <='9'){
                nums.push(cur-'0');
            }
            else{
                int n1 = nums.pop();
                int n2 = nums.pop();
                int tmp = calcOps(n1,n2,cur);
                nums.push(tmp);
            }
        }
        bw.write("#"+tc+" "+nums.pop()+"\n");
        bw.flush();
    }
    static int calcOps(int n1, int n2, char op){
        if(op == '+') return n1+n2;
        return n1*n2;
    }
    static boolean isPriority(char top, char cur){
        if(cur == '*' && top == '*') return true;
        if(cur == '+' && top == '+') return true;
        if(cur == '+' && top == '*') return true;
        return false;
    }
}
