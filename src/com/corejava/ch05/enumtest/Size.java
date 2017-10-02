package com.corejava.ch05.enumtest;/*
 *====================================================================
 * @Project : java
 * @PACKAGE NAME : com.corejava.ch05.enumtest
 * @Description : TODO
 * @Author : Sephiroth
 * @Email : dingchao_129@163.com 
 * @Creation Date: 2017-09-25  12:37
 * @ModificationHistory: Who  When What
 *====================================================================
 */

public enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;
    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
}
