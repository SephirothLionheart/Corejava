package com.corejava.ch03;

import java.util.Scanner;

import static java.lang.System.out;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch03
 * @Description : TODO
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-10-29  3:20
 * @ModificationHistory: Who  When What
 *====================================================================
 */
public class Retirement2 {
    public static void main(String[] args) {
        out.println("年能存下多少钱？");
        Scanner inScan = new Scanner(System.in);
        double saving = inScan.nextDouble();
        out.println("每年的投资收益率(%):");
        double rate = inScan.nextDouble();

        int years = 0;
        double balance = 0.0;

        while (true) {
            years ++;
            balance *= 1.0 + rate / 100.0;
            balance += saving;

            out.printf("经过%d年，你的存款总额为%6.2f元，想要退休吗（Y/N）?\n", years, balance);
            String input = inScan.nextLine();
            if (input.equalsIgnoreCase("Y"))
                break;

        }
        out.printf("退休时获得退休金为：%6.2f", balance);;
    }
}
