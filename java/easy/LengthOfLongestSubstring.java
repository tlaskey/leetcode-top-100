public class LengthOfLongestSubstring {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        /*
        abcabbd
        n = 7

        i = 0, j = 0, ans = 0
        set: {}

        i = 0, j = 1, ans = 1
        set: {'a'}

        i = 0, j = 2, ans = 2
        set: {'a', 'b'}

        i = 0, j = 3, ans = 3
        set: {'a', 'b', 'c'}

        i = 1, j = 3, ans = 3
        set: {'b', 'c'}

        i = 1, j = 4, ans = 3
        set: {'b', 'c', 'a'}

        i = 2, j = 4, ans = 3
        set: {c', 'a'}

        i = 2, j = 5, ans = 3
        set: {'c', 'a', 'b'}

        i = 3, j = 5, ans = 3
        set: {'c', 'a'}


        */
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else set.remove(s.charAt(i++));
        }
        return ans;
    }
}