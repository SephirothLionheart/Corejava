package com.corejava.ch04;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import static java.util.Calendar.*;

import static java.lang.System.out;

/*
 * ====================================================================
 *
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch04
 * @Description : 利用GregorianCalendar等类设计一个国际化的日历
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com
 * @Creation Date: 2017-09-17  18:52
 * @ModificationHistory: Who  When What
 * ====================================================================
 */
public class SimpleCalendar {
    public static void main(String[] args) {
        Date today = new Date();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(today);
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        int currentMonth = cal.get(Calendar.MONTH);
        Locale.setDefault(Locale.GERMAN);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        int indent = 0;
        int firstDayOfWeek = cal.getFirstDayOfWeek(); /*获得每个星期的首日*/
        while (cal.get(Calendar.DAY_OF_WEEK) != firstDayOfWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            indent++;
        }

        String[] weekdayNames = new DateFormatSymbols(Locale.GERMAN).getShortWeekdays();
        do {
            out.printf("%4s", weekdayNames[cal.get(Calendar.DAY_OF_WEEK)]);
            cal.add(Calendar.DAY_OF_MONTH, 1);
        } while (cal.get(Calendar.DAY_OF_WEEK) != firstDayOfWeek);
        out.println();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        while (indent > 0) {
            indent --;
            out.printf("%4s", " ");
        }

        while (cal.get(Calendar.MONTH) == currentMonth) {
            if (cal.get(Calendar.DAY_OF_WEEK) == firstDayOfWeek)
                out.println();
            int day = cal.get(DAY_OF_MONTH);
            if (day == currentDay)
                out.printf("%3s*", day);
            else
                out.printf("%4s", day);
            cal.add(DAY_OF_MONTH, 1);
        }
    }
}
