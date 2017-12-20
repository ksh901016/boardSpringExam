package org.hyunsworld.domain;

import java.util.Date;

public class ReplyVO {
    private int bno;
    private int rno;
    private String replyText;
    private String replyer;
    private Date regdate;
    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public int getRno() {
        return rno;
    }
    public void setRno(int rno) {
        this.rno = rno;
    }
    public String getReplyText() {
        return replyText;
    }
    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }
    public String getReplyer() {
        return replyer;
    }
    public void setReplyer(String replyer) {
        this.replyer = replyer;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    
}
