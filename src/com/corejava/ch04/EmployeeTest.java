package com.corejava.ch04;

/*
 * ====================================================================
 *
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch04
 * @Description : Employee， EmployeeWithAutoID, EmployeeWithRandID类
 *                的测试用例
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com
 * @Creation Date: 2017-09-16  23:30
 * @ModificationHistory: Who  When What
 * ====================================================================
 */

/*------------------------------------------------------------
 * Class: EmployeeTest
 * PACKAGE: com.corejava.ch04
 * Created by Chao Ding at 2017/9/16: 23:34
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import java.util.Calendar;
import java.util.Random;

import static java.lang.System.out;

/**
 * Employee， EmployeeWithAutoID, EmployeeWithRandID类的测试用例
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see         com.corejava.ch04.Employee
 */
public class EmployeeTest {
     public static void main(String[] args) {
         Employee[] staffs = new Employee[3];
         staffs[0] = new Employee("Chao Ding", 2013, Calendar.MARCH, 11, 12000.00);
         staffs[1] = new Employee("Yang Lijun", 2014, Calendar.JANUARY, 11, 11000.0);
         staffs[2] = new Employee("Meng Wu", 1995, Calendar.APRIL, 15, 20_000.00);

         Random rand = new Random();
         for (Employee em : staffs) {
             em.raiseSalary(rand.nextDouble() * 100);
             em.printInfo();
         }

         out.println();
         EmployeeWithAutoID[] staffs1 = new EmployeeWithAutoID[3];
         staffs1[0] = new EmployeeWithAutoID("Chao Ding", 2013, Calendar.MARCH, 11, 12000.00);
         staffs1[1] = new EmployeeWithAutoID("Yang Lijun", 2014, Calendar.JANUARY, 11, 11000.0);
         staffs1[2] = new EmployeeWithAutoID("Meng Wu", 1995, Calendar.APRIL, 15, 20_000.00);

         for (EmployeeWithAutoID em : staffs1) {
             em.raiseSalary(rand.nextDouble() * 100);
             em.printInfo();
         }
     }
}
