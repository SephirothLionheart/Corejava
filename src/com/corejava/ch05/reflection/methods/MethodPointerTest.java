package com.corejava.ch05.reflection.methods;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch05.reflection.methods
 * @Description : 数学制表的通用程序，其中x代表行，y代表列，对应单元格上应该
 *                是 y = f(x), 其中f由Method对象指定。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-10-07  15:30
 * @ModificationHistory: Who  When What
 *====================================================================
 */
/*------------------------------------------------------------
 * Class: MethodPointerTest
 * PACKAGE: com.corejava.ch05.reflection.methods
 * Created by Chao Ding at 2017/10/7: 15:33
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * 数学制表的通用程序
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see
 */
public class MethodPointerTest {
    public static void main(String[] args) throws NoSuchMethodException {
        // 类A的Class对象为A.class
        //获得Method对象
        Method squareMthd = MethodPointerTest.class.getMethod("square", double.class);
        printTable(1.0000, 10.0000, 9, squareMthd);

        Method sqrtMthd = MethodPointerTest.class.getMethod("sqrt", double.class);
        printTable(1.0000, 10.0000, 9, sqrtMthd);

    }

    /**
     * @param x [double]    自变量x
     * @return [double]    x的平方
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * 返回开平方根
     *
     * @param x [double]    自变量x
     * @return [double]    x的平方根
     */
    public static double sqrt(double x) {
        return Math.sqrt(x);
    }

    /**
     * 以方法名称作为表头（TableHead）
     *
     * 第一列为自变量x，第二列为因变量 y = f(x), 其中f由Method对象指定。
     * 绘制表格形如
     *   METHOD
     *   ------------------------------
     *   x1        \      y1=f(x1)
     *   x2        \      y2=f(x2)
     *   ...       \       ...
     *
     *
     * @param xFrom     [double]   x的最小值
     * @param xTo       [double]   x的最大值
     * @param steps     [int]      x从最小值到最大值需要的几个step
     * @param f         [Method]   执行的方法（映射）
     */
    public static void printTable(double xFrom, double xTo, int steps, Method f) {
        double step = (xTo - xFrom) / steps;
        out.println(f.getName());
        out.println("--------------------------------------------------");
        try {
            for (double x = xFrom;  x < xTo ; x += step) {
                out.printf("%4.2f\t|\t%4.2f\n", x, f.invoke(null, x));
            }
            out.printf("%4.2f\t|\t%4.2f\n", xTo, f.invoke(null, xTo));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        out.println("==================================================");

    }

}
