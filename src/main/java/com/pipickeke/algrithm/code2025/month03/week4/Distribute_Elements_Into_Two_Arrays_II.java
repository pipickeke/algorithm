package com.pipickeke.algrithm.code2025.month03.week4;

import java.util.ArrayList;
import java.util.Arrays;

public class Distribute_Elements_Into_Two_Arrays_II {

    




}

class Fenwick{

    private final int[] tree;

    public Fenwick(int n) {
        this.tree = new int[n];
    }

    //把下标为i的元素+1
    public void add(int i){

        while (i < tree.length){
            tree[i]++;
            i += i&-i;
        }
    }

    public int pre(int i){
        int sum = 0;
        while (i > 0){
            sum += tree[i];
            i -= i&-i;
        }
        return sum;
    }
}
