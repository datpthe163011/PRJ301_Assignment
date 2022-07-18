/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Course;
import model.Group;
import model.Mark;
import model.Student;

/**
 *
 * @author pc
 */
public class DAO extends DBContext {

    public ArrayList<Course> findAllCourse() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "select * from Course";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCID(rs.getString("CID"));
                c.setCname(rs.getString("Cname"));
                courses.add(c);
            }
        } catch (SQLException e) {
            System.out.println("loi function find all Course");
        }
        return courses;
    }

    public ArrayList<Group> findAllGroup() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select * from [Group]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGID(rs.getString("GID"));
                g.setGname(rs.getString("Gname"));
                groups.add(g);
            }
        } catch (SQLException e) {
            System.out.println("loi function find all Course");
        }
        return groups;
    }

    public ArrayList<Student> findStudents(int cid, int gid) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select s.Name, s.SID,co.CID,co.Cname,g.GID,g.Gname,m.MKID,[PT1], [PT2], [WS1], [WS2], [PE], [ASM],[FE], ([PT1]+[PT2]+[WS1]+[WS2])*0.05 + ([PE]+[FE])*0.2 +[ASM]*0.4 AS ToTal\n"
                    + "FROM Student s JOIN [StudentMark] sm\n"
                    + "ON s.SID = sm.SID \n"
                    + "JOIN Mark m \n"
                    + "ON m.MKID = sm.MKID\n"
                    + "Join [Course] co\n"
                    + "ON co.CID = m.CID\n"
                    + "JOIN [Group] g \n"
                    + "ON sm.GID = g.GID";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCID(rs.getString("CID"));
                c.setCname(rs.getString("Cname"));
                Group g = new Group();
                g.setGID(rs.getString("GID"));
                g.setGname(rs.getString("Gname"));
                g.setCourse(c);
                Mark m = new Mark();
                m.setCourse(c);
                m.setFE(rs.getFloat("FE"));
                m.setASM(rs.getFloat("ASM"));
                m.setPE(rs.getFloat("PE"));
                m.setPT1(rs.getFloat("PT1"));
                m.setPT2(rs.getFloat("PT2"));
                m.setWS1(rs.getFloat("WS1"));
                m.setWS2(rs.getFloat("WS2"));
                m.setMKID(rs.getString("MKID"));
                m.setTotal(rs.getFloat("Total"));
                Student s = new Student();
                s.setSID(rs.getString("SID"));
                s.setName(rs.getString("Name"));
                s.setGroup(g);
                s.setMark(m);
                students.add(s);
            }
        } catch (SQLException e) {
            System.out.println("loi function tim students");
        }
        return students;
    }
    
}
