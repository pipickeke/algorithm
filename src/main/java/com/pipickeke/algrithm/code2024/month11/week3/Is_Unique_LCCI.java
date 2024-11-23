package com.pipickeke.algrithm.code2024.month11.week3;

/**
 *  题目：判定字符是否唯一
 *  实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 *  思路：
 *  利用位图，str 只包含小写字母，则默认有个26长度的数组，
 *  数组的每个位置表示一种字符存在与否的标志，
 *  [0000...000]
 *  例如， a 存在，则可以表示为：[000...0001]
 *  b存在，可以表示为：[000....010]
 *  先计算每个字符与 'a' 的距离 cur，
 *  然后用数字 mark 表示这个数组。
 *  先通过  1<< cur，
 *  再判断  mark & (1<<cur) == 1 ？
 *  如果==1，表示该字符已经存在，否则不存在
 *  每次循环，都将 cur 加入 mark ：mark |= (1 << cur)
 *
 */
public class Is_Unique_LCCI {

    public static void main(String[] args) {
        System.out.println(unique("abc"));
    }

    private static boolean unique(String str){

        if (str.length() > 26){
            return false;
        }

        int mark = 0;
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i) - 'a';
            if ( (mark & (1 << cur)) != 0 ){
                return false;
            } else {
                mark = mark | (1 << cur);
            }
        }
        return true;
    }
}
