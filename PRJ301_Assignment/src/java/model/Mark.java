/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class Mark {

    private String MKID;
    private float PT1;
    private float PT2;
    private float WS1;
    private float WS2;
    private float PE;
    private float ASM;
    private float FE;
    private float total;
    private Course course;

    public Mark() {
    }

    public Mark(String MKID, float PT1, float PT2, float WS1, float WS2, float PE, float ASM, float FE, float total, Course course) {
        this.MKID = MKID;
        this.PT1 = PT1;
        this.PT2 = PT2;
        this.WS1 = WS1;
        this.WS2 = WS2;
        this.PE = PE;
        this.ASM = ASM;
        this.FE = FE;
        this.total = total;
        this.course = course;
    }

    public String getMKID() {
        return MKID;
    }

    public void setMKID(String MKID) {
        this.MKID = MKID;
    }

    public float getPT1() {
        return PT1;
    }

    public void setPT1(float PT1) {
        this.PT1 = PT1;
    }

    public float getPT2() {
        return PT2;
    }

    public void setPT2(float PT2) {
        this.PT2 = PT2;
    }

    public float getWS1() {
        return WS1;
    }

    public void setWS1(float WS1) {
        this.WS1 = WS1;
    }

    public float getWS2() {
        return WS2;
    }

    public void setWS2(float WS2) {
        this.WS2 = WS2;
    }

    public float getPE() {
        return PE;
    }

    public void setPE(float PE) {
        this.PE = PE;
    }

    public float getASM() {
        return ASM;
    }

    public void setASM(float ASM) {
        this.ASM = ASM;
    }

    public float getFE() {
        return FE;
    }

    public void setFE(float FE) {
        this.FE = FE;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
    

}
