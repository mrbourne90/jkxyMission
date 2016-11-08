<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	
	if(userName != "" && password != ""){
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);	
	}
	response.setHeader("refresh", "1;URL=welcome.jsp");
%>