/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DeptDBContext;
import dal.EmpDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Dept;
import model.Emp;

/**
 *
 * @author Ngo Tung Son
 */
public class InsertController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DeptDBContext db = new DeptDBContext();
        ArrayList<Dept> depts = db.list();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/emp/create.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String raw_reason = request.getParameter("reason");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_creater = request.getParameter("Created by");
        String raw_ = request.getParameter("Reviewed by");
        //validate inputs
        int id = Integer.parseInt(raw_id);
        String name = raw_name;
        int did = Integer.parseInt(raw_did);
        Emp e = new Emp();
        e.setEid(id);

        EmpDBContext db = new EmpDBContext();
        db.insert(e);
        
        //option 1>
        //response.getWriter().println("inserted successful!");
        
        //option 2>
        //response.sendRedirect("search");
        
        //option 3>
        request.setAttribute("emp", e);
        request.setAttribute("action", "added");
        request.getRequestDispatcher("../view/emp/dml_confirmation.jsp").forward(request, response);
    }

    


}
