package com.pipickeke.algrithm.code2024.month12.week1;


/**
 *  题目：UTF-8 编码验证
 *  给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，
 * 后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 * 这是 UTF-8 编码的工作方式：
 *
 *       Number of Bytes  |        UTF-8 octet sequence
 *                        |              (binary)
 *    --------------------+---------------------------------------------
 *             1          | 0xxxxxxx
 *             2          | 110xxxxx 10xxxxxx
 *             3          | 1110xxxx 10xxxxxx 10xxxxxx
 *             4          | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * x 表示二进制形式的一位，可以是 0 或 1。
 *
 * 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 *
 *  思路：
 *      需要先建立掩码，MASK1 = 1<<7
 *      MASK2 = 1<<7 + 1 <<6
 *
 *      （1）
 *      如果 num & MASK1 ==0， 则该数字开头不是1，只能是1字节的UTF-8字符
 *      如果 num & MASK1 ==1, 则依次判断后续有多少个连续的1，
 *              通过  mask = MASK1。每次 mask >>1，再  num &mask == 1？ 进行判断
 *              如果有  num & mask ==0，则停止移动，返回记录的连续1有 n 个即可
 *      （2）
 *      因为从 index=0开始遍历数组data[]，如果是1字节的UTF-8，则 index++
 *      如果是 多字节的UTF-8字符，则通过（1）计算此次是 n 字节的字符。
 *        index+1 ~ index+n 都属于该字符，依次判断  index+i 是不是 10 开头的就行
 *
 *      （3） 判断数字是 10 开头，可以通过  num & MASK2 == MASK1 进行判断
 */
public class UTF8_Validation {

    private static final int MASK1 = 1<<7;
    private static final int MASK2 = (1<<7) + (1<<6);

    public static void main(String[] args) {
        UTF8_Validation bean = new UTF8_Validation();
        int[] num  = {197,130,1};
        System.out.println(bean.validUtf8(num));
    }

    private boolean validUtf8(int[] data){
        int N = data.length;
        int index = 0;
        while (index < N){
            int curNum = data[index];

            int n = countOne(curNum);

            if (n < 0 || index+n > N){
                return false;
            }

            for (int i = 1; i < n; i++) {
                if (!isValidate(data[index+i])){
                    return false;
                }
            }
            index += n;
        }
        return true;
    }

    private int countOne(int num){
        if ((num & MASK1)  == 0){
            return 1;
        }

        int mask = MASK1;
        int n = 0;
        while ( (num & mask) != 0 ){
            n++;

            if (n > 4){
                return -1;
            }
            mask >>=1;
        }
        return n >= 2 ? n : -1;
    }

    private boolean isValidate(int num){
        return (num & MASK2) ==  MASK1;
    }
}
