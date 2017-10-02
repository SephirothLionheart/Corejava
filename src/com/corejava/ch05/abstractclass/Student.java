package com.corejava.ch05.abstractclass;

/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.abstractclass
 * @Description : 抽象类Person的派生类Student，用于描述学生的基本信息
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-21  20:18
 * @ModificationHistory: Who  When What
 *====================================================================
 */
/*------------------------------------------------------------
 * Class: Student
 * PACKAGE: com.corejava.ch05.abstractclass
 * Created by Chao Ding at 2017/9/21: 20:19
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

/**
 * 抽象类Person的派生类Student，用于描述学生的基本信息
 *
 * @author Sephiroth
 * @version 0.0.1
 * @see Employee
 * @see Person
 * @since J2SE-1.6.0u110
 */
public class Student extends Person {
    private String major;
    private String college;

    /*Constructors*/
    public Student(String name, String college, String major) {
        super(name);
        this.major = major;
        this.college = college;
    }

    /*Methods*/
    public String getDescription() {
        return String.format("He is a student in %s, majored in %s", this.college, this.major);
    }
}
