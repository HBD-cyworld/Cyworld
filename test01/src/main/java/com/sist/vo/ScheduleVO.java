
package com.sist.vo;

public class ScheduleVO {
	private int no;
	private String event_date;
	private String event_content;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	public ScheduleVO(int no, String event_date, String event_content) {
		super();
		this.no = no;
		this.event_date = event_date;
		this.event_content = event_content;
	}
	public ScheduleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
