package com.corejava.ch05;
/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05
 * @Description : 由Employee产生的派生类
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-18  1:54
 * @ModificationHistory: Who  When What
 *====================================================================
 */
import com.corejava.ch04.EmployeeWithAutoID;

import java.text.NumberFormat;

import static java.lang.System.out;

/**
 * 由Employee产生的派生类
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see        com.corejava.ch04.Employee
 * @see         com.corejava.ch04.EmployeeWithAutoID
 */
public class Manager extends EmployeeWithAutoID {
    //Fields and Static Fields
     private double bonus;

    // Initialization Blocks


    // Constructors
    public Manager(String name, int hireYear, int hireMonth, int hireDay, double salary, double bonus) {
        super(name, hireYear, hireMonth, hireDay, salary);
        this.bonus = bonus;
    }

    // Getters and Setters
    /**
     * 获取经理人的奖金
     * @return  [double]    奖金
     */
    public double getBonus() {
        return this.bonus;
    }
    /**
     *
     设置经理人的奖金
     * @param bonus     [double]    奖金
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;

    }

    /**
     * 返回经理人的薪水（工资+奖金）
     * @return  [double]  薪水
     */
    @Override
    public double getSalary() {
        double v = super.getSalary() + this.bonus;
        return v;
    }
    // methods

    @Override
    public void printInfo() {
        out.printf("工号： %d\n", super.getId());
        out.printf("姓名： %s\n", getName());
        out.printf("雇佣日期： %1$tY-%1$tm-%1td\n", super.getHireDay());
        out.printf("薪金：%s\n", getSalary());
    }

}