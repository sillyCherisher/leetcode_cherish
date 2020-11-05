package com.cherish.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Test9 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"qprs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        helper(digits, 0, "", map, res);
        return res;
    }

    private void helper(String digits, int index, String temp, HashMap<Character, String> map, List<String> res) {
        if(index == digits.length()){
            res.add(temp);
        }

        char digit = digits.charAt(index);

        String tempS = map.get(digit);
        for (int i = 0; i < tempS.length(); i++) {
            temp += tempS.charAt(index);
            helper(digits, i + 1, temp, map, res);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
