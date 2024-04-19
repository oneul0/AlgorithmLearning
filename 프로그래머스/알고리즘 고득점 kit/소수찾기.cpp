#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 순열을 생성하는 재귀 함수
void generatePermutations(vector<int>& nums, int start, vector<vector<int>>& result) {
    if (start == nums.size()) {
        result.push_back(nums); // 생성된 순열 추가
        return;
    }

    for (int i = start; i < nums.size(); ++i) {
        swap(nums[start], nums[i]); // 요소 교환
        generatePermutations(nums, start + 1, result); // 재귀 호출
        swap(nums[start], nums[i]); // 복구
    }
}

// 순열 생성 함수
vector<vector<int>> permute(vector<int>& nums) {
    vector<vector<int>> result;
    generatePermutations(nums, 0, result);
    return result;
}

int main() {
    vector<int> nums = {1, 2, 3}; // 순열을 생성할 숫자들
    vector<vector<int>> permutations = permute(nums); // 순열 생성

    // 생성된 순열 출력
    for (const auto& perm : permutations) {
        for (int num : perm) {
            cout << num << " ";
        }
        cout << endl;
    }

    return 0;
}
