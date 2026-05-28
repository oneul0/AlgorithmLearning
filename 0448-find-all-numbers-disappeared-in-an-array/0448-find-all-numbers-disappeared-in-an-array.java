class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length+1;
        boolean[] chk = new boolean[n+1];
        for(int i : nums){
            chk[i] = true;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<n; i++){
            if(!chk[i]) list.add(i);
        }
        return list;
    }
}