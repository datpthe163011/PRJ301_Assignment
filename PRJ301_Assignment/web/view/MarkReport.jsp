<%-- 
    Document   : MarkReport
    Created on : Jul 19, 2022, 1:02:08 AM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


    </head>
    <body>

        <form action="MarkReport" method="Get">
            <label class="form-label">Course Name</label>
            <select name="cid" >

                <option value="-1">----SELECT An Exam----</option>
                <c:forEach items="${requestScope.courses}" var="c">
                    <option
                        ${(c.CID==requestScope.cid)?"selected=\"selected\"":""}
                        value="${c.CID}">${c.getCname()}</option>
                </c:forEach>
            </select>
            <select name="gid">

                <option value="-1">----SELECT A Group----</option>
                <c:forEach items="${requestScope.groups}" var="g">
                    <option
                        ${(g.GID==requestScope.gid)?"selected=\"selected\"":""}
                        value="${g.GID}">${g.getGname()}</option>
                </c:forEach>
            </select>
            <button> submit </button>
        </form>
        <div>
            <table border="3">
            <thead>
                <tr>
                    <th>   Name </th>
                    <th>Progress test 1(5%)</th>
                    <th>Progress test 2 (5%)</th>
                    <th>Workshop 1 (5%)</th>
                    <th>Workshop 2 (5%)</th>
                    <th>Practical Exam (20%)</th>
                    <th>Assignment (40%)</th>
                    <th>Final Exam (20%)</th>
                    <th>TOTAL</th>
                    <th>STATUS</th>
                     <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.students}" var="s">
                <tr>
                    <td>${s.getName()}</td>
                    <td>${s.getMark().getPT1()}</td>
                    <td>${s.getMark().getPT2()}</td>
                    <td>${s.getMark().getWS1()}</td>
                    <td>${s.getMark().getWS2()}</td>
                    <td>${s.getMark().getPE()}</td>
                    <td>${s.getMark().getASM()}</td>
                    <td>${s.getMark().getFE()}</td>
                    <td>${s.getMark().getTotal()}</td>
                    <td>STUDYING</td>
                    <td><a href="/Edit">Edit</a></td>
                </tr>
                </c:forEach>
            </tbody>
            </table>
            
        </div>
    </body>
</html>
