import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n2 = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        return map.size()>n2 ? n2 : map.size();
    }
}