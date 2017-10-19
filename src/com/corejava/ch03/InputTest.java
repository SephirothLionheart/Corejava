package com.corejava.ch03;

/*
 *====================================================================
 * @Project : Corejava
 * @PACKAGE NAME : com.corejava.ch03
 * @Description : 测试输入输出，并将输出记录至文件
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-10-18  22:10
 * @ModificationHistory: Who  When What
 *====================================================================
 */

/*------------------------------------------------------------
 * Class: InputTest
 * PACKAGE: com.corejava.ch03
 * Created by Chao Ding at 2017/10/18: 22:11
 * Modification History:
 *    1. [When]  [Who]  [How]
 *    2. ....
 ------------------------------------------------------------*/
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.out;

/** 
 * 测试输入输出，并将输出记录至文件
 * @author     Sephiroth
 * @version    0.0.1
 * @since      J2SE-1.6.0u110
 * @see
 */
public class InputTest {
    public static void main(String[] args)  throws IOException {
        Scanner inScan = new Scanner(System.in);
        out.println("What is your name?");
        String name = inScan.nextLine();
        out.println("How old are you?");
        int age = inScan.nextInt();

        String output ="My name is " + name + ", " + "a " + age + " years old boy.";
        out.println(output);
        String url = System.getProperty("user.dir");
        url = url.replace("\\", "\\\\");
        out.println(url);
        PrintWriter fileWriter = new PrintWriter(url + "\\\\test.txt");
        fileWriter.format(output);
        fileWriter.flush();

        out.println("文件" + url + "\\\\test.txt" + "中的内容为：");
        Scanner fileScanner = new Scanner(Paths.get(url + "\\\\test.txt"));
        out.println(fileScanner.nextLine());
    }
}
