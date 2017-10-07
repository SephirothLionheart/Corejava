package com.corejava.ch05.reflection.arrays;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch05.reflection.arrays
 * @Description : 利用反射包中的Array类实现任意类型，任意长度的数组复制。
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-10-07  10:11
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: CopyOf
 * PACKAGE: com.corejava.ch05.reflection.arrays
 * Created by Chao Ding at 2017/10/7: 10:12
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import java.lang.reflect.Array;

/**
 * 利用反射包中的Array类实现任意类型，任意长度的数组复制。
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see         java.lang.reflect.Array#newInstance(Class, int)
 * @see         java.util.Arrays#copyOf(Object[], int)
 */
public class CopyOf {
    public static Object copyOf(Object[] array, int len) {
        if (array == null) {
            return null;
        }
        Class cl = array.getClass();
        if (cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        Object newArray = Array.newInstance(componentType, Array.getLength(array));
        System.arraycopy(array, 0, newArray, 0, Array.getLength(array));
        return newArray;
    }
}
