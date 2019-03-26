package com.xyj.codeInterview;

/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
*/

public class Solution10 {
    public int Fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int a = 0, b = 1, num = 0;
        for(int i = 2; i <=n ; i++){
            num = a + b;
            a = b;
            b = num;
        }
        return num;
    }
}
