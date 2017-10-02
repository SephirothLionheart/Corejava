package com.corejava. ch05.enumtest;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.enumtest
 * @Description : TODO
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-25  16:54
 * @ModificationHistory: Who  When What
 *====================================================================
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner inScan = new Scanner(in);
        out.println("请输入枚举Size的类型（SMALL, MEDIUM, LARGE, EXTRA_LARGE）：");
        String input = inScan.next();
        switch (input) {
            case "SMALL":
                break;
            case "MEDIUM":
                break;
            case "LARGE":
                break;
            case "EXTRA_LARGE":
                break;
            default:
                out.println("输入错误，程序退出。");
                return;
        }

        Size sz = Size.valueOf(Size.class, input);
        out.println("sz = " + sz);      //默认调用sz.toString()函数

        if (sz == sz.EXTRA_LARGE)    // 与普通类不同，枚举相等性测试直接采用==， 而不是equals
            out.println("Good job! 你没有忘记下划线");
    }
}
