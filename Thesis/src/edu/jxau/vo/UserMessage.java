package edu.jxau.vo;

import java.util.Date;

public class UserMessage{

	// 发送方
	private String from;
	
	// 发送方姓名
	private String f_name;
	// 接收方
	private String to;
	
	private String to_name;
	// 内容
	private String content;
	// 发送时间
	private Date sendTime;
	
	private String welcome;
	
	public static int comeCount;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		if(to.indexOf(",") != -1) {
			String[] splitTo = to.split(",");
			this.to = splitTo[0];
			this.to_name = splitTo[1];
		}else {
			this.to = to;
			this.to_name = to;
		}
		
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	
	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getTo_name() {
		return to_name;
	}

	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}

	@Override
	public String toString() {
		return "UserMessage [from=" + from + ", to=" + to + ", content="
				+ content + ", sendTime=" + sendTime + ", welcome=" + welcome
				+ "]";
	}
	

}
