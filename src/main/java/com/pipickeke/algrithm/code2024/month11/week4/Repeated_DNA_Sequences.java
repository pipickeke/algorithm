package com.pipickeke.algrithm.code2024.month11.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  题目：重复的DNA序列
 *  DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 *
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 *
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的
 * 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 *
 *  思路：
 *  （1） 直接利用hashmap，从头遍历，每次保存10个字符，看看有没有重复的
 *
 *  （2）ACGT，可以分别用
 *      A: 0(00)
 *      C: 1(01)
 *      G: 2(10)
 *      T: 3(11)
 *     2个bit位，则10个字符，可用 20个bit表示，一个int有32位，
 *     可以只取低位的20位。
 *     第一次窗口可以取9个字符： [0,L-1)
 *          (1) 每次先  x<<2，因为每个字符2个bit，所以每次x左移2位
 *          (2)   (x<<2) | bit(char(i))  左移2位后，在与上新字符的bit表示
 *          (3) 窗口移动，需要移除左侧的字符。
 *              因为窗口每次都是先左移2位，在通过与运算，将新字符添加进去，
 *              所以新字符都在低位。老字符都在高位。
 *              而窗口是10个字符，需要移除的是多出的2为
 *              通过 x & ((1 << 20) -1)，就能只保留低位的20位了，
 *              效果就是移除了老字符
 */
public class Repeated_DNA_Sequences {

    public static void main(String[] args) {
        Repeated_DNA_Sequences bean = new Repeated_DNA_Sequences();
        String s = "AAAAAAAAAAA";
        System.out.println(bean.findRepeatedDnaSequences222(s));

    }

    /**
     * 哈希表
     * @param s
     * @return
     */
    private List<String> findRepeatedDnaSequences(String s){
        int L = 10;
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - L; i++) {
            String str = s.substring(i, i + L);
            map.put(str, map.getOrDefault(str, 0)+1);
            if (map.get(str) == 2){
                list.add(str);
            }
        }
        return list;
    }


    /**
     * 滑动窗口+哈希表
     */
    private Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('A',0); // 00
        put('C',1); // 01
        put('G',2); // 10
        put('T',3); // 11
    }};

    private static final int L = 10;

    private List<String> findRepeatedDnaSequences222(String s){
        List<String> ans = new ArrayList<>();

        if (s.length() <= L){
            return ans;
        }

        int x = 0;
        for (int i = 0; i < L - 1; i++) {
            x = (x << 2) | map.get(s.charAt(i));
        }

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i <= s.length()-L; i++) {
            x = ( (x << 2 | map.get(s.charAt(i+L-1))) & ((1 << 2*L) -1) );
            record.put(x, record.getOrDefault(x, 0)+1);
            if (record.get(x) == 2){
                ans.add(s.substring(i, i+L));
            }
        }
        return ans;
    }

}
