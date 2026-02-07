import java.util.*;

class Solution {
    int[] number;

    public int solution(int[] number) {
        int answer = 0;
        Arrays.sort(number);
        this.number = number;

        for (int i = 0; i <= number.length - 3; i++) {
            for (int j = i + 1; j <= number.length - 2; j++) {
                int target = -(number[i] + number[j]);
                
                int startIdx = getLowerBound(j + 1, number.length, target);
                int endIdx = getUpperBound(j + 1, number.length, target);
                
                answer += (endIdx - startIdx);
            }
        }
        return answer;
    }

    private int getLowerBound(int start, int end, int target) {
        int l = start, r = end;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (number[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int getUpperBound(int start, int end, int target) {
        int l = start, r = end;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (number[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

//이분탐색 정렬 후 조합 만들고 나머지 0이 되는 하나 찾기