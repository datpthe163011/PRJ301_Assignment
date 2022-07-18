/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class Group {
    private String GID;
    private String Gname;
    private Course course;
    public Group() {
    }

    public Group(String GID, String Gname) {
        this.GID = GID;
        this.Gname = Gname;
    }

    public Group(String GID, String Gname, Course course) {
        this.GID = GID;
        this.Gname = Gname;
        this.course = course;
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getGname() {
        return Gname;
    }

    public void setGname(String Gname) {
        this.Gname = Gname;
    }
    
}
