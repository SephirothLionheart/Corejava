package com.corejava.ch05.wrappertest;

import org.omg.CORBA.IntHolder;
import static java.lang.System.out;

/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.wrappertest
 * @Description : 测试对象包装器和自动拆装箱。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-24  23:29
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: WrapperTest
 * PACKAGE: com.corejava.ch05.wrappertest
 * Created by Chao Ding at 2017/9/24: 23:31
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/
/**
 * 测试对象包装器和自动拆装箱。
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see
 */
public class WrapperTest {
    public static void main(String[] args) {
        Integer n = 3;
        n++;
        out.println("n = " + n);
        Integer a = 4;
        Integer b = 5;
        IntHolder bh = new IntHolder(5);
        out.println("a + b = " + (a + b));
        Integer c = 4;
        out.println("c == a: " + (c == a));
        out.printf("c.equals(a): %s\n", c.equals(a));
        out.println("【结论1】 四则运算可以直接应用于包装器，编译器会自动添加装箱拆箱语句。");
        out.println("【结论2】 ==运算符不应该应用于两个包装器，因为其比较的是两个变量是否\n" +
                "指向同一个包装器对象。表意上与两个基本类型的相等比较是不同的");
        out.println("【结论3】 比较两个包装器对象的相等性，还是使用equals函数会比较好。");
        out.println("a = "+ a);
        tripleValue(a);
        out.printf("tripleValue(a) = %d\n", a);
        out.println("【结论4】Integer是final类，其值在创建对象之后不可变，因此tripleValue\n" +
                "函数失效。");
        out.printf("bh = %d.\n", bh.value);
        trueTripleValue(bh);
        out.printf("trueTripleValue(bh) = %d.\n", bh.value);
    }

    public static void tripleValue(Integer x) {
        x *= 3;
    }

    public static void trueTripleValue(IntHolder x) {
        x.value *= 3;
    }
}
