class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder path = new StringBuilder();
        int[] count = new int[1];
        String[] answer = new String[1];

        backtrack(n, k, count, answer, path);

        return answer[0] == null ? "" : answer[0];
    }

    private void backtrack(int n, int k, int[] count, String[] answer, StringBuilder path) {
        if (answer[0] != null) return;

        if (path.length() == n) {
            count[0]++;

            if (count[0] == k) {
                answer[0] = path.toString();
            }

            return;
        }

        char[] chars = {'a', 'b', 'c'};

        for (char ch : chars) {
            int len = path.length();

            if (len > 0 && path.charAt(len - 1) == ch) {
                continue;
            }

            path.append(ch);
            backtrack(n, k, count, answer, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}