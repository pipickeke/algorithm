package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 *  题目：我能赢吗
 *
 *  在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，
 *  累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），
 * 若先出手的玩家能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 *
 *  思路：
 *      两个玩家a,b轮流取值的和 sum，如果a玩家取的x，使得 sum+x >= desiredTotal，则a赢，
 *      而如果b玩家的 sum+x >= desiredTotal，则a输。
 *      所以考虑两种情况，a拿了当前这手，就赢；a 拿了当前这手，b输，则a赢。其他情况都是输
 *      需要从 [1,maxChoose] 遍历尝试。因为不能重拿，则需要记录拿过的数字
 *      sum 从0开始，record通过位图记录拿过的数字
 *      如果当前的 num，满足  record & (1 <<num) ==0，表示这个num没有拿过，可以尝试。否则跳过
 *      （1） 如果 sum+num >= disiredTotal， 则 true， break停止尝试
 *      （2） 否则，当  !dfs()，则true，break停止尝试
 *      dfs(record, sum, maxChoose, desiredTotal)
 *      下一次尝试: dfs(record | (1<<num), sum+num, maxChoose, desiredTotal)
 *
 *      record 记录的是通过位图，记录已经拿过哪些数字。可能出现先1，再拿2； 也可能出现 先拿2，再拿1，
 *      为了加速，可以通过哈希表 map<Int,Bool> 记录每个record是否是赢面，如果已经尝试过，则不用再尝试
 *
 */
public class Ca_I_Win {

    public static void main(String[] args) {
        Ca_I_Win bean = new Ca_I_Win();
        int maxChoose =  10;
        int desired = 11;
        System.out.println(bean.canIWin(maxChoose, desired));
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal){
        //如果从 [1,maxChoose] 之和都小于 desiredTotal，
        // 则肯定二人都无法赢
        if (maxChoosableInteger * (maxChoosableInteger+1) / 2 < desiredTotal){
            return false;
        }
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }

    private Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    private boolean dfs(int record, int sum, int maxChoose, int desiredTotal){
        if (!map.containsKey(record)){

            boolean res = false;
            for (int i = 1; i <= maxChoose; i++) {

                if ( (record & (1<<i)) ==0 ){
                    if (sum + i >= desiredTotal){
                        res = true;
                        break;
                    }
                    if (!dfs((record | (1<<i)), sum+i, maxChoose, desiredTotal)){
                        res = true;
                        break;
                    }
                }
            }
            map.put(record, res);

        }
        return map.get(record);
    }


    private boolean canIWin2(int maxChoosableInteger, int desiredTotal){

        if (maxChoosableInteger*(maxChoosableInteger+1) / 2 < desiredTotal){
            return false;
        }
        return dfs2(0, 0, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs2(int record, int sum, int maxChoose, int desiredTotal){

        for (int i = 1; i <= maxChoose; i++) {
            if ( (record & (1 <<i)) == 1 ) continue;
            if ( sum + i >= desiredTotal ) return true;

            if (!dfs2( record | (1 << i), sum+i, maxChoose, desiredTotal )){
                return true;
            }
        }
        return false;
    }
    


}
