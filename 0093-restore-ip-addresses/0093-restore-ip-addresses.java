class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> parts = new ArrayList<>();

        backtrack(s, 0, parts, result);

        return result;
    }

    private void backtrack(String s, int index, List<String> parts, List<String> result) {
        if (parts.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            if (!isValid(part)) continue;

            parts.add(part);
            backtrack(s, index + len, parts, result);
            parts.remove(parts.size() - 1);
        }
    }

    private boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') return false;

        int value = Integer.parseInt(part);

        return value >= 0 && value <= 255;
    }
}