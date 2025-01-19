<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
%>

<h1><%=name %>:<%=age %></h1>
