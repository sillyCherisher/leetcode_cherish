package com.cherish.top100;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Test5 {
    int maxLen = 0;
    int finalLeft = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        for (int i = 0; i < s.length(); i++) {
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return s.substring(finalLeft,finalLeft + maxLen);
    }

    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        if(right - left - 1 > maxLen){
            maxLen = right - left - 1;
            finalLeft = left + 1;
        }
    }
}
