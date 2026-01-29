class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i - 1] == ' ') {
                if (arr[i] >= 'a' && arr[i] <= 'z') {
                    arr[i] -= 32;
                }
            } else {
                if (arr[i] >= 'A' && arr[i] <= 'Z') {
                    arr[i] += 32;
                }
            }
        }
        return new String(arr);
    }
}
