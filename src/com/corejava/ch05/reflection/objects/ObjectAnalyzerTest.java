package com.corejava.ch05.reflection.objects;

import com.corejava.ch05.abstractclass.Employee;

import java.util.ArrayList;
import java.util.Calendar;

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
        ArrayList <Integer> squares = new ArrayList <>(5);
        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
        }
        out.println("对象squares的内部状态为：");
        out.println(new ObjectAnalyzer().toString(squares));
        out.println();

        Employee em = new Employee("Karl Marx", 2015, Calendar.JANUARY, 11, 20_000);
        out.println("对象em的内部状态为：");
        out.println(new ObjectAnalyzer().toString(em));
    }
}
