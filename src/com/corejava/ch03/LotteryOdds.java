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
 * @Creation Date: 2017-10-28  19:38
 * @ModificationHistory: Who  When What
 *====================================================================
 */
public class LotteryOdds {
    public static void main(String[] args) {
        out.println("每注号码个数：");
        Scanner inScan = new Scanner(System.in);
        int k = inScan.nextInt();
        out.println("奖池中的号码个数：");
        int n = inScan.nextInt();

        long lotteryOdds = 1;  // C（n,k）
        for (int i = 1; i <= k; i++) {
            lotteryOdds = (lotteryOdds * (n - i + 1)) / (i);
        }
        out.printf("中奖概率为 1 / %d .\n", lotteryOdds);
    }
}
