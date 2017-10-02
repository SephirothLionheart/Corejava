package com.corejava.ch05.reflection;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch05.reflection
 * @Description : 重写一个toString函数，给定参数为一个对象或数组:
 *                  1. 给定对象，输出对象中所有域的数值
 *                  2. 给定对象数组，则输出数组中每个元素，如果元素是对象
 *                     打印对象中所有域的数值，如果是数组则进一步迭代展开。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com
 * @Creation Date: 2017-10-02  2:14
 * @ModificationHistory: Who  When What
 *
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: ObjectAnalyzer
 * PACKAGE: com.corejava.ch05.reflection
 * Created by Chao Ding at 2017/10/2: 2:17
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

        import java.lang.reflect.AccessibleObject;
        import java.lang.reflect.Array;
        import java.lang.reflect.Field;
        import java.util.ArrayList;

        import static java.lang.System.out;

/**
 * 重写一个toString函数，给定参数为一个对象或数组:
 *                  1. 给定对象，输出对象中所有域的数值
 *                  2. 给定对象数组，则输出数组中每个元素，如果元素是对象
 *                     打印对象中所有域的数值，如果是数组则进一步迭代展开。
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see         java.lang.reflect.Array
 * @see         java.lang.reflect.Field
 * @see         java.lang.Class
 */
public class ObjectAnalyzer {
    ArrayList <Object> visited = new ArrayList <>(); /*存放访问过的对象*/
    String objectName;

    public ObjectAnalyzer(String objectName) {
        this.objectName = objectName;
    }

    /**
     * 递归打印Obj对象或对象数组中的元素数值
     *
     * @param obj [Object] 给定的对象或对象数组
     * @return [String]    对象/数组的对象打印
     */
    public String toString(Object obj) {
        String outputStr = "";
        if (obj == null) {
            return "null";
        }
        Class cl = obj.getClass();
        if (cl == String.class) {
            return (String) obj;
        }

        if (this.visited.contains(obj)) {
            return "...";   // 跳出条件，也是递归函数的基本情况。
        }

        outputStr = obj.getClass().getName() + " "
                + this.objectName + " = [";

        if (cl.isArray()) {
            Class componentType = cl.getComponentType();
            outputStr += componentType.getName() +"[]" + " = [";

            for (int i = 0; i < Array.getLength(obj); i++) {
                if (!outputStr.endsWith("[")) {
                    outputStr += ", ";
                }

                Object val = Array.get(obj, i);
                if (componentType.isPrimitive()) {
                    outputStr += val;
                } else {
                    toString(outputStr);
                }
            }
        }

        do {  // 当 obj是一个对象而不是一个数组的时候，可以认为是递归的基本情况
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field fd : fields) {
                Class fieldType = fd.getType();
                if (!outputStr.endsWith("["))
                    outputStr += ",";
                outputStr += "\n\t" + fieldType.getName()
                        + " " + fd.getName() + " = ";
                try {
                    Object val = fd.get(obj);
                    if (fieldType.isPrimitive()) {
                        outputStr += val;
                    } else {
                        toString(val);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            cl = cl.getSuperclass();
        } while (cl != null);   // 仅当obj为Object类对象，接口，数组时， cl为null。

        return outputStr;
    }
}
