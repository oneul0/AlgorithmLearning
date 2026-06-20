class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        //max heap 만들기
        for(int i = n/2-1; i>=0 ; i--){
            heapify(nums, n, i);
        }
        for(int end = n-1; end>0; end--){
            swap(nums, 0, end); // 현재 최댓값을 맨 뒤로 이동
            heapify(nums,end, 0); //남은 구간에서 heap 성질 복구
        }

        return nums;
    }

    public void heapify(int[] nums, int size, int root){
        int largest = root;
        //완전 이진트리의 왼쪽 오른쪽 노드
        int left = root*2 + 1; // 그냥 공식임 완전이진트리라 가능
        int right = root*2 + 2;

        //root, left, right 중 큰 것 추출
        if(left < size && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < size && nums[right] > nums[largest]){
            largest = right;
        }

        if(largest != root){
            swap(nums, root, largest);
            heapify(nums, size, largest);
        }
        
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}