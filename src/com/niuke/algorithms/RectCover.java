package com.niuke.algorithms;

public class RectCover {
    public int RectCover(int target) {
        // 如果n=1，则2*1只有一种放法
        // 如果n>1，则2*n有两种方案：
        // 1. 横着放一个，成2*(n-1)
        // 2. 竖着放两个占满空间2*2，剩余空间为2*(n-2)
        if (target <= 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        else return RectCover(target - 2) + RectCover(target - 1);
    }

    public static void main(String[] args) {
        System.out.println(new RectCover().RectCover(3));
    }
}
