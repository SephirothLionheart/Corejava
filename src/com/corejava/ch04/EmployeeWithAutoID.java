package com.corejava.ch04;

/*
 * ====================================================================
 *
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch04
 * @Description : Employee类的子类，能够自动赋予员工ID
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com
 * @Creation Date: 2017-09-16  23:42
 * @ModificationHistory: Who  When What
 * ====================================================================
 */

/*------------------------------------------------------------
 * Class: EmployeeWithAutoID
 * PACKAGE: com.corejava.ch04
 * Created by Chao Ding at 2017/9/16: 23:43
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import static java.lang.System.out;

/**
 * Employee类的子类，能够自动赋予员工ID
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see         com.corejava.ch04.Employee
 */
public class EmployeeWithAutoID extends Employee {
    /*Fields and Static Fields*/
    private int id;   /*员工ID*/
    private static int nextId = 1;  /*全局的员工id*/
         
     /*Initialization and Static Initialization Blocks*/
     {
         this.id = nextId;
         nextId ++;
     }

    /*Constructors*/

    /**
     * @param name          [String]    员工姓名
     * @param hireYear      [int]       雇佣年份
     * @param hireMonth     [int]       雇佣月份
     * @param hireDay       [int]       雇佣日期
     * @param salary        [double]    薪水
     * @see com.corejava.ch04.Employee#Employee(String, int, int, int, double)
     */
    public EmployeeWithAutoID(String name, int hireYear, int hireMonth, int hireDay, double salary) {
        super(name, hireYear, hireMonth, hireDay, salary);
    }

     /*Getters and Setters*/

    /**
     * 获得员工的工号
     * @return  [int]    员工工号
     */
    public int getId() {
        return this.id;
    }

    /*Methods*/

    @Override
    /**
     * 重载Employee类的printInfo函数，添加了打印工号功能。
     */
    public void printInfo() {
        out.println("==========================================");
        out.printf("工号： %d\n", this.id);
        super.printInfo();

    }
}
