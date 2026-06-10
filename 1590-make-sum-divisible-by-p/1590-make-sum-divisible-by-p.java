class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        
        // 1. 전체 배열의 합의 나머지 구하기
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int target = (int) (totalSum % p);
        
        if (target == 0) return 0;
        
        // 2. 해시맵 초기화
        // Key: 누적합 % p, Value: 해당 나머지가 나타난 가장 최근 인덱스
        HashMap<Integer, Integer> modMap = new HashMap<>();
        
        modMap.put(0, -1);
        
        int currentSumMod = 0;
        int minLength = n; // 가장 짧은 길이를 찾기 위해 일단 최대값으로 초기화
        
        // 3. 배열 순회하며 누적합의 나머지 계산하고 매칭되는 과거 기록 찾기
        for (int i = 0; i < n; i++) {
            currentSumMod = (currentSumMod + nums[i]) % p;
            
            // 우리가 과거에서 찾아야 하는 나머지 값 계산
            int neededMod = (currentSumMod - target + p) % p;
            
            // 만약 과거에 해당 나머지가 나온 적이 있다면 그때의 인덱스와 현재 인덱스의 차이 구하기
            if (modMap.containsKey(neededMod)) {
                minLength = Math.min(minLength, i - modMap.get(neededMod));
            }
            
            // 현재의 나머지 위치를 갱신(가장 최근 인덱스로 덮어쓰기)
            modMap.put(currentSumMod, i);
        }
        
        // 4. 예외 처리 및 결과 반환
        // 만약 전체 배열을 다 지워야만 하거나(minLength == n), 조건을 만족하는 구간을 못 찾았다면 -1
        return minLength == n ? -1 : minLength;
    }
}
/*
남은 원소들의 합이 p로 나누어 떨어지게 만드는 가장 짧은 부분 배열의 길이를 구해야 함
그래서 누적합의 나머지를 구해서 필요한 값이 가장 최근에 나온 위치를 체크해서 현재 위치와의 거리를 계산해야 함
*/