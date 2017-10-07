package com.corejava.ch05.reflection.objects;

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
        import java.lang.reflect.Modifier;
        import java.util.ArrayList;

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
    ArrayList <Object> visited = new ArrayList <>();

    /**
     * 递归打印Obj对象或对象数组中的元素数值
     *
     * @param obj [Object] 给定的对象或对象数组
     * @return [String]    对象/数组的对象打印
     */
    public String toString(Object obj) {
        String outStr = "";
        if (obj == null) {
            return "null";
        }
        Class cl = obj.getClass();
        if (cl == String.class) {
            return (String) obj;
        }
        if (this.visited.contains(obj)) {   // 防止循环使用
            return "...";
        }
        visited.add(obj);

        if (cl.isArray()) {
            Class componentType = cl.getComponentType();
            outStr += componentType.getName() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    outStr += ", ";
                }
                Object val = Array.get(obj, i);
                if (componentType.isPrimitive()) {
                    outStr += val;
                } else {
                    outStr += toString(val);
                }
            }
            return outStr + "}";
        }


        outStr += cl.getName() + "[";
        int indents = 0;
        do {
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            indents ++;
            for (Field fd : fields) {
                Class fieldType = fd.getType();
                if (!Modifier.isStatic(fd.getModifiers())) {
                    if (!outStr.endsWith("[")) {
                        outStr += ", ";
                    }
                    outStr += fd.getName() + "=";
                    try {
                        Object val = fd.get(obj);
                        if (fieldType.isPrimitive()) {
                            outStr += val;
                        } else {
                            outStr += toString(val);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            cl = cl.getSuperclass();
        } while (cl != null);
        return  outStr + "]";
    }
}
