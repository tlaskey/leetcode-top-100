public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        /*
        https://leetcode.com/problems/longest-palindromic-substring/

        input: "babad"
        out: "bab" or "aba"

        input: "cbbd"
        out: "bb"

        input: "acracecarcd"
        out: "cracecarc"

        in: "a"
        o: "a"

        in"cba"
        o: "c" or "b" or "a"
        */

        if (s.length() == 0 || s.length() == 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i > j || i == j) dp[i][j] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {

                int x = j;
                int y = i + j;

                if (dp[x][y] || (dp[x + 1][y - 1] && s.charAt(x) == s.charAt(y))) {
                    String substring = s.substring(x, y + 1);
                    if (result.length() < substring.length()) result = substring;
                    dp[x][y] = true;
                }
            }
        }
        return result;
    }
}
