package com.pipickeke.algrithm.code2024.month12.week2;

import java.util.HashMap;
import java.util.Map;

public class Can_I_Win_2 {

    private boolean canIWin(int maxChoosableInteger, int desiredTotal){
        if (maxChoosableInteger*(maxChoosableInteger+1) / 2 < desiredTotal){
            return false;
        }
        return dfs_map(0, 0, maxChoosableInteger, desiredTotal);
    }

    /**
     * 暴力递归
     * @param record
     * @param sum
     * @param maxChoose
     * @param desiredTotal
     * @return
     */
    private boolean dfs(int record, int sum, int maxChoose, int desiredTotal){
        for (int i = 1; i <= maxChoose; i++) {

            if ( (record & (1 <<i)) == 1) continue;
            if ( sum + i >= desiredTotal ) return true;
            if ( !dfs( record | (1 <<i), sum+i, maxChoose, desiredTotal ) ){
                return true;
            }
        }
        return false;
    }


    private Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    private boolean dfs_map(int record, int sum, int maxChoose, int desiredTotal){
        if (!map.containsKey(record)){
            boolean res = false;
            for (int i = 1; i <= maxChoose; i++) {

                if ( (record & (1<<i)) == 0 ){
                    if ( sum + i >= desiredTotal ){
                        res = true;
                        break;
                    }
                    if (!dfs_map( record | (1<<i), sum+i, maxChoose, desiredTotal )){
                        res = true;
                        break;
                    }
                }
            }
            map.put(record, res);
        }
        return map.get(record);
    }
}
