/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dept;
import model.Emp;

/**
 *
 * @author Ngo Tung Son
 */
public class EmpDBContext extends DBContext<Emp> {

    public ArrayList<Emp> search(int did) {
        ArrayList<Emp> emps = new ArrayList<>();
        try {
            String sql = "SELECT eid,ename,gender,dob,d.did,d.dname FROM Emp e INNER JOIN Dept d\n"
                    + "ON e.did = d.did WHERE d.did = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, did);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setEid(rs.getInt("eid"));
                e.setEname(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));
                e.setDob(rs.getDate("dob"));
                Dept d = new Dept();
                d.setDid(rs.getInt("did"));
                d.setDname(rs.getString("dname"));
                e.setDept(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }

    public ArrayList<Emp> filter(Integer id, String name, Boolean gender, Date from, Date to, Integer did) {
        
        HashMap<Integer, Object> params = new HashMap<>();
        ArrayList<Emp> emps = new ArrayList<>();
        try {
            String sql = "SELECT eid,ename,gender,dob,d.did,d.dname\n"
                    + "FROM Emp e INNER JOIN Dept d ON e.did = d.did\n"
                    + "WHERE (1=1)";
            Integer index =0;
            if(id != null)
            {
                sql += " AND e.eid = ?";
                index++;
                params.put(index, id);
            }
            if(name != null)
            {
                sql += " AND e.ename like '%'+?+'%'";
                index++;
                params.put(index, name);
            }
            if(gender != null)
            {
                sql += " AND e.gender = ?";
                index++;
                params.put(index, gender);
            }
            if(from != null)
            {
                sql += " AND e.dob >= ?";
                index++;
                params.put(index, from);
            }
            if(to != null)
            {
                sql += " AND e.dob <= ?";
                index++;
                params.put(index, to);
            }
            if(did != null)
            {
                sql += " AND e.did = ?";
                index++;
                params.put(index, did);
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object> entry : params.entrySet()) {
                Integer position = entry.getKey();
                Object value = entry.getValue();
                stm.setObject(position, value);
            }
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setEid(rs.getInt("eid"));
                e.setEname(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));
                e.setDob(rs.getDate("dob"));
                Dept d = new Dept();
                d.setDid(rs.getInt("did"));
                d.setDname(rs.getString("dname"));
                e.setDept(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }

    @Override
    public ArrayList<Emp> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Emp get(int id) {
        try {
            String sql = "SELECT eid,ename,gender,dob,d.did,d.dname FROM Emp e INNER JOIN Dept d\n"
                    + "ON e.did = d.did WHERE e.eid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setEid(rs.getInt("eid"));
                e.setEname(rs.getString("ename"));
                e.setGender(rs.getBoolean("gender"));
                e.setDob(rs.getDate("dob"));
                Dept d = new Dept();
                d.setDid(rs.getInt("did"));
                d.setDname(rs.getString("dname"));
                e.setDept(d);
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Emp model) {
        try {
            String sql = "INSERT INTO [Emp]\n"
                    + "           ([eid]\n"
                    + "           ,[ename]\n"
                    + "           ,[gender]\n"
                    + "           ,[dob]\n"
                    + "           ,[did])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getEid());
            stm.setString(2, model.getEname());
            stm.setBoolean(3, model.isGender());
            stm.setDate(4, model.getDob());
            stm.setInt(5, model.getDept().getDid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Emp model) {
        try {
            String sql = "UPDATE [Emp]\n"
                    + "   SET \n"
                    + "      [ename] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[did] = ?\n"
                    + " WHERE [eid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(5, model.getEid());
            stm.setString(1, model.getEname());
            stm.setBoolean(3, model.isGender());
            stm.setDate(2, model.getDob());
            stm.setInt(4, model.getDept().getDid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Emp model) {
        try {
            String sql = "DELETE Emp"
                    + " WHERE [eid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getEid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
