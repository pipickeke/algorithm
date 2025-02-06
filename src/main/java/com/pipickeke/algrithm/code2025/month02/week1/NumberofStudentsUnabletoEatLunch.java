package com.pipickeke.algrithm.code2025.month02.week1;

/**
 * 题目：1700. 无法吃午餐的学生数量
 *
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，
 * 每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 *
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组 students 和 sandwiches ，其中 sandwiches[i]
 * 是栈里面第 i​​​​​​
 * 个三明治的类型（i = 0 是栈的顶部）， students[j] 是初始队列里第
 * j​​​​​​
 * 名学生对三明治的喜好（j = 0 是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 *
 */


public class NumberofStudentsUnabletoEatLunch {


    private int countStudents(int[] students, int[] sandwiches){

        int[] cnt = new int[2];
        for (int student : students) {
            cnt[student]++;
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (--cnt[sandwiches[i]] == -1){
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}
