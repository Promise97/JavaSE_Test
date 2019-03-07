package com.xyj.codeInterview;

/*      在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
        也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数
        组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。*/

import java.util.HashSet;

public class Solution03 {
    //空间复杂度O(1)
    public boolean duplicate1(int[] numbers,int length,int[] duplication) {
        if(numbers == null)
            return false;
        for(int i = 0; i < length; ++i){
            if(numbers[i] <0 || numbers[i] >= length)
                return false;
        }

        for(int i = 0; i < length; i++){
            while(i != numbers[i]){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[numbers[i]] = temp;
            }
        }
        return false;
    }
    //时间复杂度O(N) 空间复杂度O(N)
    public boolean duplicate2(int[] numbers, int length, int[] duplication) {
        boolean[] help = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (help[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            help[numbers[i]] = true;
        }
        return false;
    }
}
