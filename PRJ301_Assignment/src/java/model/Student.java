/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author pc
 */
public class Student {

    private String SID;
    private String Name;
    private Date Dob;
    private boolean Gender;
    private String Adress;
    private Group group;
    private Mark mark;

    public Student() {
    }

    public Student(String SID, String Name, Date Dob, boolean Gender, String Adress, Group group, Mark mark) {
        this.SID = SID;
        this.Name = Name;
        this.Dob = Dob;
        this.Gender = Gender;
        this.Adress = Adress;
        this.group = group;
        this.mark = mark;
    }

    public Student(String SID, String Name, Date Dob, boolean Gender, String Adress) {
        this.SID = SID;
        this.Name = Name;
        this.Dob = Dob;
        this.Gender = Gender;
        this.Adress = Adress;
    }
    

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
    
    
}
