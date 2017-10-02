package com.corejava.ch05.abstractclass;

/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.abstractclass
 * @Description : Employee的继承类，代表高级职员。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-21  22:02
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: Manager
 * PACKAGE: com.corejava.ch05.abstractclass
 * Created by Chao Ding at 2017/9/21: 22:02
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import java.text.NumberFormat;
import java.util.Objects;

/**
 * Employee的继承类，代表高级职员。
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see
 */
public class Manager extends Employee {
    private double bonus;

    /*Constructors*/

    /**
     * Manager类的构造器
     *
     * @param name   [String]    经理姓名
     * @param year   [int]       雇佣年份
     * @param month  [int]       雇佣月份
     * @param day    [int]       雇佣日期
     * @param salary [double]    薪水
     * @param bonus  [double]    奖金
     */
    public Manager(String name, int year, int month, int day, double salary, double bonus) {
        super(name, year, month, day, salary);
        this.bonus = bonus;
    }

    /*Methods*/

    /**
     * 设置经理的奖金
     *
     * @param bonus [double]    经理的奖金
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    /**
     * 返回经理人的薪水
     * @return [double]   经理的薪水
     */
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }


    /**
     * 对象的相等测试
     * @param other     [Object]    比较对象
     * @return [boolean]   是否相等
     */
    @Override
    public boolean equals(Object other) {
        if (!super.equals(other))
            return false;
        Manager otherManager = (Manager) other;
        return this.bonus == otherManager.bonus;
    }


    /**
     * 生成类的描述字符串
     * @return [String]  本类的描述字符串
     */
    @Override
    public String toString() {
        return super.toString() +
                "[bonus=" + NumberFormat.getCurrencyInstance().format(this.bonus) + "]"
                +"\n";
    }


    /**
     * 返回Manager对象的哈希值
     * @return  [int]   Manager对象的哈希值
     */
    @Override
    public int hashCode() {
        return super.hashCode() + 17 * Objects.hashCode(this.bonus);
    }
}