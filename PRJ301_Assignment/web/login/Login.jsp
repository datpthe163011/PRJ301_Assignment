<%-- 
    Document   : login
    Created on : May 31, 2022, 10:36:03 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="username" /> <br/>
            Password: <input type="password" name="password"/> <br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
