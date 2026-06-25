import java.util.*;
class Solution {
    public int solution(int n) {
        int m = (int)Math.sqrt(n);
        return m*m == n ? 1 : 2;
    }
}