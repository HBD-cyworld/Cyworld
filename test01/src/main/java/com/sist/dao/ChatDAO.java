package com.sist.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;
import com.sist.vo.ChatVO;

public class ChatDAO {
	
	public ArrayList<ChatVO> findAll(){
		ArrayList<ChatVO> list=new ArrayList<ChatVO>();
		String sql="select * from chat order by no desc";
		try {
			Connection conn=ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int no=rs.getInt(1);
				String name=rs.getString(2);
				String message=rs.getString(3);
				
				ChatVO c=new ChatVO(no, name, message);
				list.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
   public int insert(ChatVO c) {
      int re = -1;
      String sql = "insert into chat values(seq_chatno.nextval,?,?)";
      try {
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, c.getName());
         pstmt.setString(2, c.getMessage());
         re = pstmt.executeUpdate();
         ConnectionProvider.close(conn, pstmt, null);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return re;
   }
}