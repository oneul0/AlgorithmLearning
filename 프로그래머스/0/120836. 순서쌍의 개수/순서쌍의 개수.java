import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                answer += 2;
                if (i * i == n) answer--;
            }
        }
        return answer;
    }
}