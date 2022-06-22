/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dept;

/**
 *
 * @author Sap-lap
 */
public class DeptDBContext extends DBContext {
    public ArrayList<Dept> getDepts()
    {
        ArrayList<Dept> depts = new ArrayList<>();
        try {
            String sql = "SELECT did,dname FROM Department";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                depts.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeptDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return depts;
    }
}
