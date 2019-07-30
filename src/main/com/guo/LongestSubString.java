package main.com.guo;

import java.util.*;

/**
 * 题目：无重复字符的最长子串
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {


    /**
     * 遍历 查询是否包含
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int current = 0;
        char[] charArray = s.toCharArray();
        List<Character> charList = new LinkedList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charList.contains(charArray[i])) {
                longest = longest > current ? longest : current;
                int currentIndex = charList.indexOf(Character.valueOf(charArray[i])); //子字符串是否包含当前字符
                charList = currentIndex < (charList.size() - 1) ?
                        charList.subList(charList.indexOf(Character.valueOf(charArray[i])) + 1, charList.size()) : new ArrayList<>();
                current = charList.size();
            }
            current += 1;
            charList.add(charArray[i]);
        }
        return longest > current ? longest : current;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


    /**
     * i和j作为窗口 一直比较j和 i-j之间的值，如果相同则移除重复index之前的所有元素
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring4(String s) {
        int n = s.length();
        int ans = 0, i=0, j=0;
        Set<Character> set = new HashSet<>();
        while(i < n&& j< n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
