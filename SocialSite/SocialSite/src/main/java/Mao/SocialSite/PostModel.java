package Mao.SocialSite;

import org.springframework.stereotype.Component;

@Component
public class PostModel {
	private String postid;
	private String userid;
	private String content;
	private String image;
	private java.sql.Timestamp createdtime;
	
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
	public String GetImage() {
		return image;
	}
	public void SetImage(String image) {
		this.image = image;
	}
	public java.sql.Timestamp GetCreatedTime() {
		return createdtime;
	}
	public void SetCreatedTime(java.sql.Timestamp createdtime) {
		this.createdtime = createdtime;
	}
	
}
