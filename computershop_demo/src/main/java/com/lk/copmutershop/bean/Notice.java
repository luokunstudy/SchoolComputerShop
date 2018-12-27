package com.lk.copmutershop.bean;

import java.util.Date;

public class Notice {
    private Integer noticeId;

    private String wordsTitle;

    private String wordsContent;

    private Date wordsTime;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getWordsTitle() {
        return wordsTitle;
    }

    public void setWordsTitle(String wordsTitle) {
        this.wordsTitle = wordsTitle == null ? null : wordsTitle.trim();
    }

    public String getWordsContent() {
        return wordsContent;
    }

    public void setWordsContent(String wordsContent) {
        this.wordsContent = wordsContent == null ? null : wordsContent.trim();
    }

    public Date getWordsTime() {
        return wordsTime;
    }

    public void setWordsTime(Date wordsTime) {
        this.wordsTime = wordsTime;
    }

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", wordsTitle=" + wordsTitle + ", wordsContent=" + wordsContent
				+ ", wordsTime=" + wordsTime + "]";
	}

	public Notice(Integer noticeId, String wordsTitle, String wordsContent, Date wordsTime) {
		super();
		this.noticeId = noticeId;
		this.wordsTitle = wordsTitle;
		this.wordsContent = wordsContent;
		this.wordsTime = wordsTime;
	}

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}