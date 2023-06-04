package Mao.SocialSite;

import org.springframework.stereotype.Component;

@Component
public class CommentModel {
	private String commentid;
	private String postid;
	private String userid;
	private String content;
	private java.sql.Timestamp createdtime;
	
	public String GetCommentID() {
		return commentid;
	}
	public void SetCommentID(String commentid) {
		this.commentid = commentid;
	}	
	public String GetPostID() {
		return postid;
	}
	public void SetPostID(String postid) {
		this.postid = postid;
	}
	public String GetUserID() {
		return userid;
	}
	public void SetUserID(String userid) {
		this.userid = userid;
	}
	public String GetContent() {
		return content;
	}
	public void SetContent(String content) {
		this.content = content;
	}
	public java.sql.Timestamp GetCreatedTime() {
		return createdtime;
	}
	public void SetCreatedTime(java.sql.Timestamp createdtime) {
		this.createdtime = createdtime;
	}
}
