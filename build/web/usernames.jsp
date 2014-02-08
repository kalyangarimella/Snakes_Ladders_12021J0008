<%-- 
    Document   : usernames
    Created on : Mar 14, 2013, 11:54:32 PM
    Author     : Kalyan Kasyap
--%>

<%@page import="com.SL.DAO.DBConnection"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <%
            String name="";
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            Statement s = con.createStatement();
            String username = request.getParameter("q");
            out.println("<script>alert('hai')</script>");
	    String sql = "select username from reg_details_tb where username LIKE '%" + username + "%'";
	    ResultSet rs = s.executeQuery(sql);
	    while(rs.next()){
                name = rs.getString(1);
                out.println(name);
            }		
        %>
