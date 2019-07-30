package main.com.guo;

/**
 * 题目：字符串转换整数 (atoi)
 * String to Integer (atoi)
 *

 Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.

 Note:

 Only the space character ' ' is considered as whitespace character.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [?231,  231 ? 1]. If the numerical value is out of the range of representable values, INT_MAX (231 ? 1) or INT_MIN (?231) is returned.
 Example 1:

 Input: "42"
 Output: 42

 Example 2:

 Input: "   -42"
 Output: -42
 Explanation: The first non-whitespace character is '-', which is the minus sign.
 Then take as many numerical digits as possible, which gets 42.
 Example 3:

 Input: "4193 with words"
 Output: 4193
 Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 Example 4:

 Input: "words and 987"
 Output: 0
 Explanation: The first non-whitespace character is 'w', which is not a numerical
 digit or a +/- sign. Therefore no valid conversion could be performed.



 */
public class String2IntegerAtoi {

    /*
     大写字母（A-Z）：65 （A）~ 90（Z）
     小写字母（a-z）：97（a） ~ 122（z）
     字符数字（'0' ~ '9'）：48（'0'） ~ 57（'9'）
      */
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char now = str.charAt(i);
            if(now >= 48 && now <= 57){
                sb.append(now);
            }else if (sb.length() == 0 && Character.isSpaceChar(now)){
                continue;
            }else if (sb.length() == 0 && (Character.compare(now, '-') == 0 || Character.compare(now, '+') == 0)){
                sb.append(now);
            }else {
                return parseSb(sb);
            }
        }

        return parseSb(sb);
    }

    private int parseSb(StringBuilder sb){
        if(sb.length() > 0){
            if(sb.toString().equals("-") || sb.toString().equals("+")) return 0;
            if(new java.math.BigInteger(sb.toString()).compareTo(new java.math.BigInteger(String.valueOf(Integer.MAX_VALUE))) != -1)
                return Integer.MAX_VALUE;
            else if(new java.math.BigInteger(sb.toString()).compareTo(new java.math.BigInteger(String.valueOf(Integer.MIN_VALUE))) != 1)
                return Integer.MIN_VALUE;
        }
        return sb.length() > 0 ? Integer.parseInt(sb.toString()) : 0;
    }

}

