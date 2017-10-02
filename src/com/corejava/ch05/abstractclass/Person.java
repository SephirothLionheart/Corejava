package com.corejava.ch05.abstractclass;
/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.com.corejava.ch05.abstractclass
 * @Description : 实践抽象类的使用方法
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-21  19:50
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: Person
 * PACKAGE: com.corejava.ch05.com.corejava.ch05.abstractclass
 * Created by Chao Ding at 2017/9/21: 19:51
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/
/**
 * 用于描述人类的抽象类
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see         Employee
 * @see         Student
 */
public abstract class Person {
    protected String name;

    /*Constructors*/
    public Person(String name) { // 不会出现在new Person中，只会出现在子类的构造器中
        this.name = name;
    }

    /**
     * 返回抽象类Person的姓名
     * @return [String] 姓名
     */
    public String getName() { // 抽象类可以有非抽象函数
        return this.name;
    }

    /**
     * 返回关于Person类的描述，为抽象函数。
     * @return [String] 个人描述
     */
    public abstract String getDescription();  // 抽象方法没有实现块。


}
