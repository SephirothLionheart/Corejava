package com.corejava.ch05;/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05
 * @Description : Employee派生类Manager的测试类，测试Java的多态性
 *                和动态绑定。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-19  16:22
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: ManagerTest
 * PACKAGE: com.corejava.ch05
 * Created by Chao Ding at 2017/9/19: 16:23
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import com.corejava.ch04.Employee;

import java.util.Calendar;
import java.util.Random;

/**
 * Employee派生Manager类的测试类，测试多态和动态绑定
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see com.corejava.ch05.Manager
 * @see com.corejava.ch04.Employee
 * @see com.corejava.ch04.EmployeeWithAutoID
 */
public class ManagerTest {
    public static void main(String[] args) {
        Employee[] staffs = new Employee[3];
        /*超类的变量可以指向子类的对象*/
        staffs[0] = new Manager("Chao Ding", 2013, Calendar.DECEMBER, 11, 50_000, 10_000);
        staffs[1] = new Employee("Mary", 2014, Calendar.APRIL, 13, 30_000);
        staffs[2] = new Employee("Lijun", 2015, Calendar.JANUARY, 1, 20_000);

        for (Employee em : staffs) {
            em.raiseSalary(new Random().nextDouble() * 100);
            em.printInfo();
        }

        Employee em = new Manager("Li Shuyue", 2014, Calendar.APRIL, 12, 10_000, 2_000);
        ((Manager) em).setBonus(10_000);
    }
}
