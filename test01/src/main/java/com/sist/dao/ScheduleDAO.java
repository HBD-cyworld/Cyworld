
package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.ScheduleVO;


public class ScheduleDAO {
	
	public ArrayList<String> listDate(String date){
		String sql = "select distinct to_char(event_date, 'dd') "
				+ "from schedule "
				+ "where to_char(event_date, 'yyyy/mm') = ?";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	
	public int deleteSchedule(int no) {
		int re = -1;
		String sql = "delete schedule where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<ScheduleVO> findByEventDate(String event_date){
		ArrayList<ScheduleVO> list = new ArrayList<ScheduleVO>();
		try {
			String sql = "select * from schedule where event_date = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, event_date);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ScheduleVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	
	public int insert(ScheduleVO s) {
		int re = -1;
		String sql = "insert into schedule values(seq_schedule.nextval,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getEvent_date());
			pstmt.setString(2, s.getEvent_content());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}
