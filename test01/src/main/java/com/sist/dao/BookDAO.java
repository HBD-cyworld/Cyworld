package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;
import com.sist.vo.DeptVO;

public class BookDAO {
   
      //책을 삭제하는 메소드입니다
      public int deleteBook(int bookid) {
         int re = -1;
         String sql = "delete book where bookid=?";
         try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookid);
            re = pstmt.executeUpdate();
            ConnectionProvider.close(conn, pstmt, null);
         }catch (Exception e) {
            System.out.println("예외발생:"+e.getMessage());
         }
         return re;
      }
      
      //책정보 수정하는 메소드입니다
      public int updateBook(BookVO d) {
         int re = -1;
         String sql = "update book set bookid=?,bookname=?,publisher=?,price=? where bookid=?";
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = 
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
            PreparedStatement pstmt 
            = conn.prepareStatement(sql);         
            pstmt.setInt(1, d.getBookid());
            pstmt.setString(2, d.getBookname());
            pstmt.setString(3, d.getPublisher());
            pstmt.setInt(4, d.getPrice());
            re = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
         }catch (Exception e) {
            System.out.println("예외발생:"+e.getMessage());
         }
         return re;
      }
   
      //책을 등록하는 메소드입니다
      public int insertBook(BookVO d) {
         int re = -1;
         String sql = "insert into book values(?,?,?,?)";
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = 
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
            PreparedStatement pstmt 
            = conn.prepareStatement(sql);
            pstmt.setInt(1, d.getBookid());
            pstmt.setString(2, d.getBookname());
            pstmt.setString(3, d.getPublisher());
            pstmt.setInt(4, d.getPrice());
            re = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
         }catch (Exception e) {
            System.out.println("예외발생:"+e.getMessage());
         }
         return re;
      }
   
   public ArrayList<BookVO> findAll(){
      ArrayList<BookVO> list = new ArrayList<BookVO>();
      String sql = "select * from book order by bookid";
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
            list.add(new BookVO(rs.getInt(1),
                  rs.getString(2), 
                  rs.getString(3),
                  rs.getInt(4)));
         }
         rs.close();
         stmt.close();
         conn.close();
      }catch (Exception e) {
         System.out.println("예외발생:"+e.getMessage());
      }
      return list;
   }
}