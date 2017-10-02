package com.corejava.ch05.reflection;
import java.lang.reflect.*;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch05.reflection
 * @Description : 示范反射的用法，当用户输入一个类的名称，程序打印出该类
 *                的所有细节，包括域，方法，构造器等。
 *
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-28  23:39
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: ReflectionTest
 * PACKAGE: com.corejava.ch05.reflection
 * Created by Chao Ding at 2017/9/29: 0:20
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

/**
 * 示范反射的用法，当用户输入一个类的名称，程序打印出该类的所有细节，
 * 包括域，方法，构造器等。
 *
 * @author Sephiroth
 * @version 0.0.1
 * @see
 * @since J2SE-1.6.0u110
 */
public class ReflectionTest {
    public static void main(String[] args) {
        try {
            out.println("请输入想要打印的类的名称");
            Scanner inScan = new Scanner(in);
            String inputClass = inScan.next();
            Class cl = Class.forName(inputClass);
            int classModifiers = cl.getModifiers();
            out.print(Modifier.toString(classModifiers)
                    + " class " + cl.getName()
            );
            Class superClass = cl.getSuperclass();
            if (superClass != null) { // 如果为Object， 基本类型，void返回null
                out.println(" extends " + superClass.getName());
            }
            out.println("{");
            // 类中的域声明
            out.println("  /*Fields*/");
            Field[] fields = cl.getDeclaredFields();
            for (Field fd : fields) {
                int fieldModifiers = fd.getModifiers();
                out.print("  " + Modifier.toString(fieldModifiers));
                out.println(" " + fd.getName() + ";");
            }

            // 类中的方法声明
            out.println();
            out.println("  /*Methods*/");
            Method[] methods = cl.getDeclaredMethods();
            for (Method md : methods) {
                int methodModifiers = md.getModifiers();
                out.print("  " + Modifier.toString(methodModifiers));
                out.print(" " + md.getReturnType().getName());
                out.print(" " + md.getName());
                Class[] exceptions = md.getExceptionTypes();
                if (exceptions.length != 0) {
                    out.print(" throws ");
                }
                for (int i = 0; i < exceptions.length; i++) {
                    out.print(exceptions[i].getName());
                    if (i < exceptions.length - 1) {
                        out.print(", ");
                    }
                }

                out.print("(");
                Class[] paraTypes = md.getParameterTypes();
                for (int i = 0; i < paraTypes.length; i++) {
                    out.print(paraTypes[i].getName());
                    if (i < paraTypes.length - 1)
                        out.print(", ");
                }
                out.println(");");
            }

            // 类中的构造器
            out.println();
            out.println("  /*Constructors*/");
            Constructor[] cons = cl.getDeclaredConstructors();

            for (Constructor con : cons) {
                int constructorModifiers = con.getModifiers();
                out.print("  " + Modifier.toString(constructorModifiers) + " "+ con.getName());
                Class[] exceptions = con.getExceptionTypes();
                if ( exceptions.length > 0) {
                    out.print(" throws ");
                    for (int i = 0; i < exceptions.length; i++) {
                        out.print(exceptions[i].getName());
                        if (i < exceptions.length - 1) {
                            out.print(", ");
                        } else {
                            out.print(" ");
                        }
                    }
                }
                Class[] conParas = con.getParameterTypes();
                out.print("(");
                for (int i = 0; i < conParas.length; i++) {
                    out.print(conParas[i].getName());
                    if (i < conParas.length - 1) {
                        out.print(", ");
                    }
                }
                out.println(");");
            }

            // 类的结尾处
            out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
