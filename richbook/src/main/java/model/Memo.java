package model;

public class Memo {
	private int MemoNo;
	private String regdate;
	private String content;
	private String memoDate;
	
	public int getMemoNo() {
		return MemoNo;
	}
	public void setMemoNo(int memoNo) {
		MemoNo = memoNo;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemoDate() {
		return memoDate;
	}
	public void setMemoDate(String memoDate) {
		this.memoDate = memoDate;
	}
}
