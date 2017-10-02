package com.corejava.ch05.reflection;

import java.util.ArrayList;

import static java.lang.System.out;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch05.reflection
 * @Description : TODO
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-10-02  13:55
 * @ModificationHistory: Who  When What
 *====================================================================
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList <Integer> squares = new ArrayList <>();
        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
        }
        out.println(new ObjectAnalyzer("squares").toString(squares));
    }
}
