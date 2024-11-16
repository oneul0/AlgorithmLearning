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
    //후위 표기식 계산 메서드
    public static void calc(int tc, int N, String formula)  throws IOException{
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder();

        //후위 표기식으로 변환(만들 때는 연산자를 스택에)
        for(int i = 0; i<N; i++){
            char c = formula.charAt(i);
            if(c == '+'){
                while(!ops.isEmpty()){
                    postfix.append(ops.pop());
                }
                ops.push(c);
            }
            else if(c != '+'){
                postfix.append(c);
            }
        }
        while(!ops.isEmpty()){
            postfix.append(ops.pop());
        }
        String postfixString = postfix.toString();
        //후위 표기식을 계산(계산할 때는 피연산자를 스택에)
        //연산자를 만날 때 까지 스택에 추가
        //연산자를 만나면 직전 피연산자 2개를 꺼내어 계산 후 스택에 추가
        for(int i = 0; i<N; i++){
            char c = postfixString.charAt(i);
            if(c != '+'){
                nums.push(c-'0');
            }
            else{
                int num1 = nums.pop();
                int num2 = nums.pop();
                int tmp = num1+num2;
                nums.push(tmp);
            }
        }
        bw.write("#"+tc+" "+nums.pop()+"\n");
        bw.flush();
    }
}