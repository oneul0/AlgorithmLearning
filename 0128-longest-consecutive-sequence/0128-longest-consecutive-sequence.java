class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }

        int longest = 0;

        for(int num : numSet){
            if(!numSet.contains(num-1)){
                int cur = num;
                int length = 1;

                while(numSet.contains(cur+1)){
                    cur++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}

//정렬을 안 쓰고 유니온 파인드로 풀기는 DSU 클래스 만들어서 푸는 풀이를 추천하던데
//억 DSU 같아서 Set 기반 선형 탐색으로 풀었음..