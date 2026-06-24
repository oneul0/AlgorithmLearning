import java.util.*;
class Solution {
    public int solution(int[] array, int height) {
        return Arrays.stream(array)
            .filter(n -> n > height)
            .toArray().length;
    }
}