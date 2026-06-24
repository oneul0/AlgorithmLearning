import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(Arrays.asList(s1));

        return (int) Arrays.stream(s2)
                .filter(set::contains)
                .count();
    }
}