import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        // N을 i번 사용했을 때(dp[i]) 만들 수 있는 숫자들의 집합
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        for (int usedN = 2; usedN <= 8; usedN++) {
            //문자열 덧셈 연산
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(usedN));
            dp.get(usedN).add(repeatedN);
            if (repeatedN == number) return usedN;

            for (int i = 1; i < usedN; i++) {
                for (Integer num1 : dp.get(i)) {
                    for (Integer num2 : dp.get(usedN - i)) {
                        int plus = num1 + num2;
                        int minus = num1 - num2;
                        int multi = num1 * num2;
                        int divide = (num2 != 0 ? num1 / num2 : 0);
                        // 사칙연산
                        dp.get(usedN).add(plus);
                        dp.get(usedN).add(minus);
                        dp.get(usedN).add(multi);
                        if (divide != 0) dp.get(usedN).add(divide);

                        if (plus == number || 
                            minus == number || 
                            multi == number || 
                            (divide != 0 && num1 / num2 == number)) {
                            return usedN;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
