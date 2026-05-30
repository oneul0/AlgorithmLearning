class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int targetIndex = 0;
        for (int stream = 1; stream <= n; stream++) {
            result.add("Push");
            if (stream == target[targetIndex]) {
                targetIndex++;
                if (targetIndex == target.length) {
                    break;
                }
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}