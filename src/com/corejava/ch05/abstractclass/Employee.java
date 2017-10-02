package com.corejava.ch05.abstractclass;
/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.com.corejava.ch05.abstractclass
 * @Description : Person抽象类的子类，用于描述公司雇员的基本信息。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-21  19:58
 * @ModificationHistory: Who  When What
 *====================================================================
 */

import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import static java.lang.System.out;

 /*------------------------------------------------------------
  * Class: Employee
  * PACKAGE: com.corejava.ch05.com.corejava.ch05.abstractclass
  * Created by Chao Ding at 2017/9/21: 20:09
  * Modification History:
  *    1. [When]  [Who]  [How]
  *    2. ....
  ------------------------------------------------------------*/

 /**
  * Person抽象类的子类，用于描述公司雇员的基本信息。
  * @author     Sephiroth
  * @version    0.0.1
  * @since      J2SE-1.6.0u110
  * @see        Person
  */
public class Employee extends Person {
     private double salary;
     private Date hireDay;

    /*Constructors*/

     /**
      * 雇员类Employee的构造器
      *
      * @param name   [String]    员工姓名
      * @param year   [int]       雇佣年份
      * @param month  [int]       雇佣月份
      * @param day    [int]       雇佣日期
      * @param salary [double]    薪水
      */
     public Employee(String name, int year, int month, int day, double salary) {
         super(name);
         this.hireDay = new GregorianCalendar(year, month, day).getTime();
         this.salary = salary;
     }

     /*Methods*/
     public String getDescription() {
         return String.format("He is a employee hired in %1$tB %1$td, %1$tY.\nNow, his salary is %2$s.\n",
                 hireDay,
                 NumberFormat.getCurrencyInstance().format(this.salary));
     }

     @Override
     /**
      * 比较参数所指向的对象是否与this对象状态相同
      * @param other    [Ojbect] 其他对象
      * @return [boolean]   比较结果
      */
     public boolean equals(Object other) {
         if (other == null)
             return false;
         if (this == other)
             return true;
         if (getClass() != other.getClass())
             return false;
         Employee otherEmployee = (Employee) other;
         return Objects.equals(this.name, otherEmployee.name) &&
                 Objects.equals(this.hireDay, otherEmployee.hireDay) &&
                 this.salary == otherEmployee.salary;
     }

     /**
      * 返回员工薪水
      *
      * @return [double]    员工薪水
      */
     public double getSalary() {
         return this.salary;
     }

     /**
      * 调整薪酬
      * @param  byPercent 【double】  调整薪酬幅度
      */
     public void raiseSalary(double byPercent) {
         this.salary *= (100.0 + byPercent) /100.0;
     }

     @Override
     /**
      * 返回Employee对象的哈希值，是对象内各个实例域哈希值的线性组合。
      * @return
      */
     public int hashCode() {
         return 7 * Objects.hashCode(super.getName()) +
                 11 * Objects.hashCode(this.hireDay) +
                 13 * Double.valueOf(this.salary).hashCode();

     }

     @Override
     /**
      * 重载Object类的toString方法，该方法显示如下
      *  包名称.类名称[实例域1 = xx， 实例域2 = yy， 实例域3 = zz]
      *  @return [String]   类的描述语句
      *  @see   Object#toString()
      */
     public String toString() {
         return String.format("%s[name=%s, salary = %s hireDay = %4$tY-%4$tm-%4$td]\n",
                 getClass().getName(),
                 this.name,
                 NumberFormat.getCurrencyInstance(Locale.CHINA).format(this.salary),
                 this.hireDay);
     }

     /**
      * 打印Employee对象的基本信息, 输出形如：
      *   <p>姓名：丁超 </p>
      *   <p>雇佣日期： 2015-03-21</p>
      *   <p>薪金：￥20_000.00</p>
      */
     public void printInfo() {
         out.printf("姓名：%s\n", this.name);
         out.printf("雇佣日期： %1$tY-%1$tm-%1td\n", this.hireDay);
         out.printf("薪水：%s\n", NumberFormat.getCurrencyInstance(Locale.CHINA).format(this.salary));
     }
 }