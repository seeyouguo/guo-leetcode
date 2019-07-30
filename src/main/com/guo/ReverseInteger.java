package main.com.guo;

public class ReverseInteger {


    /* 题目 整数反转
        143
        341
Given a 32-bit signed integer, reverse digits of an integer.
     */
    public int reverse(int x) {
        int lest = Math.abs(x);
        if(lest == 0) return 0;
        StringBuilder sb = new StringBuilder();
        if(x < 0){
            while(lest > 0){
                sb.append(lest % 10);
                lest /= 10;
            }
            if(sb.toString().isEmpty()) return 0;
            if(Long.parseLong(sb.toString()) > Integer.MAX_VALUE) return 0;
            if(Long.parseLong(sb.toString()) < Integer.MIN_VALUE) return 0;
            return -Integer.parseInt(sb.toString());
        }else {
            while(lest > 0){
                sb.append(lest % 10);
                lest /= 10;
            }
        }
        if(sb.toString().isEmpty()) return 0;
        if(Long.parseLong(sb.toString()) > Integer.MAX_VALUE) return 0;
        if(Long.parseLong(sb.toString()) < Integer.MIN_VALUE) return 0;
        return Integer.parseInt(sb.toString());
    }
}
