package notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable{
	private static final long serialVersionUID= 1000l;
		
	private int noticeNO;
	private String noticeTitle;
	private Date noticeDate;
	private String noticeContent;
	private String noticeWriter;
	private String originalFilePath;
	private String renameFilePath;
public Notice() {
	// TODO Auto-generated constructor stub
}
public Notice(int noticeNO, String noticeTitle, Date noticeDate, String noticeContent, String noticeWriter,
		String originalFilePath, String renameFilePath) {
	super();
	this.noticeNO = noticeNO;
	this.noticeTitle = noticeTitle;
	this.noticeDate = noticeDate;
	this.noticeContent = noticeContent;
	this.noticeWriter = noticeWriter;
	this.originalFilePath = originalFilePath;
	this.renameFilePath = renameFilePath;
}


	public int getNoticeNO() {
	return noticeNO;
}
public void setNoticeNO(int noticeNO) {
	this.noticeNO = noticeNO;
}
public String getNoticeTitle() {
	return noticeTitle;
}
public void setNoticeTitle(String noticeTitle) {
	this.noticeTitle = noticeTitle;
}
public Date getNoticeDate() {
	return noticeDate;
}
public void setNoticeDate(Date noticeDate) {
	this.noticeDate = noticeDate;
}
public String getNoticeContent() {
	return noticeContent;
}
public void setNoticeContent(String noticeContent) {
	this.noticeContent = noticeContent;
}
public String getNoticeWriter() {
	return noticeWriter;
}
public void setNoticeWriter(String noticeWriter) {
	this.noticeWriter = noticeWriter;
}
public String getOriginalFilePath() {
	return originalFilePath;
}
public void setOriginalFilePath(String originalFilePath) {
	this.originalFilePath = originalFilePath;
}
public String getRenameFilePath() {
	return renameFilePath;
}
public void setRenameFilePath(String renameFilePath) {
	this.renameFilePath = renameFilePath;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.noticeContent+"),("+this.noticeNO+"),("+this.noticeTitle+"),("+this.noticeWriter+"),("+this.originalFilePath+"),("+this.renameFilePath+")("+this.noticeDate+")";
	}
	
	
	
}