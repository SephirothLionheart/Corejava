package com.corejava.ch05.reflection.arrays;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch05.reflection.arrays
 * @Description : 测试利用反射包的Array类写的通用数组拷贝程序
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-10-07  10:38
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: CopyTest
 * PACKAGE: com.corejava.ch05.reflection.arrays
 * Created by Chao Ding at 2017/10/7: 10:39
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import com.corejava.ch05.abstractclass.Employee;

import java.util.Arrays;
import java.util.Calendar;

import static java.lang.System.out;

/**
 * 测试利用反射包的Array类写的通用数组拷贝程序
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see
 */
public class CopyTest {
    public static void main(String[] args) {
        /*测试1*/
        int[] test1Array = {1, 3, 5, 7, 9, 11};
        out.println("【测试1】整型数组拷贝。\n" +
                "原数组 test1Array = " + Arrays.toString(test1Array));
        out.println("复制数组 test1Copy = " + Arrays.toString(
                (int[])CopyOf.copyOf(test1Array, test1Array.length)
        ));

        /*测试2*/
        Employee[] ems = new Employee[3];
        ems[0] =new Employee("Karl Marx", 2011, Calendar.MARCH, 21, 20_000);
        ems[1] =new Employee("Engels Bill", 20131, Calendar.APRIL, 11, 15_000);
        ems[2] =new Employee("Franklin Losford", 1988, Calendar.MAY, 1, 50_000);
        out.println("【测试2】任意对象数组拷贝。\n" +
                "原数组 ems = " + Arrays.toString(ems));
        out.println("复制数组 emsCopy = " + Arrays.toString(
                (Employee[]) CopyOf.copyOf(ems, ems.length)
        ));
    }
}
