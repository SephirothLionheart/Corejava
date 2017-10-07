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
        out.println("[Test1] 拷贝int类型的数组：");
        int[] test1Array = {1, 3, 5, 7, 9, 11};
        out.print("原数组为：");
        out.println(Arrays.toString(test1Array));
        out.print("拷贝数组为：");
        int[] test1Copy = (int[]) CopyOf.copyOf(test1Array, test1Array.length);
        out.println(Arrays.toString(test1Copy));

        Employee[] emp = new Employee[3];
        emp[0] = new Employee("Karl Marx", 2011, Calendar.JANUARY, 11, 20_000);
        emp[1] = new Employee("Engles", 2015, Calendar.MARCH, 12, 15_000);
        emp[2] = new Employee("HelloKitty", 2011, Calendar.MAY, 15, 10_000);

        out.println("原数组为：");
        out.println(Arrays.toString(emp));
        Employee[] empCopy = (Employee[]) CopyOf.copyOf(emp, emp.length);
        out.println("数组副本为：");
        out.println(Arrays.toString(empCopy));
    }
}
