package main.com.guo;

/**
 题目：最长回文子串

 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if(s.isEmpty()) return "";
        char[] ca = s.toCharArray();
        int rs = 0, re = 0;
        int max = 0;
        for(int i = 0; i < ca.length; i++) {
            if(isPalindrome(ca, i - max - 1, i)) {
                rs = i - max - 1; re = i;
                max += 2;
            } else if(isPalindrome(ca, i - max, i)) {
                rs = i - max; re = i;
                max += 1;
            }
        }
        return s.substring(rs, re + 1);
    }

    private boolean isPalindrome(char[] ca, int s, int e) {
        if(s < 0) return false;

        while(s < e) {
            if(ca[s++] != ca[e--]) return false;
        }
        return true;
    }


}