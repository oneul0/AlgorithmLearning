import java.util.stream.IntStream;
class Solution {
    public int[] solution(int n) {
        return IntStream.range(1, n+1)
            .filter(num -> num % 2 == 1)
            .toArray();
    }
}