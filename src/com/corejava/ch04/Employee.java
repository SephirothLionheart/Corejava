package com.corejava.ch04;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.lang.System.out;

/*
 * ====================================================================
 *
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch04
 * @Description : 定义了一个雇员类，可以打印雇员的基本信息，调整员工薪金。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com
 * @Creation Date: 2017-09-16  22:38
 * @ModificationHistory: Who  When What
 * ====================================================================
 */

/*------------------------------------------------------------
 * Class: Employee
 * PACKAGE: com.corejava.ch04
 * Created by Chao Ding at 2017/9/16: 23:35
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

/**
 * 定义了一个雇员类，可以打印雇员的基本信息，调整员工薪金
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see         com.corejava.ch04.EmployeeTest
 */
public class Employee {
    /*Fields and Static Fields*/
    private String name;   /*员工姓名*/
    private double salary;  /*员工薪水*/
    private Date hireDay;   /*雇佣日期*/

     /*Initialization and Static Initialization Blocks*/
     {
         this.salary = 10_000.00;  // 10k per month;
         this.hireDay = new GregorianCalendar(1999, Calendar.MARCH, 1)
                                            .getTime(); // the day company created
     }

    /*Constructors*/

    /**
     * @param name      员工姓名
     */
    public Employee(String name) {
        this.name = name;
    }

    /**
     * @param name         [String]  员工姓名
     * @param hireYear     [int]     雇佣年份
     * @param hireMonth    [int]     雇佣月份
     * @param hireDay      [int]     雇佣日期
     * @param salary       [double]  薪水
     */
    public Employee(String name, int hireYear, int hireMonth, int hireDay, double salary) {
        this.name = name;
        this.hireDay = new GregorianCalendar(hireYear, hireMonth,
                                             hireDay).getTime();
        this.salary = salary;
    }

     /*Getters and Setters*/

    /**
     * @return  [String]   员工姓名
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return  [double]   员工薪水
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * @return  [Date]     雇佣日期
     */
    public Date getHireDay() {
        return (Date) this.hireDay.clone();
    }

    /*Methods*/

    /**
     * 根据参数byPercent调整员工薪金，定义薪金为s， 调整公式为：
     * <blockquote><img src="doc-files/eq1.gif" alt="Equation1"></blockquote>
     * @param byPercent  [double]   调整的比例，以百分数计.
     */
    public void raiseSalary(double byPercent) {
        this.salary *= (100.0 + byPercent) / 100.0;
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
