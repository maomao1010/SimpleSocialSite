package Mao.SocialSite;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Mao.SocialSite.UserModel;

@Repository
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getAllUser(){
		  List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from userdata");
	      return users;
	}
	
	public void addUser(UserModel UserModel){
		jdbcTemplate.update("INSERT INTO userdata(UserID, Name, Phone, Email, Password, CoverImage, Biography) "
	  		+ "VALUES (?,?,?,?,?,?,?)",UserModel.GetID(), UserModel.GetName(), 
	  		UserModel.GetPhone(),UserModel.GetEmail(),UserModel.GetPassword(),
	  		UserModel.GetCoverImage(), UserModel.GetBiography());
	}
	
	public void deleteUser(String id) {
		String sql = "DELETE FROM commentdata WHERE userid = ?";
		jdbcTemplate.update(sql,id);
		sql = "DELETE FROM postdata WHERE userid = ?";
		jdbcTemplate.update(sql,id);
		sql = "DELETE FROM userdata WHERE userid = ?";
		jdbcTemplate.update(sql,id);
	}
}
