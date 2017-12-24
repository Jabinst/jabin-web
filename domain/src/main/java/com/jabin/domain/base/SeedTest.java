package com.jabin.domain.base;

import java.io.Serializable;

public class SeedTest implements Serializable {
    private String varcharTest;

    private Integer intTest;

    private String charTest;

    private static final long serialVersionUID = 1L;

    public String getVarcharTest() {
        return varcharTest;
    }

    public void setVarcharTest(String varcharTest) {
        this.varcharTest = varcharTest == null ? null : varcharTest.trim();
    }

    public Integer getIntTest() {
        return intTest;
    }

    public void setIntTest(Integer intTest) {
        this.intTest = intTest;
    }

    public String getCharTest() {
        return charTest;
    }

    public void setCharTest(String charTest) {
        this.charTest = charTest == null ? null : charTest.trim();
    }
}