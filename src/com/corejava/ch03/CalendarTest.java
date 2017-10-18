package com.corejava.ch03;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch03
 * @Description : 利用GregorianCalendar， Date类生成一个国际化的日历
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-10-18  21:36
 * @ModificationHistory: Who  When What
 *====================================================================
 */
/*------------------------------------------------------------
 * Class: CalendarTest
 * PACKAGE: com.corejava.ch03
 * Created by Chao Ding at 2017/10/18: 21:37
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.lang.System.out;
import static java.util.Calendar.MONTH;

/**
 * 利用GregorianCalendar， Date类生成一个国际化的日历
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see       java.util.Calendar
 * @see       java.util.GregorianCalendar
 * @see       java.util.Date
 * @see       java.text.DateFormatSymbols
 */
public class CalendarTest {
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        int currentMonth = cal.get(Calendar.MONTH);

        cal.set(Calendar.DAY_OF_MONTH, 1); // 跳转至本月首日
        int indent = 0;
        int firstDayOfWeek = cal.getFirstDayOfWeek();
        while (cal.get(Calendar.DAY_OF_WEEK) != firstDayOfWeek) {
            indent ++;
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        String[] weekDayNames = new DateFormatSymbols(Locale.GERMAN).getShortWeekdays();
        int weekday = cal.get(Calendar.DAY_OF_WEEK);
        do {
            out.printf("%s ", weekDayNames[weekday]);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            weekday = cal.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);

        while (indent > 0) {
            indent--;
            out.print("    ");
        }
        cal.set(Calendar.DAY_OF_MONTH, 1);
        while (cal.get(Calendar.MONTH) == currentMonth) {
            weekday = cal.get(Calendar.DAY_OF_WEEK);
            if (weekday == firstDayOfWeek) {
                out.println();
            }
            int day = cal.get(Calendar.DAY_OF_MONTH);
            if (day == currentDay) {
                out.printf("%3d*", day);
            } else {
                out.printf("%4d", day);
            }
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
