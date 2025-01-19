<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	BookDAO dao=new BookDAO();
	ArrayList<BookVO> list=dao.findAll();
	Gson gson=new Gson();
	String str=gson.toJson(list);
	out.print(str);
%>