package com.pipickeke.algrithm.code2025.month01.week3;

/**
 * 题目：1694. 重新格式化电话号码
 *
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 *
 * 请你按下述方式重新格式化电话号码。
 *
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * 返回格式化后的电话号码。
 *
 */


public class Reformat_Phone_Number {


    public static void main(String[] args) {
        Reformat_Phone_Number bean = new Reformat_Phone_Number();
        String num = "1-23-45 6";
        bean.reformatNumber(num);
    }

    private String reformatNumber(String number){
        String str = number.replace(" ", "").replace("-", "");
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i+=3) {
            if (sb.length() != 0) sb.append('-');

            if (i+5 > n){
                if (i+3 >= n){
                    sb.append(str.substring(i));
                } else {
                    sb.append(str.substring(i,i+2)).append('-').append(str.substring(i+2));
                }
                break;
            }
            sb.append(str.substring(i,i+3));
        }
        return sb.toString();
    }

}
