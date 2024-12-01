package com.pipickeke.algrithm.code2024.month11.week4;


/**
 *  题目：数字转换为十六进制数
 *
 *  给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。
 *
 * 注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。
 *
 *  思路：
 *      16进制，是每次从低位取 4个bit，转换出来进行表达
 *      可以直接用  num & 15，就可以取到低位的4位
 *      然后 num >>>=4 ，无符合右移4位即可，因为考虑到负数用补码表示，所以使用无符合移动
 */
public class Convert_a_Number_to_Hexadecimal {

    public static void main(String[] args) {
        int num = -1;
        Convert_a_Number_to_Hexadecimal bean = new Convert_a_Number_to_Hexadecimal();
        bean.print32Bit(num);
        System.out.println(bean.toHex(num));
    }

    private void print32Bit(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1 <<i)) == 0 ? 0 : 1 );
        }
        System.out.println();
    }

    private String toHex(int num){
        if (num == 0) {
            return "0";
        }
        String[] ch = new String[]{"a", "b", "c", "d", "e", "f"};
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            int dis = (num & 15);
            sb.append( dis > 9 ? ch[dis-10] : dis);
            num >>>=4;
        }
        return sb.reverse().toString();
    }
}
