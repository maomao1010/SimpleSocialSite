package Mao.SocialSite;
import org.springframework.stereotype.Component;

@Component
public class UserModel {
	private String id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private String coverimage;
	private String biography;
	
	public String GetID() {
		return id;
	}
	public void SetID(String id) {
		this.id = id;
	}
	public String GetName() {
		return name;
	}
	public void SetName(String name) {
		this.name = name;
	}
	public String GetPhone() {
		return phone;
	}
	public void SetPhone(String phone) {
		this.phone = phone;
	}
	public String GetEmail() {
		return email;
	}
	public void SetEmail(String email) {
		this.email = email;
	}
	public String GetPassword() {
		return password;
	}
	public void SetPassword(String passowrd) {
		this.password = passowrd;
	}
	public String GetCoverImage() {
		return coverimage;
	}
	public void SetCoverImage(String coverimage) {
		this.coverimage = coverimage;
	}
	public String GetBiography() {
		return biography;
	}
	public void SetBiography(String biography) {
		this.biography = biography;
	}
	
}
