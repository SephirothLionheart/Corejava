package com.corejava.ch05.abstractclass;

/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.abstractclass
 * @Description : 抽象类Person及其子类Employee，Student的测试类。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-21  20:24
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: PersonTest
 * PACKAGE: com.corejava.ch05.abstractclass
 * Created by Chao Ding at 2017/9/21: 20:24
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import java.util.Calendar;
import java.util.Locale;

import static java.lang.System.out;

/**
 * 抽象类Person及其子类Employee，Student的测试类。
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see
 */
public class PersonTest extends Object{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Person[] persons = new Person[3];
        persons[0] = new Employee("Chao Ding", 2015, Calendar.APRIL, 13, 20_000);
        persons[1] = new Student("Lijun Yang", "Naning University of Posts and Telecomm.", "Info. Sec.");
        persons[2] = new Manager("Meng Wu", 1993, Calendar.MARCH, 11, 20_000, 30_000);
        for (Person p : persons) {
            out.printf("%s:", p.getName());
            out.println(p.getDescription());
        }

        Manager m = (Manager) persons[2];
//        out.println("测试getClass函数");
//        out.printf("Manager m, m.getClass()=%s.\n", m.getClass().toString());
        out.println("[测试toString函数]对于Manager对象m, m.toString为：");
        out.println("" + m);
    }
}
