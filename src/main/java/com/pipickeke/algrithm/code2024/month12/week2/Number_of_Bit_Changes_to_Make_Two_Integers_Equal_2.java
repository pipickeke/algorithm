package com.pipickeke.algrithm.code2024.month12.week2;

public class Number_of_Bit_Changes_to_Make_Two_Integers_Equal_2 {

    private int minChanges(int n, int k){
        int ans = 0;
        while (n != 0 || k != 0){
            int cur1 = n&1;
            int cur2 = k&1;
            if ((cur1 ^ cur2) == 1){
                ans += cur1 == 1 ? 1 : 0;
                if (cur1 == 0){
                    return -1;
                }
            }
            n >>=1;
            k >>=1;
        }
        return ans;
    }
}
