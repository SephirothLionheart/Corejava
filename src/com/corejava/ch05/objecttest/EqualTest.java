package com.corejava.ch05.objecttest;
import com.corejava.ch05.abstractclass.Employee;
import com.corejava.ch05.abstractclass.Manager;

import java.util.Calendar;

import static java.lang.System.out;

/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.objecttest
 * @Description : 测试重载方法equals， hashCode，toString的用法
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-22  16:28
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: EqualTest
 * PACKAGE: com.corejava.ch05.objecttest
 * Created by Chao Ding at 2017/9/22: 16:29
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/
  /**
   * 测试重载方法equals， hashCode，toString的用法
   * @author     Sephiroth
   * @version    0.0.1
   * @since      J2SE-1.6.0u110
   * @see        com.corejava.ch05.abstractclass.Employee
   * @see        com.corejava.ch05.abstractclass.Manager
   */
public class EqualTest {
      public static void main(String[] args) {
          Employee alice1 = new Employee("Alice Adams", 1995, Calendar.APRIL, 15, 10_000);
          Employee alice2 = alice1;  // alice1 和 alice2指向同一个对象
          // alice3 和 alice1 指向状态相同的两个不同的对象
          Employee alice3 = new Employee("Alice Adams", 1995, Calendar.APRIL, 15, 10_000);
          Employee bob = new Employee("Bob Dilan", 1997, Calendar.MARCH, 12, 8_000);

          out.printf("alice1 == alice2: %s \n", (alice1 == alice2));  // boolean变量也可以转换成String
          out.printf("alice1 == alice3: %s \n", (alice1 == alice3));  // 变量指向不同的对象，结果为false
          out.printf("alice1.equals(alice3): %s \n", alice1.equals(alice3));  // 比较两个对象状态是否相同
          out.printf("alice1.equals(bob): %s \n", alice1.equals(bob));    // 比较两个对象是否不同
          out.println("[结论1]只有当两个变量指向同一个对象时，\"==\"符号才能判定两个对象相等。");
          out.println("[结论2]重载后equals函数之后，当两个对象所指向的对象的状态相同，equals即返回true\n" +
                  "不需要为同一个对象");

          Manager boss = new Manager("Carl Marx", 1990, Calendar.JANUARY, 11, 100_000, 200_000);
          Manager rex = new Manager("Lex Burner", 2001, Calendar.MARCH, 12, 80_000, 100_000);
          Manager staffB = new Manager("Carl Marx", 1990, Calendar.JANUARY, 11, 100_000, 200_000);

          out.printf("hashCode(boss): %d\n", boss.hashCode());
          out.printf("hashCode(rex): %d\n", rex.hashCode());
          out.printf("hashCode(staffB): %d\n", staffB.hashCode());
          out.println("[结论3] 重载hashCode之后，只要两个对象状态相同，其hash码必然相同。");

      }
}
