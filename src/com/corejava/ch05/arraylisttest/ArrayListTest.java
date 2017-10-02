package com.corejava.ch05.arraylisttest;

/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.arraylisttest
 * @Description : 将EmployeeTest中的数组替换成动态数组ArrayList类。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-24  14:37
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: ArrayListTest
 * PACKAGE: com.corejava.ch05.arraylisttest
 * Created by Chao Ding at 2017/9/24: 14:38
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import com.corejava.ch05.abstractclass.Employee;
import com.corejava.ch05.abstractclass.Manager;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 将EmployeeTest中的数组替换成动态数组ArrayList类。
 *
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see         com.corejava.ch04.EmployeeTest
 */
public class ArrayListTest {
    public static void main(String[] args) {
        final int INIT_ARRAY_CAPACITY = 100;
        ArrayList <Employee> staffsArr = new ArrayList <>(INIT_ARRAY_CAPACITY);
        staffsArr.add(new Employee("Carl", 1863, Calendar.MARCH, 12, 10_000));
        staffsArr.add(new Manager("Engls", 1888, Calendar.APRIL, 11, 20_000, 50_000));

        for (Employee em : staffsArr) {
            em.raiseSalary(5);
            em.printInfo();
        }
    }
}
