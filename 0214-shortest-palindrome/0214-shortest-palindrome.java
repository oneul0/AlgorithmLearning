class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = buildLPS(combined);

        int palLen = lps[combined.length() - 1];

        String suffix = s.substring(palLen);
        String prefix = new StringBuilder(suffix).reverse().toString();

        return prefix + s;
    }

    private int[] buildLPS(String str) {
        int[] lps = new int[str.length()];
        int len = 0;

        for (int i = 1; i < str.length(); i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)) {
                len = lps[len - 1];
            }

            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
            }
        }

        return lps;
    }
}


/*
1. rev = reverse(s)
2. combined = s + "#" + rev
3. combined의 LPS 배열 계산
4. pal_len = lps[-1]
5. s[pal_len:] 부분을 뒤집어 앞에 붙임
*/