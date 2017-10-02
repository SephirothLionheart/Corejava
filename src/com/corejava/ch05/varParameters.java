package com.corejava.ch05;
import org.jetbrains.annotations.Contract;

import static java.lang.System.out;

/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05
 * @Description : 采用可变参数模式，求取不确定大小数组的最大值
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-25  8:30
 * @ModificationHistory: Who  When What
 *====================================================================
 */
/*------------------------------------------------------------
 * Class: varParameters
 * PACKAGE: com.corejava.ch05
 * Created by Chao Ding at 2017/9/25: 8:35
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

/**
 * 采用可变参数模式，求取不确定大小数组的最大值
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see
 */
public class varParameters {
    public static void main(String[] args) {
        int max = maximum(3, 5, 6, 4, 2, 7, 8, 1000);
        out.println("max(3, 5, 6, 4, 2, 7, 8, 1000) = " + max);
    }

    /**
     * 求取一组整型数的最大值。
     * @param args [int[]] 可变大小的整型数组
     * @return  [int]       整型数组的最大值
     */
    @Contract(pure = true)
    public static int maximum(int...args) {
        int max = Integer.MIN_VALUE;
        for (int i : args) {
            if (i >= max)
                max = i;
        }
        return max;
    }
}
