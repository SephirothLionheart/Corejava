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
 * @Creation Date: 2017-10-29  3:11
 * @ModificationHistory: Who  When What
 *====================================================================
 */
public class Retirement {
    public static void main(String[] args) {
        out.println("你需要多少钱来作为退休金？");
        Scanner inScan = new Scanner(System.in);
        double retirementGoal = inScan.nextDouble();
        out.println("你每年能存下多少钱？");
        double saving = inScan.nextDouble();
        out.println("请输入预设的年收益率(%)");
        double rates = inScan.nextDouble();

        int years = 0;
        double money = 0.0;
        while (money <= retirementGoal) {
             money *= 1.0 + rates / 100.0;
             money += saving;
             years ++;
        }
        out.println("你需要" + years + "年退休。");
    }
}
